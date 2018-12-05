<#import "/spring.ftl" as spring>
<#import "../layout/layout.ftl" as layout>
<@layout.header>
<link href="<@spring.url '/webjars/bootstrap-datetimepicker/2.4.2/css/bootstrap-datetimepicker.min.css'/>" rel="stylesheet" media="screen">
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
        新建主题
    </h1>
    <ol class="breadcrumb">
        <li><a href="<@spring.url '/dashboard'/>"><i class="fa fa-dashboard"></i> 首页</a></li>
        <li><a href="<@spring.url '/backend/topic'/>"> 主题管理</a></li>
        <li class="active">新建主题</li>
    </ol>
</section>

<section class="content">
    <div class="box">
        <div class="box-body">
            <form id="form-add" class="form-horizontal" method="post" action="<@spring.url '/backend/doAddTopic'/>">
                <input type="hidden" id = "input-act-id" name="actId" value="${addTopicForm.actId!}"/>
                <div class="form-group">
                    <label for="inputEmail3" class="col-sm-2 control-label">选择活动</label>
                    <div class="col-sm-8">
                        <@spring.bind "addTopicForm.actId"/>
                        <input type="text" class="form-control" id="input-act-name" name="actName" value="${addTopicForm.actName!}" placeholder="输入关键词语检索">
                        <span class="text-danger"><@spring.showErrors ""/></span>
                    </div>
                </div>
                <div class="form-group">
                    <label for="inputEmail3" class="col-sm-2 control-label">主题名称</label>
                    <div class="col-sm-8">
                        <@spring.bind "addTopicForm.topicName"/>
                        <input type="text" class="form-control" id="input-topic-name" name="topicName" value="${addTopicForm.topicName!}" placeholder="新高考政策的落地实施-张三">
                        <span class="text-danger"><@spring.showErrors ""/></span>
                    </div>
                </div>
                <div class="form-group">
                    <label for="inputEmail3" class="col-sm-2 control-label">主讲嘉宾</label>
                    <div class="col-sm-8">
                        <@spring.bind "addTopicForm.speaker"/>
                        <input type="text" class="form-control" id="input-speaker" name="speaker" value="${addTopicForm.speaker!}" placeholder="诸葛亮">
                        <span class="text-danger"><@spring.showErrors ""/></span>
                    </div>
                </div>
                <div class="form-group">
                    <label for="inputEmail3" class="col-sm-2 control-label">嘉宾头衔</label>
                    <div class="col-sm-8">
                        <@spring.bind "addTopicForm.speakerIntro"/>
                        <input type="text" class="form-control" id="input-speaker-intro" name="speakerIntro" value="${addTopicForm.speakerIntro!}" placeholder="课程帮中学校长、特级教师、省化学学会秘书长">
                        <span class="text-danger"><@spring.showErrors ""/></span>
                    </div>
                </div>
                <div class="form-group">
                    <label for="inputEmail3" class="col-sm-2 control-label">会场地点</label>
                    <div class="col-sm-8">
                        <@spring.bind "addTopicForm.location"/>
                        <input type="text" class="form-control" id="input-location" name="location" value="${addTopicForm.location!}" placeholder="综合楼四楼报告厅">
                        <span class="text-danger"><@spring.showErrors ""/></span>
                    </div>
                </div>
                <div class="form-group">
                    <label for="inputEmail3" class="col-sm-2 control-label">会场容量</label>
                    <div class="col-sm-8">
                        <@spring.bind "addTopicForm.capacity"/>
                        <input type="number" class="form-control" id="input-capacity" name="capacity" value="${addTopicForm.capacity!}" placeholder="200">
                        <span class="text-danger"><@spring.showErrors ""/></span>
                    </div>
                </div>
                <div class="form-group">
                    <label for="input-act-name" class="col-sm-2 control-label">开始时间</label>
                    <div class="col-sm-8">
                        <@spring.bind "addTopicForm.startTime"/>
                        <input type="text" class="form-control" style="width: 150px;" id="input-start-time" name="startTime"
                               placeholder="开始日期" value="${(addTopicForm.startTime?string("yyyy-MM-dd HH:mm"))!}" readonly>
                        <span class="text-danger"><@spring.showErrors ""/></span>
                    </div>
                </div>
                <div class="form-group">
                    <label for="input-act-name" class="col-sm-2 control-label">结束时间</label>
                    <div class="col-sm-8">
                        <@spring.bind "addTopicForm.endTime"/>
                        <input type="text" class="form-control" style="width: 150px;" id="input-end-time" name="endTime"
                               placeholder="结束日期" value="${(addTopicForm.endTime?string("yyyy-MM-dd HH:mm"))!}" readonly>
                        <span class="text-danger"><@spring.showErrors ""/></span>
                    </div>
                </div>
                <div class="form-group">
                    <label for="input-act-name" class="col-sm-2 control-label"></label>
                    <div class="col-sm-8">
                        <button id="btn-save" type="button" class="btn btn-success pull-right"><span class="glyphicon glyphicon-ok" aria-hidden="true"></span> 提交
                        </button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</section>

</@layout.content>
<@layout.script>
<script type="text/javascript" src="<@spring.url '/webjars/typeaheadjs/0.11.1/typeahead.bundle.min.js'/>" charset="UTF-8"></script>
<script type="text/javascript" src="<@spring.url '/webjars/qrcodejs/1c78ccd/qrcode.js' />"></script>
<script type="text/javascript" src="<@spring.url '/webjars/bootstrap-datetimepicker/2.4.2/js/bootstrap-datetimepicker.min.js' />"></script>
<script type="text/javascript" src="<@spring.url '/webjars/bootstrap-datetimepicker/2.4.2/js/locales/bootstrap-datetimepicker.zh-CN.js' />"></script>
<script type="text/javascript">
    $(document).ready(function(){

        $("#btn-save").click(function(){
            $('#form-add').submit();
        });

        $("#input-start-time").datetimepicker({
            format: 'yyyy-mm-dd hh:ii',
            minView: 0,
            autoclose: true,
            language: 'zh-CN',
            todayBtn: true
        });

        $("#input-end-time").datetimepicker({
            format: 'yyyy-mm-dd hh:ii',
            minView: 0,
            autoclose: true,
            language: 'zh-CN',
            todayBtn: true
        });

        $("#input-start-time").on('changeDate', function(ev){
            $('#input-end-time').datetimepicker('setStartDate', ev.date);
        });

        // Set the Options for "Bloodhound" suggestion engine
        var engine = new Bloodhound({
            remote: {
                url: '<@spring.url '/backend/activityTips?keyword=%QUERY%'/>',
                wildcard: '%QUERY%'
            },
            datumTokenizer: Bloodhound.tokenizers.obj.whitespace('tipName'),
            queryTokenizer: Bloodhound.tokenizers.whitespace
        });

        $('#input-act-name').typeahead({
                    hint: true,
                    highlight: true,
                    minLength: 1
                },
                {
                    limit: 20,
                    async: true,
                    source: engine.ttAdapter(),
                    display: 'tipName',
                    templates: {
                        empty: [
                            '<div class="tt-suggestion tt-selectable">没有找到数据</div>'
                        ],

                        suggestion: function (data) {
                            return '<div class="tt-suggestion tt-selectable">' + data.tipName + '</div>'
                        }
                    }
                });

        $('#input-act-name').bind('typeahead:autocomplete', function(ev, suggestion) {
            console.log('autocomplete: ' + suggestion.id);
            $('#input-act-id').val(suggestion.id);
        });

        $('#input-act-name').bind('typeahead:selected', function(ev, suggestion) {
            console.log('selected: ' + suggestion.id);
            $('#input-act-id').val(suggestion.id);
        });
    });
</script>
</@layout.script>