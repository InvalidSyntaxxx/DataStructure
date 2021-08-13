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
<title>查询结果</title>
<jsp:include page="../admin/head.jsp"/>
</head>
<script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
<script type="text/javascript">

}

</script>

<body>

<div style="margin-top:10px; margin-bottom:10px;"> 
<input type="button" onclick='location="http://localhost:8080/数据结构作业/goods/addgoods.jsp"' value="新增"><%--有效！！！！ --%>
<input type="button" onclick='location="http://localhost:8080/数据结构作业/GoodsListServlet"' value="刷新"><%--有效！！！！ --%>
</div>
<table id="user_list"  border="1"  cellspacing="0" cellpadding="0" style="border:1px solid gray; border-radius:4px">
			<thead>
				<tr>
			     	<th style="width:100px;text-align:center">商品编号</th>
			     	<th style="width:200px;text-align:center">商品图片</th>
			      	<th style="width:120px;text-align:center">商品名称</th>
					<th style="width:80px;text-align:center">商品单价</th>
					<th style="width:80px;text-align:center">商品分类</th>
					<th style="width:200px;text-align:center">商品详述</th>
					<th style="width:80px;text-align:center">库存</th>
					<th style="width:80px;text-align:center">销量</th>
				</tr>		
			</thead>
      <tbody>
      <%  
      GoodsInfoDao ud = new GoodsInfoDao();
		 List<Goodsinfo> listGoods = ud.findAll(); 
		 for(Goodsinfo goods:listGoods){
		 %>
             <tr>
                   <td><%=goods.getId() %></td>
                   <td></td>
                   <td><%=goods.getName() %></td>
                 <td><%=goods.getPrice()%></td>
                  <td><%=goods.getClassify()%></td>
                    <td><%=goods.getDetail()%></td>
                    <td><%=goods.getStock() %></td>
                <td><%=goods.getSale() %></td>
                  <td>
                    <a href ="${pageContext.request.contextPath }/DeleteGoodsServlet?id=${goods.id}" onclick="return confirm('确定删除这项吗？')">删除</a>&nbsp;&nbsp;
                    <a href ="${pageContext.request.contextPath }/GetGoodsServlet?id=${goods.id}">修改</a>
                </td>
             
        <%} %> 
             </tr>      
       <%--  <c:forEach items="${list}" var="goods">
            <tr>
                <td>${goods.id}</td>
                <td> </td>
                <td>${goods.name }</td>
                <td>¥${goods.price}</td>
                <td>${goods.classify}</td>
                <td>${goods.detail}</td>
                <td>${goods.stock }</td>
                <td>${goods.sale }</td>
               <td>
                    <a href ="${pageContext.request.contextPath }/DeleteGoodsServlet?id=${goods.id}" onclick="return confirm('确定删除这项吗？')">删除</a>&nbsp;&nbsp;
                    <a href ="${pageContext.request.contextPath }/GetGoodsServlet?id=${goods.id}">修改</a>
                </td>
            </tr>
        </c:forEach> --%>
        
        
             </tbody>
		</table>
		
</body>
</html>