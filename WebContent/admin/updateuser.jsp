<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="bean.UserInfo" %>
<%@ page import="dao.UserInfoDao" %>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改</title>
	 <jsp:include page="head.jsp"/>
</head>
<script>
	function confirmFun(){
		var x1 = document.getElementById("name").value;
		var x2 = document.getElementById("jobNumber").value;
		var x3 = document.getElementById("level").value;
		var x4 = document.getElementById("department").value;
		var x5 = document.getElementById("role").value;
 
		if(x1==""||isNaN(x1)||x2==""||isNaN(x2)||x3==""||isNaN(x3)||x4==""||isNaN(x4)
				||x5==""||isNaN(x5)){
			 alert("添加信息不完整");
			 return;
		}		
		document.getElementById("updform").submit();
	}
	
	function resetFun(){
		var spans = document.getElementsByTagName("input");
		for(var i=0;j<spans.length;i++){  
			var span = spans[i]; // input标签的数组
			document.getElementById(span.id).value ="";//
			console.info(span.id);
		}
	}
</script>
<body>
 <h3>修改页面</h3>
	<%
	UserInfo user = (UserInfo)request.getAttribute("user");	
	%>
    <form id="updform" action="${pageContext.request.contextPath }/UpdateUserServlet" method="post">
            用户ID：<input type="text" readonly="readonly" name="id" value="<%=user.getId()%>"><p>会员ID作为唯一凭证，此项不可修改哦</p><br>
	        用户名：<input name="logname" value="<%=user.getLogname()%>"><br>
	        登陆密码：<input name="password" value="<%=user.getPassword()%>"><br>
		    真实姓名：<input name="realname" value="<%=user.getRealname()%>"> <br>
		    手机号：<input name="phone" value="<%=user.getPhone()%>"><br>
		    地址：<input name="address" value="<%=user.getAddress()%>"><br>
		    个人介绍：<input name="self_introduce" value="<%=user.getself_introduce()%>"><br>
	    <input type="submit" value="确定"  onclick="confirmFun()">  <input type="reset" value="重置"  onclick="resetFun()">
    </form>
</body>
</html>