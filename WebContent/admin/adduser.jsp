<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>新增</title>
	 <jsp:include page="head.jsp"/>
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
    <form  id="form" action="${pageContext.request.contextPath }/AddUserServlet" method="post">   
        会员ID：<input name="id"><br> 
        会员名：<input name="logname"><br>
        真实姓名：<input id="jobNumber" name="realname"><br>
	    地址：<input id="name" name="address"><br>
	    手机号：<input id="level" name="phone"><br>
	    个人介绍：<input id="department" name="self_introduce"><br>
	   
     <input type="submit" value="确定" > <input type="reset" value="重置" onclick="resetFun()">
    </form>
</body>
 
</html>