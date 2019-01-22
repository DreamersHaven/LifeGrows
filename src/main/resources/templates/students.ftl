<#setting date_format="yyyy-MM-dd">
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <title>WebJars Demo</title>
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
            <li role="presentation"><a href="/students">学生管理</a></li>
            <li role="presentation"><a href="#">活动管理</a></li>
          </ul>
        </nav>
        <h3 class="text-muted">DreamersHaven</h3>
  	</div>

 <table class="table table-striped">
 
  <thead>
    <tr>
      <th>序号</th>
      <th>名称</th>
      <th>学校</th>
      <th>界</th>
      <th>专业</th>
      <th>亲密度</th>
    </tr>
  </thead>
  <tbody>
   
   <#list studentslist as students>
	 
	
    <tr>
      <td>${students.id}</td>
      <td>${students.name}</td>
      <td>${students.school}</td>
      <td>${students.session?date}</td>
      <td>${students.specialty}</td>
      <td>${students.relationship}</td>
    </tr>
   
    </#list>
    
    
  </tbody>
  
  
</table>
</div>
</body>
</html>