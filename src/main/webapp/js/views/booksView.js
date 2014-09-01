window.BooksView = Backbone.View.extend({
	initialize : function() {
		this.model.bind("reset", this.render, this);
	},

	render : function(event) {
		var self = this;
		
		var datagrid = new Backbone.Datagrid({
			collection : self.models,
			columns : [{
				title : 'Title',
				property : 'title',
				header : true,
				sortable : true
			}]
		});

		$(this.el).html(datagrid.el);
		
		/*
		_.each(this.model.models, function(book) {
			$(this.el).append(new BookView({
				model : book
			}).render().el);
		}, this);
		*/
		
		return this;
	}
});

window.BookView = Backbone.View.extend({
	tagName : 'li',
	initialize : function() {
		this.template = _.template(tpl.get('bookView'));
	},

	render : function(event) {
		$(this.el).html(this.template(this.model.toJSON()));
		return this;
	}
});