<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="dao.UserInfoDao" %>
<%@ page import="bean.UserInfo" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>查询结果</title>
<jsp:include page="head.jsp"/>

</head>
<script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
<script type="text/javascript">

function delFun(String logname){
	alert(logname+"删除成功！");
}	
}

</script>

<body>

<div style="margin-top:10px; margin-bottom:10px;"> 
<%--<input type="button" onclick='location="http://localhost:8080/数据结构作业/admin/rightinfo.jsp"' value="返回"> --%>
<input type="button" onclick='location="http://localhost:8080/数据结构作业/admin/adduser.jsp"' value="新增"><%--有效！！！！ --%>
<input type="button" onclick='location="http://localhost:8080/数据结构作业/UserListServlet"' value="刷新"><%--有效！！！！ --%>
</div>
<table id="user_list"  border="1"  cellspacing="0" cellpadding="0" style="border:1px solid gray; border-radius:4px">
			<thead>
				<tr>
			     	<th style="width:100px;text-align:center">会员ID</th>
			     	<th style="width:100px;text-align:center">用户名</th>
			      	<th style="width:120px;text-align:center">用户密码</th>
					<th style="width:80px;text-align:center">真实姓名</th>
					<th style="width:150px;text-align:center">手机号</th>
					<th style="width:120px;text-align:center">常住地址</th>
					<th style="width:50px;text-align:center">新老客户</th>
			        <th style="width:150px;text-align:center">个人描述</th>
					<th style="width:180px;text-align:center">操作</th>
				</tr>		
			</thead>
      <tbody>
        <c:forEach items="${list}" var="user">
            <tr>
                <td>${user.id}</td>
                <td>${user.logname }</td>
                <td>${user.password}</td>
                <td>${user.realname}</td>
                <td>${user.phone }</td>
                <td>${user.address }</td>
                <td>${user.new_old}</td>
                <td>${user.self_introduce}</td>
               <td>
                    <a href ="${pageContext.request.contextPath }/DeleteUserServlet?id=${user.id}" onclick="return confirm('确定删除这项吗？')">删除</a>
                    <a href ="${pageContext.request.contextPath }/GetUserServlet?id=${user.id}">修改</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
</table>
		<div style="width:800px">	    
		<c:choose>
			<c:when test="${page.pageNum<=1}">
				<a href="${pageContext.request.contextPath }/UserListServlet?pageNum = 1 ">前一页</a>
			</c:when>
			<c:otherwise>
				<a href="${pageContext.request.contextPath }/UserListServlet?pageNum=${page.pageNum-1}">前一页</a>
			</c:otherwise>
		</c:choose>
	
    	<c:forEach var="i" begin="1" end="${page.pageTotal}" step="1">
			<a href="${pageContext.request.contextPath }/UserListServlet?pageNum=${i}">${i}</a>
		</c:forEach>
		
		<c:choose>
			<c:when test="${page.pageNum >= page.pageTotal}%>">
				<a href="${pageContext.request.contextPath }/UserListServlet?pageNum=${page.pageTotal}">后一页</a>
			</c:when>
			<c:otherwise>
				<a href="${pageContext.request.contextPath }/UserListServlet?pageNum=${page.pageNum + 1}">后一页</a>
			</c:otherwise>
		</c:choose>		
		<span style="margin-left:10px">一共${page.pageTotal}页</span>
	</div>

</body>
</html>