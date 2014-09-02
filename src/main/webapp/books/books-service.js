'use strict';

angular.module('botns-search.books-service', [])
  .factory('booksService', function($http) {
    return {
      findAll: function(callback) {
        $http({
          method: 'GET',
          url: 'api/books',
          cache: true
        }).success(callback);
      }
    };
  });