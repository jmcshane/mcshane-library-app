'use strict';

var GulpConfig = (function () {
    function GulpConfig() {
        this.src = './src/main/webapp';
        this.dest = './src/main/resources/static';
        this.typingsDir = './typings';

        this.outputFile = 'library';
        this.outputCSSDir = '/css';
        this.outputLibDir = '/lib';

        this.mainLessFile = this.src + '/assets/styles/main.less';
        this.allHTML = [
            this.src + '/*.html',
            this.src + '/**/*.html'
        ];
        this.allLess = this.src + '/**/*.less';
        this.allTypeScript = this.src + '/**/*.ts';
        this.allLib = [
            'src/main/webapp/bower_components/traceur-runtime/traceur-runtime.js'
        ];

        this.libraryTypeScriptDefinitions = this.typingsDir + '/**/*.ts';
        this.appTypeScriptReferences = this.typingsDir + '/tsd.d.ts';
    }

    return GulpConfig;
})();

module.exports = GulpConfig;