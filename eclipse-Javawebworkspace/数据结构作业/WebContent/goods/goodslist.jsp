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
  <link href="${pageContext.request.contextPath }/css/table.css" rel="stylesheet" type="text/css">

</head>
<script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
<script type="text/javascript">

}

</script>

<body>

<div style="margin-top:10px; margin-bottom:10px;"> 
<input  class="layui-btn" type="button" onclick='location="http://localhost:8080/数据结构作业/goods/addgoods.jsp"' value="新增"><%--有效！！！！ --%>
<input  class="layui-btn" type="button" onclick='location="http://localhost:8080/数据结构作业/GoodsListServlet"' value="刷新"><%--有效！！！！ --%>
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
					<th style="width:180px;text-align:center">操作</th>
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
                    <a class="layui-btn layui-btn-primary layui-border-green" href ="http://localhost:8080/数据结构作业/GetGoodsServlet?id=<%=goods.getId()%>">修改</a>
                    <a class="layui-btn layui-btn-primary layui-border-red" href ="http://localhost:8080/数据结构作业/DeleteGoodsServlet?id=<%=goods.getId()%>" onclick="return confirm('确定下架这件商品吗？')">商品下架</a>&nbsp;&nbsp;           
                </td>
             
        <%} %> 
             </tr>      

             </tbody>
		</table>
		
</body>
</html>