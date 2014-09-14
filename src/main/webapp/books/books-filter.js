'use strict';

angular.module('botns-search.books-filter', ['botns-search.books-service'])
  .filter('titleFilter', ['booksService', function(booksService) {
    return function(items, title) {
      var filtered = [];
      
      if (items && title) {
        var promise = booksService.findByTitle(title);
        
        promise.then(function(result) {
          filtered = result;
        });
      } else {
        filtered = filtered.concat(items);
      }
      
      return filtered;
    };
  }]);