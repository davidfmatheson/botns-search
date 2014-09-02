'use strict';

angular.module('botns-search.books', [
  'ui.router',
  'botns-search.books-service'
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
  booksService.findAll(function(data) {
    $scope.books = data;
  });
}]);