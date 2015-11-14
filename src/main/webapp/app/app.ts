/// <reference path="../../../../typings/tsd.d.ts" />

import {Component, View, bootstrap, Inject} from 'angular2/angular2';
import {httpInjectables} from 'angular2/http';

import {Book} from './book';
import {Http} from 'angular2/http';

@Component({
    selector: 'app'
})

@View({
    templateUrl: 'app/templates/main.html'
})
class AppComponent { 
	books : Array<Book>;
	httpService : Http;
	constructor(@Inject(Http) http : Http) {
		this.httpService = http;
		this.getBooks();
	}

	getBooks() {
		var vm = this;
		this.httpService.get('http://localhost:8080/books').subscribe(
			res => {
				vm.books = JSON.parse(res._body);
			},
			error => {
				console.log(error);
			}
		)
	}
}
bootstrap(AppComponent, [httpInjectables]);
