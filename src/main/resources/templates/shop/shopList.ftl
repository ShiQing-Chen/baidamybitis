<#import "/spring.ftl" as spring>
<#import "../layout/layout.ftl" as layout>
<@layout.header>
<style type="text/css">
    #div-qr-code >img{
        margin: auto;
    }

    .qrcontainer {
        width: 512px;
        height: 512px;
        position: relative;
        background: url("<@spring.url '/image/qr/code-bg.png'/>") no-repeat center;
        background-size: 100%;
        margin: auto;
    }
    .qrcontainer #div-qr-code {
        width: 100%;
        height: 100%;
        position: absolute;
        top: 56px;
    }
    .qrcontainer .logo {
        top: 50%;
        left: 50%;
        width: 120px;
        height: 120px;
        margin-left: -60px;
        margin-top: -60px;
        position: absolute;
    }
    .qrcontainer .logo img{
        width: 100%;
    }
</style>
</@layout.header>
<@layout.content>
<section class="content-header">
    <h1>
        商铺管理
    </h1>
    <ol class="breadcrumb">
        <li><a href="<@spring.url '/dashboard'/>"><i class="fa fa-dashboard"></i> 首页</a></li>
        <li class="active">商铺管理</li>
    </ol>
</section>

<section class="content">
    <div class="box">
        <div class="box-body">
            <div id="toolbar" class="btn-group col-xs-12" style="padding: 0;">
                <button id="btn-add" type="button" class="btn btn-success pull-right"><span
                        class="glyphicon glyphicon-plus" aria-hidden="true"></span>添加商铺
                </button>
            </div>
            <table id="data-table" class="table table-bordered table-hover">
            </table>
        </div>
    </div>
</section>

<!-- Modal -->
<div class="modal fade bs-example-modal-sm" id="modal-show-shop" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="modal-title">店铺详情</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal" id="form-show" action="'/>" method="post">
                    <div class="form-group">
                        <label for="input-shop-name" class="col-sm-2 control-label">店铺名称</label>
                        <div class="col-sm-8">
                            <input type="text" class="form-control" id="input-shop-name" name="shopName">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="input-shop-name" class="col-sm-2 control-label">店铺地址</label>
                        <div class="col-sm-8">
                            <input type="text" class="form-control" id="input-shop-name" name="shopName">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="input-shop-longitude" class="col-sm-2 control-label">店铺地址经度</label>
                        <div class="col-sm-8">
                            <input type="text" class="form-control" id="input-shop-longitude" name="longitude">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="input-shop-latitude" class="col-sm-2 control-label">店铺地址纬度</label>
                        <div class="col-sm-8">
                            <input type="text" class="form-control" id="input-shop-latitude" name="latitude">
                        </div>
                    </div>

                </form>

            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
            </div>
        </div>
    </div>
</div>

</@layout.content>
<@layout.script>
<script type="text/javascript" src="<@spring.url '/webjars/qrcodejs/1c78ccd/qrcode.js' />"></script>
<script type="text/javascript">
    var qrcode;
    $(document).ready(function () {
        $('#btn-add').click(function () {
            document.location = "<@spring.url '/shop/addShop'/>";
        });

        $('#data-table').bootstrapTable({
            columns: [{
                field: 'id',
                align: 'center',
                valign: 'middle',
                title: '序号',
                formatter: function (value, row, index) {
                    return index + 1;
                }
            }, {
                field: 'shopPath',
                align: 'center',
                valign: 'middle',
                title: 'log',
                formatter: function (value, row, index) {
                    row.shopPath = 'https://gss1.bdstatic.com/9vo3dSag_xI4khGkpoWK1HF6hhy/baike/c0%3Dbaike80%2C5%2C5%2C80%2C26/sign=187afb979e82d158af8f51e3e16372bd/2f738bd4b31c870168f8cf9f257f9e2f0708ff79.jpg';
                    return '<img src="'+row.shopPath+'" height="40">';
                }
            },{
                field: 'shopName',
                align: 'center',
                valign: 'middle',
                title: '名称',
                formatter:function(value, row, index){
                    return '<a class = "show" style="cursor: pointer;">修改</a>';
                }
            }, {
                field: 'shopAddress',
                align: 'center',
                valign: 'middle',
                title: '地址'
            }, {
                field: 'shopPhone',
                align: 'center',
                valign: 'middle',
                title: '电话'
            }, {
                field: 'startFee',
                align: 'center',
                valign: 'middle',
                title: '起送费'
            }, {
                field: 'shopHeat',
                align: 'center',
                valign: 'middle',
                title: '热度'
            }, {
                field: 'startTime',
                align: 'center',
                valign: 'middle',
                title: '营业开始时间'
            }, {
                field: 'endTime',
                align: 'center',
                valign: 'middle',
                title: '营业结束时间'
            }, {
                field: 'shopStatus',
                align: 'center',
                valign: 'middle',
                title: '状态',
                width:'8%',
                formatter: function (value, row, index) {
                    if(row.shopStatus=="1"){
                        return "营业中";
                    }else if(row.shopStatus=="0"){
                        return "停业中";
                    }else{
                        return "-" ;
                    }
                }
            }, {
                field: 'opt',
                title: '操作',
                halign: 'center',
                align: 'center',
                valign: 'middle',
                width:'8%',
                events: 'operateEvents',
                formatter: function (value, row, index) {
                    return '<a class = "update" style="cursor: pointer;">修改</a>' +
                            '&nbsp;&nbsp;<a class = "delete" style="cursor: pointer;">删除</a>';
                }
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
            url: "<@spring.url '/shop/searchShop'/>",
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

        window.operateEvents = {
            'click .delete': function (e, value, row) {
                $.post('<@spring.url '/backend/deleteActivity'/>',
                        {
                            activityId: row.id
                        }, function (response) {
                            console.log(response);
                            if (response.success) {
                                $('#data-table').bootstrapTable('refresh');
                            } else {
                                $.toast(response.message, 'danger');
                            }
                        },
                        "json"
                );
            },

            'click .update': function (e, value, row) {
                console.log(row.id);
                <#--document.location = "<@spring.url '/backend/updateActivity/'/>"+row.id;-->
            },

            'click .show': function (e, value, row) {
                console.log(row.id);
                // $('#modal-show-shop').modal('show');
            }
        };
    });
</script>
</@layout.script>