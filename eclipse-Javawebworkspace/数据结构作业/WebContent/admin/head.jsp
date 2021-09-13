<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>管理员</title>
 <link rel="stylesheet" href="${pageContext.request.contextPath }/layui/css/layui.css" media="all">
 <script src="${pageContext.request.contextPath }/layui/layui.js" charset="utf-8"></script>

</head>
<body>
<ul class="layui-nav">
  <li class="layui-nav-item ">
    <a href="javascript:;">网站管理</a>
    <dl class="layui-nav-child">
      <dd><a href="http://localhost:8080/数据结构作业/UserListServlet">用户信息</a></dd>
      <dd><a href="http://localhost:8080/数据结构作业/GoodsListServlet">商品信息</a></dd>
      <dd><a href="http://localhost:8080/数据结构作业/OrderListServlet">订单信息</a></dd>
    </dl>
  </li>
  <li class="layui-nav-item">
    <a href="javascript:;">权限管理</a>
    <dl class="layui-nav-child">
      <dd><a href="">用户权限</a></dd>
      <dd><a href="">升级管理员</a></dd>
    </dl>
  </li>
  <li class="layui-nav-item"><a href="${pageContext.request.contextPath }/GetAllOrderServlet">财务报表</a></li>
  <li class="layui-nav-item"><a href="">广告模块</a></li>
  <li class="layui-nav-item"><a href="${pageContext.request.contextPath }/shop/Shop.jsp">网站首页</a></li>
</ul>
</body>
<script>
  layui.use('element', function(){
    var element = layui.element; //导航的hover效果、二级菜单等功能，需要依赖element模块

    //监听导航点击
    element.on('nav(demo)', function(elem){
      layer.msg(elem.text());
    });
  });
</script>
</html>