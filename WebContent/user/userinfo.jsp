<%@ page language="java" import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:useBean id="userBean" class="bean.UserInfo" scope="request"/>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>个人信息</title>
 <jsp:include page="../shop/head.jsp"/>
  <link rel="stylesheet" href="../layui/css/layui.css" media="all">
  <script src="../layui/layui.js" charset="utf-8"></script>
</head>
  <body  style="color:black"><font size="3">
  <div align="center">
  <form action="../UserinfoServlet" method="post" name=form>
  <table>
       用名户由字母、数字、下划线组成，*注释的选项必须填写。
  <br>
  <tr>
  <td>*用户名称：</td><td><input type="text" name="logname"/></td>
  <td>*用户密码：</td><td><input type="password" name="password"/></td>
  </tr>
  <tr>
  <td>*重复密码：</td><td><input type="password" name="again_password"/></td>
  <td>联系电话：</td><td><input type="text" name="phone"/></td>
  </tr>
  <tr>
  <td>收货地址：</td><td><input type="text" name="address"/></td>
  <td>真实姓名：</td><td><input type="text" name="realname"/></td>
  <td><input type="submit"  value="提交"/></td>
  </tr>
  </table>
  </form>
  </div>
  <div align="center">
  <p>注册反馈：
  <jsp:getProperty property="backNews" name="userBean"/>
  <table border="3">
  <tr><td>会员名称：</td>
  <td><jsp:getProperty property="logname" name="userBean"/></td>
  </tr>
  <tr><td>姓名：</td>
  <td><jsp:getProperty property="realname" name="userBean"/></td>
  </tr>
  <tr><td>地址：</td>
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