Backbone.View.prototype.close = function() {
	console.log('Closing view ' + this);
	if (this.beforeClose) {
		this.beforeClose();
	}
	this.remove();
	this.unbind();
};

var AppRouter = Backbone.Router.extend({

	initialize : function() {
	},

	routes : {
		"" : "list"
	},

	list : function() {
		this.before();
	},

	bookDetails : function(id) {
		this.before(function() {
			var book = app.books.get(id);
			app.showView('#content', new BookView({
				model : book
			}));
		});
	},

	newBook : function() {
		this.before(function() {
			app.showView('#content', new BookView({
				model : new Book()
			}));
		});
	},

	showView : function(selector, view) {
		if (this.currentView)
			this.currentView.close();
		$(selector).html(view.render().el);
		this.currentView = view;
		return view;
	},

	before : function(callback) {
		if (this.books) {
			if (callback)
				callback();
		} else {
			this.books = new Books();
			this.books.fetch({
				success : function() {
					$('#sidebar').html(new BooksView({
						model : app.books
					}).render().el);
					if (callback)
						callback();
				}
			});
		}
	}

});

tpl.loadTemplates([ 'bookView' ], function() {
	app = new AppRouter();
	Backbone.history.start();
});