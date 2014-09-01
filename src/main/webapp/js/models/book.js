window.Book = Backbone.Model.extend({
	urlRoot: "resources/books"
});

window.Books = Backbone.Collection.extend({
	model: Book,
	url: "resources/books"
});