Ext.define('BOTNS.view.book.List', {
  extend: 'Ext.grid.Panel',
  alias: 'widget.booklist',

  title: 'All Books',

  store: 'Books',
  
  initComponent: function() {
    this.columns = [
      {header: 'Title', dataIndex: 'title', flex: 1},
      {header: 'Author', dataIndex: 'authorFullName', flex: 1},
      {header: 'Category', dataIndex: 'categoryDescription', flex: 1}
    ];

    var self = this;
    
    this.tbar = [
      'Search',
      {
        xtype: 'textfield',
        name: 'searchField',
        hideLabel: true,
        width: 200,
        listeners: {
          change: {
            fn: self.onTextFieldChange,
            scope: this,
            buffer: 100
          }
        }
      }
    ];
    
    this.bbar = Ext.create('Ext.PagingToolbar', {
      store: this.store,
      displayInfo: true,
      displayMsg: 'Displaying topics {0} - {1} of {2}',
      emptyMsg: "No topics to display"
    });

    this.callParent(arguments);
  },
  
  onTextFieldChange: function() {
    console.log('Search field changed');
  }
});