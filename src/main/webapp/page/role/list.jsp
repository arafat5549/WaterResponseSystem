<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">
    <title></title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <jsp:include page="../../top.jsp"></jsp:include>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/table.css"/>
</head>
<body class="easyui-layout" data-options="fit:true,border:false">
<div data-options="region:'center',title:'',border:false">
    <div id="grid"></div>
    <div id="toolBar" style="vertical-align: center">
        <div>

            <shiro:hasPermission name="新增角色">
                <a href="javascript:void(0);" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-add'"
                   onclick="addInfo()">新增</a>
            </shiro:hasPermission>
            <shiro:hasPermission name="更新角色">
                <a href="javascript:void(0);" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-edit'"
                   onclick="updateInfo()">更新</a>
            </shiro:hasPermission>
            <shiro:hasPermission name="删除角色">
                <a href="javascript:void(0);" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-remove'"
                   onclick="deleteInfo()">删除</a>
            </shiro:hasPermission>

            <a href="javascript:void(0)" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-undo'"
               onclick="cancelInfo()">清空选中</a>
            <a href="javascript:void(0);" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-reload'"
               onclick="cleanForm()">刷新</a>
            <shiro:hasPermission name="分配权限">
                <a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-edit',plain:true"
                   onclick="getPermission()">授权</a>
            </shiro:hasPermission>
        </div>
    </div>


</div>
<script type="text/javascript"
        src="${pageContext.request.contextPath}/js/jquery-easyui-1.5.2/datagrid/datagrid-filter.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/module/role.js"></script>
<script type="text/javascript">
    var basePath = "<%=basePath%>";
</script>
</body>

</html>
