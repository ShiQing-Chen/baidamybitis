<#import "/spring.ftl" as spring>
<#import "../layout/layout.ftl" as layout>
<@layout.header>
</@layout.header>
<@layout.content>
<section class="content-header">
    <h1>
        反馈管理
    </h1>
    <ol class="breadcrumb">
        <li><a href="<@spring.url '/dashboard'/>"><i class="fa fa-dashboard"></i> 首页</a></li>
        <li class="active">反馈管理</li>
    </ol>
</section>

<section class="content">
    <div class="box">
        <div class="box-body">
            <table id="data-table" class="table table-bordered table-hover">
            </table>
        </div>
    </div>
</section>
</@layout.content>
<@layout.script>
<script type="text/javascript">
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
                field: 'actName',
                align: 'center',
                title: '所属活动',
                visible:false
            }, {
                field: 'topicName',
                align: 'center',
                title: '所属主题'
            }, {
                field: 'suggestion',
                align: 'center',
                title: '反馈内容'
            }, {
                field: 'feedbackOption',
                align: 'center',
                title: '整体评价',
                formatter: function (value) {
                    if (value === 1) {
                        return "非常好";
                    }
                    if (value === 2) {
                        return "满意";
                    }
                    if (value === 3) {
                        return "一般";
                    }
                    if (value === 4) {
                        return "较差";
                    }
                }
//            }, {
//                field: 'userName',
//                align: 'center',
//                title: '姓名'
//            }, {
//                field: 'userMobile',
//                align: 'center',
//                title: '手机号码'
//            }, {
//                field: 'userSchoName',
//                align: 'center',
//                title: '学校名称'
//            }, {
//                field: 'userSubName',
//                align: 'center',
//                title: '学科'
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
                formatter: function () {
                    return '<a class = "delete" style="cursor: pointer;">删除</a>';
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
            url: "<@spring.url '/backend/searchFeedback'/>",
            queryParams: function (params) {
                return params;
            },
            formatSearch: function () {
                return '按反馈内容 搜索';
            },
            method: 'post',
            onLoadError: function (status) {
                console.log(status);
            }
        });

        window.operateEvents = {
            'click .delete': function (e, value, row) {
                $.post('<@spring.url '/backend/deleteFeedback'/>',
                        {
                            feedbackId: row.id
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
            }
        };
    });
</script>
</@layout.script>