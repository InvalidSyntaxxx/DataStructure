<%@ page language="java" import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:useBean id="userBean" class="bean.UserInfo" scope="request" />
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>个人信息</title>
 <jsp:include page="../shop/head.jsp"/>
  <link rel="stylesheet" href="${pageContext.request.contextPath }/layui/css/layui.css" media="all">
  <link rel="stylesheet" href="${pageContext.request.contextPath }/css/info.css" media="all">
  <script src="${pageContext.request.contextPath }/layui/layui.js" charset="utf-8"></script>

  </style>
</head>
  <body  style="color:black"><font size="3">  
   <div class="container" >
   *注释的选项必须填写。
  
  <form id="contact" action="http://localhost:8080/数据结构作业/UserinfoServlet" method="post">

    <input placeholder="" type="text" tabindex="1" required autofocus name="logname" readonly="readonly"  value="${sessionScope.userlogname}"   onclick='confirm("用名户作为唯一识别您的凭证不可修改哦")'>
    </fieldset>
    <fieldset>
      <input placeholder="*原始密码" type="text" tabindex="1" required  name="originpassword" >
    </fieldset>

    <fieldset>
      <input placeholder="*新密码" type="text" tabindex="1" required  name="password" >
    </fieldset>
    <fieldset >
    <input placeholder="*确定新密码" type="text" tabindex="1" required  name="again_password" >
    </fieldset>
    <fieldset >
      <input placeholder="*真实姓名" type="text" tabindex="1" required  name="realname">
    </fieldset>
        <fieldset > 
      <input  placeholder="*手机号"  type="text" tabindex="1" required name="phone"  >
    </fieldset>
        <fieldset>
      <textarea placeholder="*收货地址" tabindex="1" required type="text" name="address"></textarea>
    </fieldset>
        <fieldset>
      <textarea placeholder="*个人介绍" tabindex="5"  type="text" name="self_introduce" ></textarea>
    </fieldset>
    <fieldset>
      <button name="submit" type="submit" id="contact-submit" >提交修改</button>
    </fieldset>
  </form>

</div>
  <div align="center">
  <p>反馈：
  <jsp:getProperty property="backNews" name="userBean"/>
  <table border="3">
  <tr><td>会员名称：</td>
  <td><jsp:getProperty property="logname" name="userBean"/></td>
  </tr>
  <tr><td>真实姓名：</td>
  <td><jsp:getProperty property="realname" name="userBean"/></td>
  </tr>
  <tr><td>收货地址：</td>
  <td><jsp:getProperty property="address" name="userBean"/></td>
  </tr>
  <tr><td>电话：</td>
  <td><jsp:getProperty property="phone" name="userBean"/></td>
  </tr>
  </table>
  </div>
  </font>    
  </body>
</html>