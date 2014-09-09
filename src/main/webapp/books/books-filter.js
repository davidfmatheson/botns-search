'use strict';

angular.module('botns-search.books-filter', ['botns-search.books-service'])
  .filter('title-filter', ['bookService', function(bookService) {
    return function(title) {
      bookService.findByTitle(title, function(data) {
        return data;
      });
    }
  }]);