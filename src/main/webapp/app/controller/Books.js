Ext.define('BOTNS.controller.Books', {
	extend: 'Ext.app.Controller',

	views: ['book.List'],
	
	stores: ['Books'],
	models: ['Book'],
	
	init: function() {
	  this.control({
	    'booklist': {
	      itemdblclick: this.viewBook
	    }
	  });
	},

	viewBook: function(grid, record) {
	  console.log('Double-clicked on ' + record.get('title'));
	}
});