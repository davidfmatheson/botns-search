'use strict';

angular.module('botns-search.books', [
  'ui.router',
  'ui.bootstrap',
  'botns-search.books-service',
  'botns-search.books-filter'
])
.config(['$stateProvider', '$urlRouterProvider', function($stateProvider, $urlRouterProvider) {
  $stateProvider
    .state('books', {
      url: '/books',
      templateUrl: 'books/books.html',
      controller: 'BooksCtrl'
    });
}])
.controller('BooksCtrl', ['$scope', 'booksService', function($scope, booksService) {
  $scope.currentPage = 1;
  $scope.itemsPerPage = 10;
  
  booksService.count(function(data){
    $scope.totalItems = data;
  });
  
  booksService.findAll($scope.currentPage - 1, $scope.itemsPerPage, function(data) {
    $scope.books = data;
  });

  $scope.pageChanged = function() {
    booksService.findAll($scope.currentPage - 1, $scope.itemsPerPage, function(data) {
      $scope.books = data;
    });
  };
}]);