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
<title>商品列表</title>
<link href="${pageContext.request.contextPath }/css/shop.css" rel="stylesheet" type="text/css">
<jsp:include page="../shop/head.jsp"/>
</head>

<body style="background-image:url(${pageContext.request.contextPath }/images/backgroud2.png);background-size:cover;">
   <h1 style="text-align:center ;font-size:40px">分类结果如下</h1>
   
 <div class="content" style="margin-top:100px;width:100%;height:1000px;overflow:scroll" >
  <div class="proRow">
  <%   
	 List<Goodsinfo> listGoods = (List<Goodsinfo>)request.getAttribute("goodslist");  
     int i=  (int)(1+Math.random()*25);
	 for(Goodsinfo goods:listGoods){ %>
    <div class="proBig">
      <div class="pro">
        <div class="proImg"><img src="${pageContext.request.contextPath }/images/cloth<%=i++%>.jpg"></div>
        <div class="proText">
          <h5><%=goods.getDetail() %></h5>
          <p class="proSize">库存：<%=goods.getStock() %></p>
          <p class="proPrice">￥<span><%=goods.getPrice()%></span></p>
        </div>
        <div class="proFrom"> <div style="float:left">分类：<%=goods.getClassify() %></div>销量：<%=goods.getSale() %></div>
      </div>
      <a href="#">
        <div class="proBtn">
          <div class="btn">
            <p><a href="${pageContext.request.contextPath }/BuyGoodsServlet?goods_id=<%=goods.getId()%>">立即购买</a></p>
          </div>
          <div class="btn">
            <p><a href="${pageContext.request.contextPath }/AddCartServlet?goods_id=${goods.id}">加入购物车</a></p>
          </div>
        </div>
      </a>
    </div>  
    <%} %>
  </div>
 </div>
 
</body>
</html>