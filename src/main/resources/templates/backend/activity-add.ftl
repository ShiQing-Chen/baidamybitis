<#import "/spring.ftl" as spring>
<#import "../layout/layout.ftl" as layout>
<@layout.header>
<link href="<@spring.url '/webjars/bootstrap-datetimepicker/2.4.2/css/bootstrap-datetimepicker.min.css'/>" rel="stylesheet" media="screen">
</@layout.header>
<@layout.content>
<section class="content-header">
    <h1>
        新建活动
    </h1>
    <ol class="breadcrumb">
        <li><a href="<@spring.url '/dashboard'/>"><i class="fa fa-dashboard"></i> 首页</a></li>
        <li><a href="<@spring.url '/backend/activity'/>"> 活动管理</a></li>
        <li class="active">新建活动</li>
    </ol>
</section>

<section class="content">
    <div class="box">
        <div class="box-body">
            <form class="form-horizontal" id="form-show" action="'/>" method="post">
                <div class="form-group">
                    <label for="input-act-name" class="col-sm-2 control-label">活动名称</label>
                    <div class="col-sm-8">
                        <@spring.bind "addActivityForm.actName"/>
                        <input type="text" class="form-control" id="input-act-name" name="actName" placeholder="活动名称"
                               value="${addActivityForm.actName!}">
                        <span class="text-danger"><@spring.showErrors ""/></span>
                    </div>
                </div>
                <div class="form-group">
                    <label for="input-act-name" class="col-sm-2 control-label">开始日期</label>
                    <div class="col-sm-8">
                        <@spring.bind "addActivityForm.startTime"/>
                        <input type="text" class="form-control" style="width: 160px;" id="input-start-time" name="startTime"
                               placeholder="开始日期" value="${(addActivityForm.startTime?string("yyyy-MM-dd HH:mm"))!}" readonly>
                        <span class="text-danger"><@spring.showErrors ""/></span>
                    </div>
                </div>
                <div class="form-group">
                    <label for="input-act-name" class="col-sm-2 control-label">结束日期</label>
                    <div class="col-sm-8">
                        <@spring.bind "addActivityForm.endTime"/>
                        <input type="text" class="form-control" style="width: 160px;" id="input-end-time" name="endTime"
                               placeholder="结束日期" value="${(addActivityForm.endTime?string("yyyy-MM-dd HH:mm"))!}" readonly>
                        <span class="text-danger"><@spring.showErrors ""/></span>
                    </div>
                </div>
                <div class="form-group">
                    <label for="input-act-name" class="col-sm-2 control-label">活动地点</label>
                    <div class="col-sm-8">
                        <@spring.bind "addActivityForm.location"/>
                        <input type="text" class="form-control" id="input-location" name="location" placeholder="活动地点"
                               value="${addActivityForm.location!}">
                        <span class="text-danger"><@spring.showErrors ""/></span>
                    </div>
                </div>
                <div class="form-group">
                    <label for="input-act-name" class="col-sm-2 control-label">主办单位</label>
                    <div class="col-sm-8">
                        <@spring.bind "addActivityForm.organizer"/>
                        <input type="text" class="form-control" id="input-organizer" name="organizer" placeholder="举办方"
                               value="${addActivityForm.organizer!}">
                        <span class="text-danger"><@spring.showErrors ""/></span>
                    </div>
                </div>
                <div class="form-group">
                    <label for="input-act-name" class="col-sm-2 control-label">协办单位</label>
                    <div class="col-sm-8">
                        <@spring.bind "addActivityForm.coOrganizer"/>
                        <input type="text" class="form-control" id="input-co-organizer" name="coOrganizer" placeholder="协办方"
                               value="${addActivityForm.coOrganizer!}">
                        <span class="text-danger"><@spring.showErrors ""/></span>
                    </div>
                </div>
                <div class="form-group">
                    <label for="input-act-name" class="col-sm-2 control-label">指导单位</label>
                    <div class="col-sm-8">
                        <@spring.bind "addActivityForm.leaderOrganizer"/>
                        <input type="text" class="form-control" id="input-leader-organizer" name = "leaderOrganizer"
                               placeholder="指导单位" value="${addActivityForm.leaderOrganizer!}">
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
    });
</script>
</@layout.script>