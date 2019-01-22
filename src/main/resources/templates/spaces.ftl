
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <title>空间信息维护</title>
   	<script src="webjars/jquery/jquery.min.js"></script>
	<script src="webjars/bootstrap/js/bootstrap.min.js"></script>
	<link rel="stylesheet"
	href="webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>
<div class="container">
     
 <div class="header clearfix">
        <nav>
          <ul class="nav nav-pills pull-right">
            <li role="presentation" class="active"><a href="/index">首页</a></li>
            <li role="presentation"><a href="/menus">菜单管理</a></li>
            <li role="presentation"><a href="/spaces">空间管理</a></li>
          </ul>
        </nav>
        <h3 class="text-muted">DreamersHaven</h3>
  	</div>

 <table class="table table-striped">
 
  <thead>
    <tr>
      <th>序号</th>
      <th>名称</th>
      <th>地址</th>
      <th>电话</th>
      <th>描述</th>
      <th>图片链接</th>
    </tr>
  </thead>
  <tbody>
   
   <#list spaceslist as spaces>
	 
	
    <tr>
      <td>${spaces.id}</td>
      <td>${spaces.name}</td>
      <td>${spaces.address}</td>
      <td>${spaces.phone}</td>
      <td>${spaces.remarks}</td>
      <td><a href="${spaces.mapurl}">点击查看</a></td>
    </tr>
   
    </#list>
    
    
  </tbody>
  
  
</table>

 <form class="form-horizontal" action="./addspace" method ="post">
  <div class="form-group">
    <label for="name" class="col-sm-2 control-label">名称</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" name="name">
    </div>
  </div>
  <div class="form-group">
    <label for="address" class="col-sm-2 control-label">地址</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" name="address" >
    </div>
  </div>
  <div class="form-group">
      <label for="phone" class="col-sm-2 control-label">电话</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" name="phone" >
    </div>
  </div>
   <div class="form-group">
      <label for="desc" class="col-sm-2 control-label">描述</label>
    <div class="col-sm-10">
      <input  type="text" class="form-control" name="remarks" >
    </div>
  </div>
  
   <div class="form-group">
      <label for="mapurl" class="col-sm-2 control-label">地图图片URL</label>
    <div class="col-sm-10">
      <input  type="text" class="form-control" name="mapurl" >
    </div>
  </div>
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
      <button type="submit" class="btn btn-default">添加新空间</button>
    </div>
  </div>
</form>
</div>
</body>
</html>