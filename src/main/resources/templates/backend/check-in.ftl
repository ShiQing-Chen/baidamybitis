<#import "/spring.ftl" as spring>
<#import "../layout/layout.ftl" as layout>
<@layout.header>
</@layout.header>
<@layout.content>
<section class="content-header">
    <h1>
        签到查询
    </h1>
    <ol class="breadcrumb">
        <li><a href="<@spring.url '/dashboard'/>"><i class="fa fa-dashboard"></i> 首页</a></li>
        <li class="active">签到查询</li>
    </ol>
</section>

<section class="content">
    <div class="box">
        <div class="box-body">
            <div id="toolbar" class="btn-group col-xs-12" style="padding: 0;">
            </div>
            <table id="data-table" class="table table-bordered table-hover">
            </table>
        </div>
    </div>
</section>

</@layout.content>
<@layout.script>
<script type="text/javascript">
    var qrcode;
    $(document).ready(function () {

        $('#data-table').bootstrapTable({
            columns: [{
                field: 'id',
                align: 'center',
                title: '序号',
                formatter: function (value, row, index) {
                    return index + 1;
                }
            }, {
                field: 'userName',
                align: 'center',
                title: '姓名'
            }, {
                field: 'userMobile',
                align: 'center',
                title: '手机'
            }, {
                field: 'subName',
                align: 'center',
                title: '学科'
            }, {
                field: 'schoName',
                align: 'center',
                title: '学校'
            }, {
                field: 'createTime',
                align: 'center',
                title: '签到时间',
                visible:true
//            }, {
//                field: 'opt',
//                title: '操作',
//                halign: 'center',
//                align: 'center',
//                events: 'operateEvents',
//                visible: false,
//                formatter: function (value, row, index) {
//                    return '<a class = "delete" style="cursor: pointer;">删除</a>';
//                }
            }],
            idField: "id",
            striped: true, //隔行变色
            showColumns: true, //按钮 选择显示的列
            pagination: true,//开启分页
            sidePagination: 'server', //服务端分页
            pageNumber: 1,
            pageSize: 10,
            search: true,
            searchOnEnterKey: true,
            trimOnSearch: false,
            paginationHAlign: 'right',
            paginationDetailHAlign: 'left',
            searchAlign: 'left',
            url: "<@spring.url '/backend/searchCheckIn'/>",
            queryParams: function (params) {
                return params;
            },
            formatSearch: function () {
                return '按名称 搜索';
            },
            method: 'post',
            onLoadError: function (status) {
                console.log(status);
            }
        });

        <#--window.operateEvents = {-->
            <#--'click .delete': function (e, value, row) {-->
                <#--$.post('<@spring.url '/backend/deleteCheckIn'/>',-->
                        <#--{-->
                            <#--activityId: row.id-->
                        <#--}, function (response) {-->
                            <#--console.log(response);-->
                            <#--if (response.success) {-->
                                <#--$('#data-table').bootstrapTable('refresh');-->
                            <#--} else {-->
                                <#--$.toast(response.message, 'danger');-->
                            <#--}-->
                        <#--},-->
                        <#--"json"-->
                <#--);-->
            <#--}-->
        <#--};-->
    });
</script>
</@layout.script>