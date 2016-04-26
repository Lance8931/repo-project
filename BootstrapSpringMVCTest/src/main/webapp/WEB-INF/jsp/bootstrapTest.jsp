<%@ page language="java" pageEncoding="utf-8"%>  
<!DOCTYPE html>
<html lang="zh-CN">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>BootstrapTest</title>

    <link rel="stylesheet" href="/BootstrapSpringMVCTest/resources/css/bootstrap.css">
    
    <script type="text/javascript" src="/BootstrapSpringMVCTest/resources/js/jquery-2.2.1.min.js" charset="utf-8" ></script>
    <script type="text/javascript" src="/BootstrapSpringMVCTest/resources/js/bootstrap.js" charset="utf-8" ></script>
	<style type="text/css">
		body {
		  padding-top: 50px;
		}
		.starter-template {
		  padding: 40px 15px;
		  text-align: center;
		}
	</style>
  </head>
  <body>
    
	<nav class="navbar navbar-inverse navbar-fixed-top">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="#">Project name</a>
        </div>
        <div id="navbar" class="collapse navbar-collapse">
          <ul class="nav navbar-nav">
            <li class="active"><a href="#">Home</a></li>
            <li><a href="#about">About</a></li>
            <li><a href="#contact">Contact</a></li>
          </ul>
        </div><!--/.nav-collapse -->
      </div>
    </nav>

    <div class="container">

      <div class="starter-template">
        <h1>Bootstrap starter template</h1>
        <p class="lead">Use this document as a way to quickly start any new project.<br> All you get is this text and a mostly barebones HTML document.</p>
		
      </div>

    </div><!-- /.container -->
    
    <button type="button" class="btn btn-default" aria-label="Left Align">
	  <span class="glyphicon glyphicon-align-left" aria-hidden="true"></span>
	</button>
	<button type="button" class="btn btn-default btn-lg">
	  <span class="glyphicon glyphicon-star" aria-hidden="true"></span> Star
	</button>
	<div class="alert alert-danger" role="alert">
	  <span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>
	  <span class="sr-only">Error:</span>
	  Enter a valid email address
	</div>
	<div class="dropdown">
	  <button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown" 
	  		  aria-haspopup="true" aria-expanded="true">
	    Dropdown
	    <span class="caret"></span>
	  </button>
	  <ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
	    <li><a href="#">Action</a></li>
	    <li><a href="#">Another action</a></li>
	    <li><a href="#">Something else here</a></li>
	    <li><a href="#">Separated link</a></li>
	  </ul>
	</div>
	
	<div class="dropdown">
	  <button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown">
	    下拉菜单
	    <span class="caret"></span>
	  </button>
	  <ul class="dropdown-menu pull-center" role="menu" aria-labelledby="dropdownMenu1">
	    <li role="presentation"><a role="menuitem" tabindex="-1" href="#">下拉菜单项</a></li>
	    <li role="presentation"><a role="menuitem" tabindex="-1" href="#">下拉菜单项</a></li>
	    <li role="presentation"><a role="menuitem" tabindex="-1" href="#">下拉菜单项</a></li>
	    <li role="presentation" class="divider"></li>
	    <li role="presentation"><a role="menuitem" tabindex="-1" href="#">下拉菜单项</a></li>
	  </ul>
	</div>
    
    <div class="container" style="background-color:red">
	    <div class="row">
		  <div class="col-md-1">.col-md-1</div>
		  <div class="col-md-1">.col-md-1</div>
		  <div class="col-md-1">.col-md-1</div>
		  <div class="col-md-1">.col-md-1</div>
		  <div class="col-md-1">.col-md-1</div>
		  <div class="col-md-1">.col-md-1</div>
		  <div class="col-md-1">.col-md-1</div>
		  <div class="col-md-1">.col-md-1</div>
		  <div class="col-md-1">.col-md-1</div>
		  <div class="col-md-1">.col-md-1</div>
		  <div class="col-md-1">.col-md-1</div>
		  <div class="col-md-1">.col-md-1</div>
		</div>
		<div class="row">
		  <div class="col-md-8">.col-md-8</div>
		  <div class="col-md-4">.col-md-4</div>
		</div>
		<div class="row">
		  <div class="col-md-4">.col-md-4</div>
		  <div class="col-md-4">.col-md-4</div>
		  <div class="col-md-4">.col-md-4</div>
		</div>
		<div class="row">
		  <div class="col-md-6">.col-md-6</div>
		  <div class="col-md-6">.col-md-6</div>
		</div>
	</div>
	
	<blockquote>
	  <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer posuere erat a ante.</p>
	</blockquote>
	<blockquote>
	  <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer posuere erat a ante.</p>
	  <footer>Someone famous in <cite title="Source Title">Source Title</cite></footer>
	</blockquote>
	To switch directories, type <kbd>cd</kbd> followed by the name of the directory.<br>
	To edit settings, press <kbd><kbd>ctrl</kbd> + <kbd>,</kbd></kbd>
	<br />
	<br />
	
	<table class="table table-striped table-bordered table-hover table-condensed">
      <thead>
        <tr>
          <th>#</th>
          <th>First Name</th>
          <th>Last Name</th>
          <th>Username</th>
        </tr>
      </thead>
      <tbody>
        <tr>
          <th scope="row">1</th>
          <td>Mark</td>
          <td>Otto</td>
          <td>@mdo</td>
        </tr>
        <tr>
          <th scope="row">2</th>
          <td>Jacob</td>
          <td>Thornton</td>
          <td>@fat</td>
        </tr>
        <tr>
          <th scope="row">3</th>
          <td>Larry</td>
          <td>the Bird</td>
          <td>@twitter</td>
        </tr>
        <tr>
          <th scope="row">4</th>
          <td>Jane</td>
          <td>the Bird</td>
          <td>@twitter</td>
        </tr>
        <tr>
          <th scope="row">5</th>
          <td>Bobs</td>
          <td>the Bird</td>
          <td>@twitter</td>
        </tr>
      </tbody>
    </table>
	<br />
	<br />
	<form style="margin-left:20px">
	  <div class="form-group">
	    <label for="exampleInputEmail1">Email address</label>
	    <input type="email" class="form-control" id="exampleInputEmail1" placeholder="Email">
	  </div>
	  <div class="form-group">
	    <label for="exampleInputPassword1">Password</label>
	    <input type="password" class="form-control" id="exampleInputPassword1" placeholder="Password">
	  </div>
	  <div class="form-group">
	    <label for="exampleInputFile">File input</label>
	    <input type="file" id="exampleInputFile">
	    <p class="help-block">Example block-level help text here.</p>
	  </div>
	  <div class="checkbox">
	    <label>
	      <input type="checkbox"> Check me out
	    </label>
	  </div>
	  <button type="submit" class="btn btn-default">Submit</button>
	</form>
	
	<br />
	<br />
	<form class="form-inline" style="margin-left:20px">
	  <div class="form-group">
	    <label for="exampleInputName2">Name</label>
	    <input type="text" class="form-control" id="exampleInputName2" placeholder="Jane Doe">
	  </div>
	  <div class="form-group">
	    <label for="exampleInputEmail2">Email</label>
	    <input type="email" class="form-control" id="exampleInputEmail2" placeholder="jane.doe@example.com">
	  </div>
	  <button type="submit" class="btn btn-default">Send invitation</button>
	</form>
	
	<form class="form-horizontal" style="margin-left:20px">
	    <fieldset>
	      <div id="legend" class="">
	        <legend class="">表单名</legend>
	      </div>
	    <div class="control-group">
	          <!-- Select Basic -->
	          <label class="control-label">Select - Basic</label>
	          <div class="controls">
	            <select class="input-xlarge">
	              <option>Enter</option>
	              <option>Your</option>
	              <option>Options</option>
	              <option>Here!</option>
	            </select>
	          </div>
	
	        </div><div class="control-group">
	
	          <!-- Prepended text-->
	          <label class="control-label">Prepended text</label>
	          <div class="controls">
	            <div class="input-prepend">
	              <span class="add-on">^_^</span>
	              <input class="span2" placeholder="placeholder" id="prependedInput" type="text">
	            </div>
	            <p class="help-block">Supporting help text</p>
	          </div>
	
	        </div>
	
	    <div class="control-group">
	
	          <!-- Text input-->
	          <label class="control-label" for="input01">Text input</label>
	          <div class="controls">
	            <input type="text" placeholder="placeholder" class="input-xlarge">
	            <p class="help-block">Supporting help text</p>
	          </div>
	        </div>
	    </fieldset>
  	</form>	
  	
  	
  	
  	
  </body>
</html>
