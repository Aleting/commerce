﻿<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
  <base href="<%=basePath%>">
    <title>selectGood.jsp</title>
	<link href="css/admin/common.css" type="text/css" rel="stylesheet">
	<style type="text/css">
		table{
			text-align: center;
			border-collapse: collapse;
		}
		.bgcolor{
		  	background-color: #F08080;
		}
	</style>
	<script type="text/javascript">
		function changeColor(obj){
			obj.className = "bgcolor";
		}
		function changeColor1(obj){
			obj.className = "";
		}
	</script>
	<script type="text/javascript">
  		function confirmDelete(){
  			var n = document.deleteForm.ids.length;
  			var count = 0;//统计没有选中的个数
  			for(var i = 0; i < n; i++){
  				if(!document.deleteForm.ids[i].checked){


  					count++;
  				}else{
  					break;
  				}
  			}
  			if(n > 1){
  				if(count == n){
  					alert("请选择被删除的商品！");
  	  				count = 0;
  	  				return false;
  				}
  			}else{
  	  			if(!document.deleteForm.ids.checked){
  	  					alert("请选择被删除的商品！");
  	  					return false;
  	  			}
  			}
  			if(window.confirm("真的删除吗？really?"+count)){
  				document.deleteForm.submit();
  				return true;
  			}
  			return false;
  		}
  		function checkDel(id){
  			if(window.confirm("是否删除该商品？")){
  				window.location.href = "<%=basePath%>adminGoods/deleteAGoods?id="+id;
  			}
  		}
  </script>
</head>
<body>
	<c:if test="${pageInfo.total == 0 }">
		您还没有商品。
	</c:if>
	<c:if test="${pageInfo.total != 0 }">
		<form action="adminGoods/deleteGoods" name="deleteForm">
		<table border="1" bordercolor="PaleGreen">
			<tr>
				<th width="100px">ID</th>
				<th width="200px">名称</th>
				<th width="200px">价格</th>
				<th width="100px">库存</th>
				<th width="100px">详情</th>
				<th width="100px">操作</th>
			</tr>
			<c:forEach items="${pageInfo.list }" var="goods">
				<tr onmousemove="changeColor(this)" onmouseout="changeColor1(this)">
					<td><input type="checkbox" name="ids" value="${goods.id }"/>${goods.id }</td>
					<td>${goods.gname }</td>
					<td>${goods.grprice }</td>
					<td>${goods.gstore }</td>
					<td><a href="adminGoods/selectAGoods?id=${goods.id }" target="_blank">详情</a></td>
					<td>
						<a href="javascript:checkDel('${goods.id }')">删除</a>
					</td>
				</tr>
			</c:forEach>
			<tr>
				<td colspan="6">
					<input type="button" value="删除" onclick="confirmDelete()">
				</td>
			</tr>
			<tr>
				<td colspan="6" align="right">
					&nbsp;&nbsp;&nbsp;
					&nbsp;&nbsp;&nbsp;
					当前${pageInfo.pageNum}页,总共${pageInfo.pages}页,总${pageInfo.total}条记录
					<c:url var="url_pre" value="adminGoods/selectGood">
						<c:param name="pageCur" value="${pageInfo.pageNum - 1 }"/>
					</c:url>
					<c:url var="url_next" value="adminGoods/selectGood">
						<c:param name="pageCur" value="${pageInfo.pageNum + 1 }"/>
					</c:url>
					<!-- 第一页没有上一页 -->
					<c:if test="${pageInfo.pageNum != 1 }">
						<a href="${url_pre}">上一页</a>&nbsp;&nbsp;&nbsp;&nbsp;
					</c:if>
					<!-- 最后一页，没有下一页 -->
					<c:if test="${pageInfo.pageNum != pageInfo.pages && pageInfo.pages != 0}">
						<a href="${url_next}">下一页</a>
					</c:if>
				</td>
			</tr> 
			<tr>
				<td colspan="6">${msg }</td>
			</tr>
		</table>
		</form>
	</c:if>
</body>
</html>