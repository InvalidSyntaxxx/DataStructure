<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" import="java.util.*"%>
<jsp:useBean id="userBean" class="bean.UserInfo" scope="request"/>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/index.css">
    <link rel="Shortcut Icon" href="images/猪.ico" type="image/x-icon" />
   
    <title>数据结构课设</title>
</head>
 
<body>
    <section>
        <!-- 背景颜色 -->
        <div class="color"></div>
        <div class="color"></div>
        <div class="color"></div>
        <div class="box">
            <h1 id="title" >销售管理系统流程模拟</h1>
            <!-- 背景圆 -->
            <div class="circle" style="--x:0"></div>
            <div class="circle" style="--x:1"></div>
            <div class="circle" style="--x:2"></div>
            <div class="circle" style="--x:3"></div>
            <div class="circle" style="--x:4"></div>
            <!-- 登录框 -->
            <div class="container">
                <div class="form">
                    <h2 style="text-align:center" > 用户登录 </h2>
                    <form action="http://localhost:8080/数据结构作业/LoginServlet" method="post">
                        <div class="inputBox" >
                            <input type="text" placeholder="用户名"  name="userName">
                        </div>
                        <div class="inputBox">
                            <input type="password" placeholder="密码" name="pwdName"> 
                        </div>
                        <div class="inputBox">
                            <input type="submit"  value="登录">
                            <input type="reset" value="重置" class="reset">
                        </div>
                        <p class="forget">没有账户?<a href="http://localhost:8080/数据结构作业/user/register.jsp">
                                点击注册
                            </a></p>
                        <p class="admin" style="padding-top:20px"><a href="http://localhost:8080/数据结构作业/admin/adminhome.jsp">进入管理员界面</a> </p>
                          <p class="admin" style="padding-right:300px"><a href="http://localhost:8080/数据结构作业/shop/Shop.jsp">游客登录</a> </p>
                    </form>
                   
                </div>
            </div>
             <div style="algin:center"><jsp:getProperty property="backNews" name="userBean"/></div>
        </div>
    </section>
</body>
<script src="https://www.layuicdn.com/layui/layui.js"></script>
<script type="text/javascript">
</script>
</html>