<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="dao.GoodsInfoDao" %>
<%@ page import="bean.Goodsinfo" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
  <link rel="stylesheet" href="${pageContext.request.contextPath }/layui/css/layui.css" media="all">
</head>
<body>
<ul class="layui-nav" >
  <li class="layui-nav-item ">
    <a href="${pageContext.request.contextPath }/shop/Shop.jsp">网站购物首页</a>
  </li>
  <li class="layui-nav-item">
    <a href="javascript:;">我的信息</a>
    <dl class="layui-nav-child">
    <!-- 这里！！！！！！！！！！！！！注意显示个人信息，需要给劲！ -->
      <dd class="layui-this"><a href="${pageContext.request.contextPath }/user/userinfo.jsp">${ sessionScope.userlogname}的个人信息</a> </dd>
      <dd>
        <a href="">${ sessionScope.userlogname}的购物车</a>
      </dd>

      <dd>
        <a href="${pageContext.request.contextPath }/user/myorder.jsp" >${ sessionScope.userlogname}的全部订单</a>
      </dd>
    </dl>
  </li>
  <li class="layui-nav-item">
    <a href="javascript:;">商品分类</a>
    <dl class="layui-nav-child">
      <dd>
        <a href="http://localhost:8080/数据结构作业/ClassifyGoodsServlet?classify=男装">男装</a>
      </dd>
        <a href="http://localhost:8080/数据结构作业/ClassifyGoodsServlet?classify=女装">女装</a>
      </dd>
      <dd>
        <a href="http://localhost:8080/数据结构作业/ClassifyGoodsServlet?classify=冬装">冬装</a>
      </dd>
      <dd>
        <a href="http://localhost:8080/数据结构作业/ClassifyGoodsServlet?classify=T恤">T恤</a>
      </dd>
      <dd>
        <a href="http://localhost:8080/数据结构作业/ClassifyGoodsServlet?classify=鞋子">鞋子</a>
      </dd>
    </dl>
  </li>
  <li class="layui-nav-item">
    <a href="#">联系客服留言</a>
  </li>
  <li class="layui-nav-item" style="float: right">
    <h3>欢迎您 <b>${sessionScope.userlogname}</b></h3>
  </li>
  <li class="layui-nav-item" style="float: right">
    <a href="${pageContext.request.contextPath }/user/register.jsp">新用户注册</a>
  </li>
   <li class="layui-nav-item" style="float: right">
    <a href="${pageContext.request.contextPath }/index.jsp">切换用户</a>
  </li>
  <li class="layui-nav-item" style="float: right">
    <a href="http://localhost:8080/数据结构作业/DeloginServlet" onclick="confirm('确定注销吗？')">注销用户</a>
  </li>
</ul>
    <script src="${pageContext.request.contextPath }/layui/layui.js" charset="utf-8"></script>
  <script>
  /////////////////////导航栏///////////////////
  layui.use('element', function(){
    var element = layui.element; //导航的hover效果、二级菜单等功能，需要依赖element模块

    //监听导航点击
    element.on('nav(demo)', function(elem){
      //console.log(elem)
      layer.msg(elem.text());
    });
  });
  function delogin(){
	  
  }
</script>
</body>
</html>