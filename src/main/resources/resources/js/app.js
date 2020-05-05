'use strict';

angular.module('myApp', ['ngRoute', 'ngAnimate', 'myApp.services', 'myApp.controllers']).
  config(['$locationProvider', function($locationProvider) {
    $locationProvider.html5Mode(true);
    $locationProvider.hashPrefix('!');
  }]).
  config(['$httpProvider', function($httpProvider) {
    $httpProvider.defaults.headers.common['X-Requested-With'] = 'XMLHttpRequest';
  }]).
  config(['$routeProvider', function($routeProvider) {
    $routeProvider.when('/app/', {templateUrl: 'partials/login.html'});
    $routeProvider.when('/app/search', {templateUrl: 'partials/search.html'});
    $routeProvider.otherwise({redirectTo: 'app/'});
  }]);
