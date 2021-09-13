<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="bean.UserInfo" %>
<%@ page import="dao.UserInfoDao" %>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改页面</title>
<jsp:include page="head.jsp"/>
  <link rel="stylesheet" href="${pageContext.request.contextPath }/layui/css/layui.css" media="all">
  <link rel="stylesheet" href="${pageContext.request.contextPath }/css/info.css" media="all">
  <script src="${pageContext.request.contextPath }/layui/layui.js" charset="utf-8"></script>
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
<body >
	<%
	UserInfo user = (UserInfo)request.getAttribute("user");	
	%><div class="container">
  <form id="contact" action="http://localhost:8080/数据结构作业/UpdateUserServlet" method="post">
     用户ID（不可修改）<input value="<%=user.getId()%>" type="text" tabindex="1" required autofocus name="id" readonly="readonly" onclick='confirm("用名ID作为唯一识别您的凭证不可修改哦")'>
    </fieldset>
    <fieldset>
      用户名（不可修改）<input value="<%=user.getLogname()%>" type="text" tabindex="1" required  name="logname" readonly="readonly" onclick='confirm("用户可能会失去他的用户哦，请勿修改此项")'>
    </fieldset>
    <fieldset>
      登陆密码（不可修改）<input value="<%=user.getPassword()%>" type="text" tabindex="1" required  name="password" >
    </fieldset>
    <fieldset >
     真实姓名<input placeholder="<%=user.getRealname()%>" type="text" tabindex="1" required   name="realname" >
    </fieldset>
    <fieldset > 
      手机号<input  placeholder="<%=user.getPhone()%>"  type="text" tabindex="1" required name="phone"  >
    </fieldset>
        <fieldset>
      地址<textarea placeholder="<%=user.getAddress()%>" tabindex="1" required type="text" name="address"></textarea>
    </fieldset>
        <fieldset>
      个人介绍<textarea placeholder="<%=user.getself_introduce()%>" tabindex="5"  type="text" name="self_introduce" ></textarea>
    </fieldset>
    <fieldset>
      <button name="submit" type="submit" id="contact-submit" >提交修改</button>
    </fieldset>
  </form>
  </div>
</body>
</html>