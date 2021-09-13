<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="dao.GetAllOrderDao" %>
<%@ page import="bean.Order" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>订单详情</title>
 <jsp:include page="../admin/head.jsp"/>
  <link href="${pageContext.request.contextPath }/css/table.css" rel="stylesheet" type="text/css">
  <link rel="stylesheet" href="${pageContext.request.contextPath }/layui/css/layui.css" media="all">
</head>
<body>

<div style="margin-top:10px; margin-bottom:10px; "> 
<input class="layui-btn" type="button" onclick='location="http://localhost:8080/数据结构作业/OrderlistServlet"' value="刷新"><%--有效！！！！ --%>
</div>
<table id="user_list"  border="1"  cellspacing="0" cellpadding="0" style="border:1px solid gray; border-radius:4px">
			<thead>
				<tr>
			     	<th style="width:200px;text-align:center">订单号</th>
			     	<th style="width:200px;text-align:center">商品名称</th>
			        <th style="width:100px;text-align:center">下单时间</th>
			      	<th style="width:300px;text-align:center">收货地址</th>
					<th style="width:120px;text-align:center">收货人姓名</th>
					<th style="width:150px;text-align:center">手机号</th>
					<th style="width:150px;text-align:center">订单状态</th>
					<th style="width:300px;text-align:center">操作</th>
				</tr>		
			</thead>
      <tbody>

        <c:forEach items="${list}" var="order">
            <tr >
                <td>${order.order_id}</td>
                <td>${order.goods_name}</td>
                <td>${order.date}</td>
                <td>${order.address}</td>
                <td>${order.realname}</td>
                <td>${order.phone}</td>
        
               <td> <c:choose>
                 <c:when test="${order.status==1}">
                 已下单未支付
                 </c:when>
                 <c:when test="${order.status==2 }">
                 已支付未发货
                 </c:when>
                  <c:when test="${order.status==3 }">
                 已发货未收货
                 </c:when>
                  <c:when test="${order.status==4 }">
                 已收货订单完成
                 </c:when>
                 </c:choose>
              </td>
               <td>
                   <a class="layui-btn layui-btn-primary layui-border-red" href ="${pageContext.request.contextPath }/GetUserServlet?id=${user.order_id}">删除</a>
                </td>
            </tr>
        </c:forEach> 
        </tbody>
</table>
   
</body>
</html>