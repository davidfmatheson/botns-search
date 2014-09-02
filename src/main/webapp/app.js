'use strict';

angular.module('botns-search', [
  'ui.router',
  'botns-search.books'
]).
config(['$stateProvider', '$urlRouterProvider', function($stateProvider, $urlRouterProvider) {
  $urlRouterProvider.otherwise("books");
}]);