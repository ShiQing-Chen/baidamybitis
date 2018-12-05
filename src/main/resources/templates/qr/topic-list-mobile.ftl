<#import "/spring.ftl" as spring>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <meta name="description" content="">
    <meta name="keywords" content="新高考,课程帮,教育,云平台">
    <title>课程帮活动反馈系统</title>

    <link href="<@spring.url '/webjars/bootstrap/3.3.7/css/bootstrap.min.css'/>" rel="stylesheet">
</head>
<body>
<div class="container-fluid">
    <div class="row">
        <div class="col-xs-12 col-md-8 text-center" style="margin-top: 40px;"><h3>签到成功！</h3></div>
    </div>
    <#list passedList as topic>
        <div class="panel panel-warning">
            <div class="panel-heading">${topic.topicName}</div>
            <div class="panel-body">
                开始时间：${(topic.startTime?string("yyyy-MM-dd HH:mm"))!}<br/>
                结束时间：${(topic.endTime?string("yyyy-MM-dd HH:mm"))!}<br/>
                主讲嘉宾：${topic.speaker!}<br/>
                嘉宾简介：${topic.speakerIntro!}<br/>
                容纳人数：${topic.capacity!}<br/>
            </div>
            <div class="panel-footer">地点：${topic.location}</div>
        </div>
    </#list>
    <#list todayUnPassedList as topic>
        <div class="panel panel-success">
            <div class="panel-heading">${topic.topicName}</div>
            <div class="panel-body">
                开始时间：${(topic.startTime?string("yyyy-MM-dd HH:mm"))!}<br/>
                结束时间：${(topic.endTime?string("yyyy-MM-dd HH:mm"))!}<br/>
                主讲嘉宾：${topic.speaker!}<br/>
                嘉宾简介：${topic.speakerIntro!}<br/>
                容纳人数：${topic.capacity!}<br/>
            </div>
            <div class="panel-footer">地点：${topic.location}</div>
        </div>
    </#list>
    <#list comingDaysList as topic>
        <div class="panel panel-primary">
            <div class="panel-heading">${topic.topicName}</div>
            <div class="panel-body">
                开始时间：${(topic.startTime?string("yyyy-MM-dd HH:mm"))!}<br/>
                结束时间：${(topic.endTime?string("yyyy-MM-dd HH:mm"))!}<br/>
                主讲嘉宾：${topic.speaker!}<br/>
                嘉宾简介：${topic.speakerIntro!}<br/>
                容纳人数：${topic.capacity!}<br/>
            </div>
            <div class="panel-footer">地点：${topic.location}</div>
        </div>
    </#list>

    <div class="row" style="margin-top: 20px;">
        <div class="col-xs-12 col-md-8">
            <img src="<@spring.url '/image/qr/kcb-jingcai.jpg'/>" style="width: 100%;"/>
        </div>
    </div>
</div>
<script type="text/javascript" src="<@spring.url '/webjars/jquery/3.2.1/jquery.min.js'/>"></script>
<script type="text/javascript" src="<@spring.url '/webjars/bootstrap/3.3.7/js/bootstrap.min.js'/>"></script>

<script type="text/javascript">
    $(document).ready(function () {

    });
</script>
</body>
</html>