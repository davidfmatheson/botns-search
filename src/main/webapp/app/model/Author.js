Ext.define('BOTNS.model.Author', {
  extend: 'Ext.data.Model',
  fields: [
    {name: 'firstName', type: 'string'},
    {name: 'lastName', type: 'string'},
    {
      name: 'fullName', 
      type: 'string',
      convert: function(v, record) {
        return record.get('lastName') + ', ' + record.get('firstName');
      }
    }
  ]
});