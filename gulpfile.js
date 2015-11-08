var gulp = require('gulp'),
	tsc = require('gulp-typescript'),
	sourcemaps = require('gulp-sourcemaps'),
	tslint = require('gulp-tslint'),
    less = require('gulp-less'),
    typescript = require('typescript'),
    plumber = require('gulp-plumber'),
    del = require('del'),
    runSequence = require('run-sequence'),
    rename = require('gulp-rename'),
    Config = require('./gulpfile.config'),
    config = new Config();

gulp.task('ts-lint', function () {
    return gulp.src(config.allTypeScript)
        .pipe(tslint())
        .pipe(tslint.report('prose'));
});

gulp.task('clean', function (done) {
    del([
        config.dest + '/**'
    ], done);
});

gulp.task('compile-ts', function() {
	var sourceTsFiles = [
	        config.allTypeScript,
	    	config.libraryTypeScriptDefinitions,
	    	config.appTypeScriptReferences
	    ],
	    tsResult = gulp.src(sourceTsFiles)
	    	.pipe(sourcemaps.init())
	    	.pipe(tsc({
	    		typescript : typescript,
	    		module : 'commonjs',
	    		target : 'ES5',
	    		emitDecoratorMetadata : true,
	    		experimentalDecorators : true,
	    		declarationFiles : false,
	    		noExternalResolve : true
	    	}));
	tsResult.dts
		.pipe(gulp.dest(config.dest));
	
	return tsResult.js.pipe(sourcemaps.write('.'))
		.pipe(gulp.dest(config.dest));	
});

gulp.task('styles', function () {
    return gulp.src(config.mainLessFile)
        .pipe(plumber())
        .pipe(less())
        .pipe(rename(config.outputFile + '.css'))
        .pipe(gulp.dest(config.dest + config.outputCSSDir));
});

gulp.task('copy-lib', function () {
   return gulp.src(config.allLib)
       .pipe(gulp.dest(config.dest + config.outputLibDir));
});

gulp.task('copy-html', function () {
    return gulp.src(config.allHTML)
        .pipe(gulp.dest(config.dest));
});

gulp.task('watch', function() {
    gulp.watch([config.allTypeScript], ['ts-lint', 'compile-ts']);
    gulp.watch([config.allLess], ['styles']);
    gulp.watch([config.allHTML], ['copy-html']);
});

gulp.task('default', function() {
	runSequence(
		'ts-lint',
		'compile-ts',
		['copy-lib', 'copy-html', 'styles'],
		'watch'
	);
})