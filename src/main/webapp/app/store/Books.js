Ext.define('BOTNS.store.Books', {
  extend: 'Ext.data.Store',
  model: 'BOTNS.model.Book',
  autoLoad: true,
  remoteSort: true,
  
  proxy: {
    type: 'ajax',
    url: 'resources/books',
    reader: {
      type: 'json',
      root: 'content',
      totalProperty: 'totalElements'
    }
  }
});