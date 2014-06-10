grgxStyle =
[
  {
    selector: 'node',
    css: {
      'content': 'data(id)',
      'text-valign': 'center',
      'text-halign': 'center',
      'background-color': 'darkgray'
    }
  },
  {
    selector: '$node > node',
    css: {
      'padding-top': '20px',
      'padding-left': '10px',
      'padding-bottom': '10px',
      'padding-right': '10px',
      'text-valign': 'top',
      'text-halign': 'center'
    }
  },
  {
    selector: 'node[!tf]',
    css: {
      'shape': 'rectangle'
    }
  },
  {
    selector: 'edge[type = "a"]',
    css: {
      'target-arrow-shape': 'triangle',
      'line-color': 'blue',
      'target-arrow-color': 'blue'
    }
  },
  {
    selector: 'edge[type = "r"]',
    css: {
      'target-arrow-shape': 'tee',
      'line-color': 'red',
      'target-arrow-color': 'red'
    }
  },
  {
    selector: 'edge[type = "u"]',
    css: {
      'target-arrow-shape': 'circle',
    }
  },
  {
    selector: ':selected',
    css: {
      'background-color': 'gray',
      'line-color': 'black',
      'target-arrow-color': 'black',
      'source-arrow-color': 'black'
    }
  }
]
