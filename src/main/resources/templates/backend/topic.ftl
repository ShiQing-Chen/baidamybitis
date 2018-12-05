<#import "/spring.ftl" as spring>
<#import "../layout/layout.ftl" as layout>
<@layout.header>
<style type="text/css">
    .typeahead,
    .tt-query,
    .tt-hint {
        width: 100%;
        height: 34px;
        padding: 6px 12px;
        font-size: 14px;
        line-height: 30px;
        border: 1px solid #ccc;
        -webkit-border-radius: 4px;
        -moz-border-radius: 4px;
        border-radius: 4px;
        outline: none;
    }
    .twitter-typeahead{
        width: 100%;
    }

    .typeahead {
        background-color: #fff;
    }

    .typeahead:focus {
        border: 1px solid #0097cf;
    }

    .tt-query {
        -webkit-box-shadow: inset 0 1px 1px rgba(0, 0, 0, 0.075);
        -moz-box-shadow: inset 0 1px 1px rgba(0, 0, 0, 0.075);
        box-shadow: inset 0 1px 1px rgba(0, 0, 0, 0.075);
    }

    .tt-hint {
        color: #999
    }

    .tt-menu {
        width: 100%;
        margin: 0;
        padding: 8px 0;
        background-color: #fff;
        border: 1px solid #ccc;
        -webkit-border-radius: 8px;
        -moz-border-radius: 8px;
        border-radius: 8px;
        -webkit-box-shadow: 0 5px 10px rgba(0,0,0,.2);
        -moz-box-shadow: 0 5px 10px rgba(0,0,0,.2);
        box-shadow: 0 5px 10px rgba(0,0,0,.2);
        max-height: 150px;
        overflow-y: auto;
    }

    .tt-suggestion {
        padding: 3px 20px;
        font-size: 14px;
        line-height: 24px;
    }

    .tt-suggestion:hover {
        cursor: pointer;
        color: #fff;
        background-color: #0097cf;
    }

    .tt-suggestion.tt-cursor {
        color: #fff;
        background-color: #0097cf;
    }

    .tt-suggestion p {
        margin: 0;
    }
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
        主题管理
    </h1>
    <ol class="breadcrumb">
        <li><a href="<@spring.url '/dashboard'/>"><i class="fa fa-dashboard"></i> 首页</a></li>
        <li class="active">主题管理</li>
    </ol>
</section>

<section class="content">
    <div class="box">
        <div class="box-body">
            <div id="toolbar" class="btn-group col-xs-12" style="padding: 0;">
                <button id="btn-add" type="button" class="btn btn-success pull-right"><span class="glyphicon glyphicon-plus" aria-hidden="true"></span>新建主题
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
                <h4 class="modal-title" id="modal-title">查看二维码</h4>
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
<script type="text/javascript" src="<@spring.url '/webjars/typeaheadjs/0.11.1/typeahead.bundle.min.js'/>" charset="UTF-8"></script>
<script type="text/javascript" src="<@spring.url '/webjars/qrcodejs/1c78ccd/qrcode.js' />"></script>
<script type="text/javascript">
    var qrcode;
    $(document).ready(function(){

        $('#btn-add').click(function(){
            document.location = "<@spring.url '/backend/addTopic' />";
        });

        $('#data-table').bootstrapTable({
            columns: [{
                field: 'id',
                align: 'center',
                title: '序号',
                formatter:function(value,row,index){
                    return index+1;
                }
            }, {
                field: 'topicName',
                align: 'center',
                title: '主题名称',
                events: 'operateEvents',
                formatter:function(value){
                    return '<a class = "show" style="cursor: pointer;">'+value+'</a>';
                }
            }, {
                field: 'speaker',
                align: 'center',
                title: '主讲嘉宾'
            }, {
                field: 'speakerIntro',
                align: 'center',
                title: '嘉宾头衔'
            }, {
                field: 'location',
                align: 'center',
                title: '会场地点'
            }, {
                field: 'startTime',
                align: 'center',
                title: '开始时间'
            }, {
                field: 'endTime',
                align: 'center',
                title: '结束时间'
            }, {
                field: 'actName',
                align: 'center',
                title: '所属活动',
                visible: false
            },{
                field: 'createTime',
                align: 'center',
                title: '创建时间',
                visible: false
            }, {
                field: 'opt',
                title: '操作',
                halign: 'center',
                align: 'center',
                events: 'operateEvents',
                formatter:function(){
                    return '<a class = "update" style="cursor: pointer;">修改</a>'+
                            '&nbsp;&nbsp;<a class = "delete" style="cursor: pointer;">删除</a>';
                }
            }],
            idField:"id",
            striped:true, //隔行变色
            showColumns:true, //按钮 选择显示的列
            pagination:true,//开启分页
            sidePagination: 'server', //服务端分页
            pageNumber:1,
            pageSize:10,
            search:true,
            searchOnEnterKey:true,
            trimOnSearch:false,
            paginationHAlign:'right',
            paginationDetailHAlign:'left',
            searchAlign: 'left',
            url:"<@spring.url '/backend/searchTopic'/>",
            queryParams:function(params){
                return params;
            },
            formatSearch :function(){
                return '按主题 搜索';
            },
            method:'post',
            onLoadError:function(status){
                console.log(status);
            }
        });

        window.operateEvents = {
            'click .delete': function (e, value, row) {
                $.post("<@spring.url '/backend/deleteTopic'/>",
                        {
                            topicId: row.id
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

            'click .show': function (e, value, row) {
                console.log(row.id);
                $('#modal-show-qr').modal('show');
                var url = "${qrUrlBase}/qr/"+row.id;
                $('#modal-title').text("查看二维码："+row.topicName);
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
            },

            'click .update': function (e, value, row) {
                console.log(row.id);
                document.location = "<@spring.url '/backend/updateTopic/'/>"+row.id;
            }
        };
    });
</script>
</@layout.script>