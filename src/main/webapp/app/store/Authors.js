Ext.define('BOTNS.store.Authors', {
  extend: 'Ext.data.Store',
  model: 'BOTNS.model.Author',
  autoLoad: true,
  
  proxy: {
    type: 'ajax',
    url: 'resources/authors',
    reader: {
      type: 'json'
    }
  }
});