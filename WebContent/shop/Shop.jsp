<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="dao.GoodsInfoDao" %>
<%@ page import="bean.Goodsinfo" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="referrer" content="never">
  <title>购物界面</title>
  <link href="${pageContext.request.contextPath }/css/shop.css" rel="stylesheet" type="text/css">
  <link rel="stylesheet" href="${pageContext.request.contextPath }/layui/css/layui.css" media="all">
  <jsp:include page="../shop/head.jsp"/>
</head>
<body>

<div id="top">
  <div id="top2">
  
    <div style="float: right; margin-right: 10px;">
    
      <form action="${pageContext.request.contextPath }/SearchGoodsServlet" class="search" method="get">
      <input placeholder="请输入你想搜索的商品" type="text" name="search"  />
      <input type="submit" value="搜 索"  style="height: 40px" />
      </form>
    </div>
</div>
  <div class="layui-carousel" id="test1"  style="height: 1000px" >
    <div carousel-item>
      <div align="center"><img src="${pageContext.request.contextPath }/images/1.png" width="100%" ></div>
      <div align="center"><img src="${pageContext.request.contextPath }/images/2.png" width="100%" ></div>
      <div align="center"><img src="${pageContext.request.contextPath }/images/3.png" width="100%" ></div>
      <div align="center"><img src="${pageContext.request.contextPath }/images/4.png" width="100%" ></div>
      <div align="center"><img src="${pageContext.request.contextPath }/images/5.png" width="100%" ></div>
      <div align="center"><img src="${pageContext.request.contextPath }/images/6.png" width="100%" ></div>
      <div align="center"><img src="${pageContext.request.contextPath }/images/7.png" width="100%" ></div>
    </div>
  </div>

<div id="top3" style="color: white">
  您是不是想找：<a href="#">男装 | </a><a href="#">女装 | </a><a href="#">潮鞋 | </a><a href="#">内衣 | </a><a href="#">冬装</a>
</div>

<div id="top4" style="margin-top: 3px;">
  <div style="float: left;">
    价格： <input type="text" name="price1" /> - <input type="text" name="price2" />
  </div>
  <div style="float: right">
    <input type="checkbox" name="ck1" value="1" />
    包邮
    <input type="checkbox" name="ck1" value="2" />
    九块九
    <input type="checkbox" name="ck1" value="3" />
    无理由七天退换货
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  </div>
</div>
</div>

<%-- <c:forEach item="${Goodslist}" var="Goods">

<ul class="flow-default" style="height: 600px; " id="LAY_demo2">
  <li>
    <div>
      <a herf="#"> <img lay-src="https://cdn.layui.com/upload/2017_3/168_1488985841996_23077.png"></a>
    </div>
  </li>
  <li>  <img lay-src="https://cdn.layui.com/upload/2017_3/168_1488985841996_23077.png"><a herf="#"></a></li>
  <li>  <img lay-src="https://cdn.layui.com/upload/2017_3/168_1488985841996_23077.png"><a herf="#"></a></li>
  <li>  <img lay-src="https://cdn.layui.com/upload/2017_3/168_1488985841996_23077.png"><a herf="#"></a></li>
  <li>  <img lay-src="https://cdn.layui.com/upload/2017_3/168_1488985841996_23077.png"><a herf="#"></a></li>
  <li>  <img lay-src="https://cdn.layui.com/upload/2017_3/168_1488985841996_23077.png"><a herf="#"></a></li>
</ul>
 --%>
 <div class="content" style="margin-top:400px;width:100%;height:600px;overflow:scroll" >
  <div class="proRow">
  <%  GoodsInfoDao ud = new GoodsInfoDao();
	 List<Goodsinfo> listGoods = ud.findAll(); 
	 for(Goodsinfo goods:listGoods){ %>
    <div class="proBig">
      <div class="pro">
        <div class="proImg"><img src="http://www.jq22.com/img/cs/500x500-1.png"></div>
        <div class="proText">
          <h5><%=goods.getDetail() %></h5>
          <p class="proSize">库存：<%=goods.getStock() %></p>
          <p class="proPrice">￥<span><%=goods.getPrice()%></span></p>
        </div>
        <div class="proFrom">销量：<%=goods.getSale() %></div>
      </div>
      <a href="#">
        <div class="proBtn">
          <div class="btn">
            <p><a href="${pageContext.request.contextPath }/BuyGoodsServlet?goods_id=<%=goods.getId()%>">立即购买</a></p>
          </div>
          <div class="btn">
            <p><a href="${pageContext.request.contextPath }/AddCartServlet?goods_id=${goods.id}">加入购物车</a></p>
          </div>
        </div>
      </a>
    </div>  
    <%} %>
  </div>
 </div>
 
<%-- </c:forEach> --%>



<footer id="footer">
  <div class="container">
    <pre style="float: right">法律声明 | 廉政举报 | 合作事宜 | 版权投诉 | 加入我们   wyz版权所有，所有解释权归wyz所有  业务经营许可证:京Z9-66666666  京公网安备 123456789123号</pre>
    <p style="align:center"> Copyright © 2001 - 2021 wyz. All Rights Reserved.</p>
  </div>
</footer>
<script src="${pageContext.request.contextPath }/layui/layui.js" charset="utf-8"></script>
    <script>
    ////////////////////登录成功提醒////////////////////////
    layer.alert('欢迎进入zz商城', {
    	time: 5*1000
    	,success: function(layero, index){
    	var timeNum = this.time/1000, setText = function(start){
    	layer.title('登录成功');
    	};
    	setText(!0);
    	this.timer = setInterval(setText, 1000);
    	if(timeNum <= 0) clearInterval(this.timer);
    	}
    	,end: function(){
    	clearInterval(this.timer);
    	}
    	});

      //////////////轮播图////////////////
      layui.use('carousel', function(){
        var carousel = layui.carousel;
        //建造实例
        carousel.render({
          elem: '#test1'
          ,width: '1200px' //设置容器宽度
          ,height: '500px'
          ,arrow: 'hover' //始终显示箭头
          ,indicator:'inside'//指示器
          ,autoplay:true
          ,interval:'3000'//自动切换时间3s
        });
      });

      /////////////////信息流加载/////////////////
      layui.use('flow', function(){
        var flow = layui.flow;
        flow.load({
          elem: '#LAY_demo2' //流加载容器
          ,scrollElem: '#LAY_demo2' //滚动条所在元素，一般不用填，此处只是演示需要。
          ,isAuto: false
          ,isLazyimg: true
          ,done: function(page, next){ //加载下一页
            //模拟插入
            setTimeout(function(){
              var lis = [];
              for(var i = 1; i < 8; i++){
                lis.push('<li><a herf="#"><img lay-src="images/0' +i+'.jpg" width="550px" height="380px"></a></li>')
              }
              next(lis.join(''), page < 6); //假设总页数为 6
            }, 500);
          }
        });
      });
    </script>
</body>
</html>

