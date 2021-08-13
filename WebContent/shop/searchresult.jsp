<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="dao.GoodsInfoDao" %>
<%@ page import="bean.Goodsinfo" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="referrer" content="never">
  <title>查询结果</title>
  <link href="${pageContext.request.contextPath }/css/shop.css" rel="stylesheet" type="text/css">
  <link rel="stylesheet" href="${pageContext.request.contextPath }/layui/css/layui.css" media="all">
  <jsp:include page="../shop/head.jsp"/>
</head>
<body>

<div id="top">
  <div id="top2">
  
    <div style="float: right; margin-right: 10px;">
    
      <form action="../SearchListServlet" class="search" method="get">
      <input placeholder="请输入你想搜索的商品" type="text" name="search"  />
      <input type="submit" value="搜 索"  style="height: 40px" />
      </form>
    </div>
</div>
</div>
<table id="user_list"  border="1"  cellspacing="0" cellpadding="0" style="border:1px solid gray; border-radius:4px">
			<thead>
				<tr>
			     	<th style="width:100px;text-align:center">商品名</th>
			     	<th style="width:100px;text-align:center">商品价格</th>
			      	<th style="width:120px;text-align:center">商品销量</th>
					<th style="width:80px;text-align:center">商品库存</th>
				</tr>		
			</thead>
      <tbody>
        <c:forEach items="${list}" var="Goods">
            <tr>
                <td>${Goods.name}</td>
                <td>${Goods.price }</td>
            </tr>
        </c:forEach>
             </tbody>
		</table>
</body>
</html>