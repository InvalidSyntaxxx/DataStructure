<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>新增</title>
<jsp:include page="../admin/head.jsp"/>
</head>
<script>
	function confirmFun(){		
		var x1 = document.getElementById("name").value;
		var x2 = document.getElementById("jobNumber").value;
		var x3 = document.getElementById("level").value;
		var x4 = document.getElementById("department").value;
		var x5 = document.getElementById("role").value;
		if(x1==""||x2==""||x3==""||x4==""||x5==""){
			 alert("添加信息不完整");
			 return;
		}		
		document.getElementById("form").submit();
	}
	
	function resetFun(){
		var spans = document.getElementsByTagName("input");
		for(var j=0;j<spans.length;j++){  
			var span = spans[j]; // input标签的数组
			document.getElementById(span.id).value ="";//
			console.info(span.id);
		}
		
	}
</script>
 
<body>
 <h3>新增页面</h3>
    <form  id="form" action="../AddGoodsServlet" method="post">   
        商品编号：<input name="id"><br> 
        商品名称：<input name="name"><br>
        商品单价：<input id="" name="price"><br>
        <label>商品分类:</label>
        <select name="classify">
          <option value="男装">男装</option>
          <option value="女装">女装</option>
          <option value="T恤">T恤</option>
          <option value="潮鞋">潮鞋</option>
          <option value="裤子">裤子</option>
          <option value="折扣">折扣</option>
          <option value="大衣">大衣</option>
        </select><br>
	    商品详述：<input id="name" name="detail"><br>
	    商品库存：<input id="level" name="stock"><br>  
     <input type="submit" value="确定" > <input type="reset" value="重置" onclick="resetFun()">
    </form>
</body>
 
</html>