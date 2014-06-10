<!DOCTYPE html>
<html>
	<head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
        <meta name="description" content="Grassius Regulatory Grid Explorer - A visual browser for regulatory networks.">
        <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css" />
		<title>GRG-X</title>
		<style type="text/css" media="screen">
            #cy {
                margin-bottom:15px;
                border-style:solid;
                border-width:1px;
            }
		</style>
	</head>
	<body>
        <div class="container-fluid">
            <div class="row" id="header-row">
                <div class="col-md-12 page-header">
                    <h1>GRG-X: <small><b>G</b>rassius <b>R</b>egulatory <b>G</b>rid e<b>X</b>plorer</small></h1>
                </div>
            </div>
            <div class="row-fluid">
                <div class="col-md-3">
                    <div class="input-group">
                        <input type="search" class="form-control" id="grgxsearch" placeholder="Search" />
                        <span class="input-group-btn">
                            <button class="btn btn-default" type="button"><span class="glyphicon glyphicon-search"></span></button>
                        </span>
                    </div>
                </div>
                <div id="cy" class="col-md-9"></div>
            </div>
        </div>
        <script src="//code.jquery.com/jquery-2.1.1.min.js"></script>
        <script src="//netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>
        <script>
            $(window).resize(function(){
                $('#cy').height( $(window).height() - $("#header-row").height()
                        - parseInt($("#header-row").css("margin-bottom"))
                        - parseInt($("#header-row").css("margin-top"))
                        - parseInt($('#cy').css("margin-bottom"))
                        - 2*parseInt($('#cy').css("border-width"))
                );
            })
            $(window).resize();
        </script>
        <script src="./js/cytoscape.min.js"></script>
        <script src="./js/grgx_vars.js"></script>
        <script src="./js/grgx.js"></script>
        <script>$(window).resize();</script>
	</body>
</html>