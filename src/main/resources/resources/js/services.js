'use strict';

 /* User Service */

angular.module('myApp.services', [])
.factory('UserService', ["$http", '$location', function($http, $location) {
    var url ="http://localhost:8080/app/";
    var service = {};
    var loginUser;

    service.saveUser = function(userForm) {
        var dataArr = userForm;
        $http.post(url + 'api/user', dataArr).then(function (response) {

             loginUser =response.data;
            $location.path('/app/search');
        }, function error(response) {
           alert("Error Status: " +  response.statusText);
        });
    }

    service.getUser= function(userId) {
       return $http.get(url + 'api/user/' + userId)
           .then(function(response) {
            return response;
        }, function Error(response) {
               return response;
           });
    }

    service.getloginUser = function() {
        return loginUser;
    }
    return service;
}]);
