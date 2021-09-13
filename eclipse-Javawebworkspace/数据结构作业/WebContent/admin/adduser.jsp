<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>新增</title>
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

<div class="container">
  <form id="contact" action="http://localhost:8080/数据结构作业/AddUserServlet" method="post">
  <h3 style="text-align:center">*为必填项</h3>
     *用户ID<input placeholder=" " type="text" tabindex="1" required autofocus name="id"  >
    </fieldset>
    <fieldset>
      *用户名<input placeholder="" type="text" tabindex="1" required  name="logname" >
    </fieldset>
    <fieldset>
      *登陆密码<input placeholder="" type="text" tabindex="1" required  name="password" >
    </fieldset>
    <fieldset >
    *真实姓名<input placeholder="" type="text" tabindex="1" required   name="realname" >
    </fieldset>
    <fieldset > 
     * 手机号<input  placeholder=""  type="text" tabindex="1" required name="phone"  >
    </fieldset>
        <fieldset>
      *地址<textarea placeholder="" tabindex="1" required type="text" name="address"></textarea>
    </fieldset>
        <fieldset>
      个人介绍<textarea placeholder="" tabindex="5"  type="text" name="self_introduce" ></textarea>
    </fieldset>
    <fieldset>
      <button name="submit" type="submit" id="contact-submit" onclick='confirm("确认信息信息填写无误了吗")' >增加用户</button> 
    </fieldset>
  </form>
  </div>    

</body>
 
</html>