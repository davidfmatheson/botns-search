Ext.define('BOTNS.model.Book', {
  extend: 'Ext.data.Model',
  fields: [
    { name: 'title', type: 'string' },
    { name: 'authorFirstName', type: 'string', mapping: 'authors[0].firstName'},
    { name: 'authorLastName', type: 'string', mapping: 'authors[0].lastName'},
    { name: 'categoryDescription', type: 'string', mapping: 'category.description'},
    
    {
      name: 'authorFullName', 
      type: 'string', 
      convert: function(v, record) {
        return record.get('authorLastName') + ', ' + record.get('authorFirstName');
      }
    }
  ],
  hasMany: [
    {
      name: 'authors',
      model: 'BOTNS.model.Author'
    }
  ]
});