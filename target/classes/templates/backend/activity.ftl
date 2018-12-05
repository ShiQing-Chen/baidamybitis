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
        活动管理
    </h1>
    <ol class="breadcrumb">
        <li><a href="<@spring.url '/dashboard'/>"><i class="fa fa-dashboard"></i> 首页</a></li>
        <li class="active">活动管理</li>
    </ol>
</section>

<section class="content">
    <div class="box">
        <div class="box-body">
            <div id="toolbar" class="btn-group col-xs-12" style="padding: 0;">
                <button id="btn-add" type="button" class="btn btn-success pull-right"><span
                        class="glyphicon glyphicon-plus" aria-hidden="true"></span>新建活动
                </button>
            </div>
            <table id="data-table" class="table table-bordered table-hover">
            </table>
        </div>
    </div>
</section>

<!-- Modal -->
<div class="modal fade bs-example-modal-sm" id="modal-show-qr" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="modal-title">签到二维码</h4>
            </div>
            <div class="modal-body">
                <div class="qrcontainer">
                    <div id="div-qr-code"></div>
                    <div class='logo'>
                        <img src="<@spring.url '/image/test/logo-yx.jpg'/>"/>
                    </div>
                </div>
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
            document.location = "<@spring.url '/backend/addActivity'/>";
        });

        $('#data-table').bootstrapTable({
            columns: [{
                field: 'id',
                align: 'center',
                title: '序号',
                formatter: function (value, row, index) {
                    return index + 1;
                }
            }, {
                field: 'actName',
                align: 'center',
                title: '活动名称'
            }, {
                field: 'optShow',
                align: 'center',
                title: '签到',
                events: 'operateEvents',
                formatter:function(value){
                    return '<a class = "show" style="cursor: pointer;">二维码</a>';
                }
            }, {
                field: 'organizer',
                align: 'center',
                title: '举办单位'
            }, {
                field: 'startTime',
                align: 'center',
                title: '开始时间'
            }, {
                field: 'endTime',
                align: 'center',
                title: '结束时间'
            }, {
                field: 'createTime',
                align: 'center',
                title: '创建时间',
                visible:false
            }, {
                field: 'opt',
                title: '操作',
                halign: 'center',
                align: 'center',
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
            url: "<@spring.url '/backend/searchActivity'/>",
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
                document.location = "<@spring.url '/backend/updateActivity/'/>"+row.id;
            },

            'click .show': function (e, value, row) {
                console.log(row.id);
                $('#modal-show-qr').modal('show');
                $('#modal-title').text("签到二维码："+row.actName);
                var url = "${qrUrlBase}/qr/checkIn/"+row.id;
                if(qrcode){
                    qrcode.clear(); // clear the code.
                    qrcode.makeCode(url); // make another code.
                }else{
                    qrcode = new QRCode(document.getElementById("div-qr-code"), {
                        text: url,
                        width: 400,
                        height: 400,
                        colorDark : "#000000",
                        colorLight : "#ffffff",
                        correctLevel : QRCode.CorrectLevel.H
                    });
                }
            }
        };
    });
</script>
</@layout.script>