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
        <div class="col-xs-12 col-md-8"><h3>请先填写您的联系信息：</h3></div>
    </div>
    <div class="row" style="margin-top: 20px;">
        <div class="col-xs-12 col-md-8">
            <form id="form" action="<@spring.url '/login/qrLogin'/>" method="post">
                <input type="hidden" name="r" value="${userInfoForm.r!}"/>
                <div class="form-group">
                    <label for="exampleInputPassword1">您的学校名称：</label>
                    <@spring.bind "userInfoForm.schoName"/>
                    <input id="input-scho-name" name="schoName" value="${userInfoForm.schoName!}" class="form-control" placeholder="学校名称"/>
                    <span class="text-danger"><@spring.showErrors ""/></span>
                </div>
                <div class="form-group">
                    <label for="exampleInputPassword1">您的学科：</label>
                    <@spring.bind "userInfoForm.subName"/>
                    <input id="input-sub-name" name="subName" value="${userInfoForm.subName!}" class="form-control" placeholder="学科"/>
                    <span class="text-danger"><@spring.showErrors ""/></span>
                </div>
                <div class="form-group">
                    <label for="exampleInputPassword1">您的姓名：</label>
                    <@spring.bind "userInfoForm.name"/>
                    <input id="input-name" name="name" value="${userInfoForm.name!}" class="form-control" placeholder="姓名"/>
                    <span class="text-danger"><@spring.showErrors ""/></span>
                </div>
                <div class="form-group">
                    <label for="exampleInputPassword1">您的手机号：</label>
                    <@spring.bind "userInfoForm.mobile"/>
                    <input id="input-mobile" name="mobile" value="${userInfoForm.mobile!}" class="form-control" placeholder="手机号"/>
                    <span class="text-danger"><@spring.showErrors ""/></span>
                </div>
                <button id="btn-save" type="button" class="btn btn-success" style="width: 100%">提交</button>
            </form>
        </div>
    </div>
</div>
<script type="text/javascript" src="<@spring.url '/webjars/jquery/3.2.1/jquery.min.js'/>"></script>
<script type="text/javascript" src="<@spring.url '/webjars/bootstrap/3.3.7/js/bootstrap.min.js'/>"></script>

<script type="text/javascript">
    $(document).ready(function () {
        $('#btn-save').click(function(){
            $("#form").submit();
        });
    });
</script>
</body>
</html>

