<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>注册</title>
<link rel="Shortcut Icon" href="../images/猪.ico" type="image/x-icon" />
 <jsp:include page="../shop/head.jsp"/>
</head>
<style type="text/css">
* {
      margin: 0;
      padding: 0;
      box-sizing: border-box;
}
section {
    /* 相对定位 */
    position: relative;
    overflow: hidden;
    display: flex;
    justify-content: center;
    align-items: center;
    min-height: 100vh;
    /* linear-gradient() 函数用于创建一个表示两种或多种颜色线性渐变的图片 */
    background: linear-gradient(to bottom, #f1f4f9, #dff1ff);
}

/* 背景颜色 */

section .color {
    position: absolute;
   /* 使用filter(滤镜) 属性，给图像设置高斯模糊*!*/
    filter: blur(200px);
}


#title{
    text-align:center ;
    height:100px ;
    font-size: 50px;
    color: dodgerblue;
    margin-top: 20px;
}
section .color:nth-child(1) {
    top: -350px;
    width: 600px;
    height: 600px;
    background: #0c0b0c;
}

section .color:nth-child(2) {
    bottom: -150px;
    left: 100px;
    width: 500px;
    height: 500px;
    background: #131312;
}

section .color:nth-child(3) {
    bottom: 50px;
    right: 100px;
    width: 500px;
    height: 500px;
    background: #17191a;
}

.box {
    position: relative;
}

/* 背景圆样式 */

.box .circle {
    position: absolute;
    background: rgba(255, 255, 255, 0.1);
    backdrop-filter: blur(5px);
    box-shadow: 0 25px 45px rgba(0, 0, 0, 0.1);
    border: 1px solid rgba(255, 255, 255, 0.5);
    border-right: 1px solid rgba(255, 255, 255, 0.2);
    border-bottom: 1px solid rgba(255, 255, 255, 0.2);
    border-radius: 50%;
    filter: hue-rotate(calc(var(--x) * 70deg));
    animation: animate 10s linear infinite;
    animation-delay: calc(var(--x) * -1s);
}

/* 背景圆动画 */

@keyframes animate {
    0%, 100%{
        transform: translateY(-50px);
    }
    50% {
        transform: translateY(50px);
    }
}

.box .circle:nth-child(1) {
    top: -50px;
    right: -60px;
    width: 100px;
    height: 100px;
}

.box .circle:nth-child(2) {
    top: 150px;
    left: -100px;
    width: 120px;
    height: 120px;
    z-index: 2;
}

.box .circle:nth-child(3) {
    bottom: 50px;
    right: -60px;
    width: 80px;
    height: 80px;
    z-index: 2;
}

.box .circle:nth-child(4) {
    bottom: -80px;
    left: 100px;
    width: 60px;
    height: 60px;
}

.box .circle:nth-child(5) {
    top: -80px;
    left: 140px;
    width: 60px;
    height: 60px;
}

/* 登录框样式 */

.container {
    position: relative;
    width: 500px;
    min-height: 400px;
    background: rgba(255, 255, 255, 0.1);
    display: flex;
    justify-content: center;
    align-items: center;
    backdrop-filter: blur(5px);
    box-shadow: 0 25px 45px rgba(0, 0, 0, 0.1);
    border: 1px solid rgba(255, 255, 255, 0.5);
    border-right: 1px solid rgba(255, 255, 255, 0.2);
    border-bottom: 1px solid rgba(255, 255, 255, 0.2);
}

.form {
    position: relative;
    width: 100%;
    height: 100%;
    padding: 50px;
}

/* 登录标题样式 */

.form h2 {
    position: relative;
    color: #fff;
    font-size: 24px;
    font-weight: 600;
    letter-spacing: 5px;
    margin-bottom: 30px;
    /*cursor: pointer;*/
}

/* 登录标题的下划线样式 */

.form h2::before {
    content: "";
    position: absolute;
    /*right: 1000px;*/
    bottom: -10px;
    width: 0px;
    height: 3px;
    background: #0080ff;
    transition: 1s;
}

.form h2:hover:before {
    width: 110px;
}

.form .inputBox {
    width: 100%;
    margin-top: 20px;
}

/* 输入框样式 */

.form .inputBox input {
    width: 100%;
    padding: 10px 20px;
    background: #c0c0c0;
    outline: none;
    border: none;
    border-radius: 30px;
    border: 1px solid rgba(255, 255, 255, 0.5);
    border-right: 1px solid rgba(255, 255, 255, 0.2);
    border-bottom: 1px solid rgba(255, 255, 255, 0.2);
    font-size: 16px;
    letter-spacing: 1px;
    color: #ffffff;
    box-shadow: 0 5px 15px rgba(0, 0, 0, 0.05);
}
input:placeholder{
    color:#ffffff;
}

/*输入框变色*/
.form .inputBox input:focus{
    border-style:solid;
    border-color:#03a9f4;
    box-shadow:0 0 50px #0080ff;
    background-color:#b3bbb3;
}

/* 注册按钮样式 */

.form .inputBox input[type="submit"] {
    background: #fff;
    color: #666;
    max-width: 100px;
    margin-bottom: 20px;
    font-weight: 600;
    cursor: pointer;
    letter-spacing: 0.5px;

}
.form .inputBox input[type="submit"]:hover {
    transform: translateY(-5px);
    transition: 0.5s;
}
.form .inputBox .reset{
    background: #00000033;
    color: #f1f0f0;
    max-width: 100px;
    margin-bottom: 20px;
    font-weight: 100;
    cursor: pointer;
    float: right;
}
.form .inputBox .reset:hover{
    transform: translateY(-5px);
    transition: 0.5s;
}
.form .inputBox{
    float: left;
}
 </style>

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
        <h2 style="text-align:center" > 用户注册 </h2>
        <form action="http://localhost:8080/数据结构作业/RegisterServlet" method="post">
          <div class="inputBox" >
            用户名<input type="text" id="userId" name="userName" placeholder="输入用户名" /><br>
          </div>
          <div class="inputBox">
            密码<input type="password" id="pwdId1" name="pwdName1" placeholder="请输入密码" /><br>
            密码<input type="password" id="pwdId2" name="pwdName2" placeholder="请再次输入密码" /><br>
          </div>
          <div class="inputBox">
            <input type="submit"  value="立马注册">
            <input type="reset" value="重置" class="reset">
          </div>
        </form>
      </div>
    </div>
  </div>
</section>
<script src="https://www.layuicdn.com/layui/layui.js"></script>
<script type="text/javascript">
if()
layer.alert('注册成功', {
	time: 5*1000
	,success: function(layero, index){
	var timeNum = this.time/1000, setText = function(start){
	layer.title((start ? timeNum : --timeNum) + ' 秒后回到登录页面', index);
	};
	setText(!0);
	this.timer = setInterval(setText, 1000);
	if(timeNum <= 0) clearInterval(this.timer);
	}
	,end: function(){
	clearInterval(this.timer);
	}
	});
</script>
</body>
</html>