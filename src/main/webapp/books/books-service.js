'use strict';

angular.module('botns-search.books-service', [])
  .factory('booksService', function($http) {
    return {
      findAll: function(page, size, callback) {
        $http({
          method: 'GET',
          url: 'api/books',
          params: {page: page, size: size},
          cache: true
        }).success(callback);
      },
      findByTitle: function(title, callback) {
        $http({
          method: 'GET',
          url: 'api/books/search',
          params: {title: title},
          cache: false
        }).success(callback);
      },      
      count: function(callback) {
        $http({
          method: 'GET',
          url: 'api/books/count',
          cache: true
        }).success(callback);
      }
    };
  });