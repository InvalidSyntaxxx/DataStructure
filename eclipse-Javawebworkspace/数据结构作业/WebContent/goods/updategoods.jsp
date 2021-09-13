<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="bean.Goodsinfo" %>
<%@ page import="dao.GoodsInfoDao" %>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改页面</title>
<jsp:include page="../admin/head.jsp"/>
  <link rel="stylesheet" href="${pageContext.request.contextPath }/layui/css/layui.css" media="all">
  <link rel="stylesheet" href="${pageContext.request.contextPath }/css/info.css" media="all">
  <script src="${pageContext.request.contextPath }/layui/layui.js" charset="utf-8"></script>
</head>
<script>
	
	
	function resetFun(){
		var spans = document.getElementsByTagName("input");
		for(var i=0;j<spans.length;i++){  
			var span = spans[i]; // input标签的数组
			document.getElementById(span.id).value ="";//
			console.info(span.id);
		}
	}
</script>
<body >
	<%
	Goodsinfo goods = (Goodsinfo)request.getAttribute("list");	
	%><div class="container">
  <form id="contact" action="http://localhost:8080/数据结构作业/UpdateUserServlet" method="post">
     商品ID（不可修改）<input value="<%=goods.getId()%>" type="text" tabindex="1" required autofocus name="id" readonly="readonly" onclick='confirm("用名ID作为唯一识别您的凭证不可修改哦")'>
    </fieldset>
    <fieldset>
      商品名<input value="<%=goods.getName()%>" type="text" tabindex="1" required  name="logname" readonly="readonly" onclick='confirm("用户可能会失去他的用户哦，请勿修改此项")'>
    </fieldset>
    <fieldset>
      商品价格<input value="<%=goods.getPrice()%>" type="text" tabindex="1" required  name="password" >
    </fieldset>
    <fieldset >
      商品类别<input placeholder="<%=goods.getClassify()%>" type="text" tabindex="1" required   name="realname" >
    </fieldset>
    
        <fieldset>
      商品库存<input placeholder="<%=goods.getStock()%>" tabindex="1" required type="text" name="address">
    </fieldset>
        <fieldset>
     商品销量<input placeholder="<%=goods.getSale()%>" tabindex="5"  type="text" name="self_introduce" >
    </fieldset>
    <fieldset > 
      商品详述<textarea  placeholder="<%=goods.getDetail()%>"  type="text" tabindex="1" required name="phone"></textarea>
    </fieldset>
    <fieldset>
      <button name="submit" type="submit" id="contact-submit" >提交修改</button>
    </fieldset>
  </form>
  </div>
</body>
</html>