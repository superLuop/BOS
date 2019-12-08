<%--
  Created by IntelliJ IDEA.
  User: gyf
  Date: 2018/5/4
  Time: 15:41
  To change this template use File | Settings | File Templates.

  easyui表格编辑功能
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/js/easyui/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/js/easyui/themes/icon.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.8.3.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/easyui/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/easyui/locale/easyui-lang-zh_CN.js"></script>
    <title>Title</title>
</head>
<body>

<%-- datagrid的使用:js来实现排版--%>
<script>
    $(function () {
        //抽取配置
        //1.抽取列的配置
        var columns = [[
            {field:'id',title:'编号',width:100,checkbox:true},
            {field:'name',title:'姓名',width:100,editor:{
                type:'text',
                options:{}
            }},
            {field:'age',title:'年龄',width:100,editor:{
                type:'text',
                options:{}
            }}
        ]];

        //2.抽取工具条配置
        var toolbar = [
            {
                iconCls: 'icon-edit',
                text:'Edit',
                handler: function(){
                    //alert("xx");
                    //让第一行的数据变成一个编辑的状态
                    $("#grid").datagrid("beginEdit",0);

                    /*$("#grid").datagrid("insertRow",{
                        index: 0,	// 索引从0开始
                        row: {
                        }
                    });*/
                }
            },
            {
                text:'结束编辑的状态',
                handler: function(){
                    $("#grid").datagrid("endEdit",0);
                }
            },{
                text:'新增',
                handler: function(){
                    //结束以前行状态
                    $("#grid").datagrid("endEdit",0);

                    //$("#grid").datagrid("endEdit",0);
                    //新增一行
                    $("#grid").datagrid("insertRow",{
                        index:0,
                        row:{}
                    });

                    //处于编辑状态
                    $("#grid").datagrid("beginEdit",0);
                }
            },{
                text:'删除',
                handler: function(){
                    $("#grid").datagrid("deleteRow",0);
                }
            }
        ];

        $("#grid").datagrid({
            url:'${pageContext.request.contextPath}/json/stafftest.json',
            rownumbers:true,//显示序号
            singleSelect:true,//单选
            pagination:true,//显示分页的工具条
            pageSize:5,//每页显示的条数
            pageList:[5,10,15], //分页条数选择
            columns:columns,
            toolbar:toolbar,
            onAfterEdit:function (index,row,changes) {
                console.log("监听编辑状态的结束:" + index + " --" + row);
            }
        });

    });
</script>
<table id="grid"  class="easyui-datagrid"></table>


</body>
</html>
