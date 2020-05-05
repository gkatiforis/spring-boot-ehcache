'use strict';

/* Controllers */
angular.module('myApp.controllers', [])
  .controller('IndexCtrl', ['$scope', '$location','UserService', function($scope, $location, UserService) {
     $scope.loginUser = UserService.getloginUser();
      if($scope.loginUser != null){
          $location.path('/app/search');
      }

      $scope.saveUser = function(){
          if($scope.userForm){
              UserService.saveUser($scope.userForm);
          }else{
              alert("Please Fill Out user Info!");
          }
      }
  }])
  .controller('Page1Ctrl', ['$scope', '$location', 'UserService', function($scope, $location, UserService) {

       $scope.loginUser = UserService.getloginUser();
       if($scope.loginUser == null){
           $location.path('/app/');
       }

      $scope.findUser = function () {
          if($scope.userId){
             UserService.getUser($scope.userId).then(function(response){
                 if(response.status == "404")
                     $scope.user="";
                 else
                   $scope.user = response.data;
             });
          }else{
              alert("Please input user id!");
          }
      }

  }]);
