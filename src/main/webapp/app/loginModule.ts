/// <reference path="../../../../typings/tsd.d.ts" />

import {Component, View, bootstrap} from 'angular2/angular2';

@Component({
    selector: 'login-module',
})
@View({
	templateUrl : 'app/templates/loginModule.html'
})
export class LoginModule { 
	username : string;
	authenticated : boolean;

	constructor() {
		this.username = '';
		this.authenticated = false;
	}
}
bootstrap(LoginModule);