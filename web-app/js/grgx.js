$(function(){ // on dom ready

$('#cy').cytoscape({
  style: grgxStyle,

  elements: {
    nodes: [
      { data: { id: 'a', parent: 'b', tf: true } },
      { data: { id: 'b' } },
      { data: { id: 'c', parent: 'b', tf: true } },
      { data: { id: 'd' } },
      { data: { id: 'e', tf: true } },
      { data: { id: 'f' } }
    ],
    edges: [
      { data: { id: 'ad', source: 'a', target: 'd', type: 'r' } },
      { data: { id: 'bf', source: 'b', target: 'f', type: 'a' } },
      { data: { id: 'ec', source: 'e', target: 'c', type: 'u' } }
      
    ]
  },
  
  layout: {
    name: 'cose',
    padding: 5
  },
  
  ready: function(){
    window.cy = this;
  }
});

}); // on dom ready
