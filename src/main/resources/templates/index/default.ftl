<#import "/spring.ftl" as spring>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="keywords" content="新高考,课程帮,教育,云平台">
    <title>课程帮活动反馈系统</title>

    <link href="<@spring.url '/webjars/bootstrap/3.3.7/css/bootstrap.min.css'/>" rel="stylesheet">
    <link href="<@spring.url '/css/common.css'/>" rel="stylesheet">
    <style>
        .icon-username{
            display: block;
            height: 32px;
            width: 32px;
            background: url("<@spring.url '/image/index/login-username.png'/>") no-repeat center center;
            background-size: 60% 60%;
        }
        .group-custom{
            padding: 0;
            background: #fff;
        }

        .icon-password{
            display: block;
            height: 32px;
            width: 32px;
            background: url("<@spring.url '/image/index/login-password.png'/>") no-repeat center center;
            background-size: 60% 60%;
        }
        .group-custom{
            padding: 0;
            background: #fff;
        }

        .header{
            height: 150px;
            width: 100%;
        }
        .logo{
            padding: 50px 200px;
        }
        .welcome{
            color: #666666;
            font-size: 12px;
            display: inline-block;
            vertical-align: middle;
            height: 50px;
            line-height: 50px;
            border-left: 1px solid #ccc;
            padding-left: 15px;
            margin-left: 15px;
        }
        .content-center{
            position: relative;
            min-width: 1270px;
        }
        .bg-img{
            position: relative;
        }
        .title-img{
            position: absolute;
        }
        .login-block {
            width: 320px;
            height: 320px;
            color: #777;
            top: 50px;
            right:15%;
            text-align: left;
            position: absolute;
            z-index: 2;
            border-radius:4px;
            background-color: #fff;
        }
        .login-block  .title{
            font-size: 18px;
            color: #00a4ff;
            padding: 20px 15px;
        }
        .form-group {
            margin-bottom: 30px;
        }
        .group-custom {
            padding: 0 4px;
        }
        .form-control {
            height: 40px;
        }
        .footer{
            padding: 50px 0 20px;
        }
        .ft2{
            color: #838d9f;
            font-size: 14px;
            text-align: center;
            padding-top: 10px;
        }
    </style>
</head>
<body>
<div class="container-fluid" style="padding: 0;">
    <div class="header">
        <div class="logo">
            <img src="<@spring.url '/image/index/index-logo.png'/>" style="height: 50px;">
            <span class="welcome">活动反馈系统</span>
        </div>
    </div>
    <div class="content-center">
        <div class="bg-img">
            <img src="<@spring.url '/image/index/index-backdrop.png'/>" style="width: 100%;">
        </div>
        <div class="login-block">
            <label class="title">登录</label>
            <form>
                <div class="form-group col-xs-12 col-sm-12">
                    <div class="input-group">
                        <span class="input-group-addon group-custom"><span class="icon-username"></span></span>
                        <input type="text" class="form-control" id="input-username" placeholder="请输入用户名">
                    </div>
                </div>
                <div class="form-group col-xs-12 col-sm-12">
                    <div class="input-group">
                        <span class="input-group-addon group-custom"><span class="icon-password"></span></span>
                        <input type="password" class="form-control" id="input-password" placeholder="请输入密码">

                    </div>
                </div>
                <div class="form-group col-xs-12 col-sm-12">
                    <button id="btn-login" type="button" class="col-xs-12 col-sm-12 btn btn-login">登录
                </div>
            </form>
        </div>
    </div>
    <div class="footer">
        <p class="ft2">
            <span>©2015-2018 ALL Right Reserved.</span>
            <span>北京课程帮科技有限公司 and Privacy Policy</span><br>
            <span>京ICP备15058873号</span>   
            <span>京公网安备11010502032728</span>
        </p>
    </div>
</div>
<script type="text/javascript" src="<@spring.url '/webjars/jquery/3.2.1/jquery.min.js'/>"></script>
<script type="text/javascript" src="<@spring.url '/webjars/bootstrap/3.3.7/js/bootstrap.min.js'/>"></script>

<script type="text/javascript">
    $(document).ready(function () {
        $("#btn-login").click(function () {
            $.post('<@spring.url "/login/doLogin"/>',
                    {
                        mobile: $("#input-username").val(),
                        mobileCode: $("#input-password").val()
                    }, function (response) {
                        console.log(response);
                        if (response.success) {
                            window.location.href = '<@spring.url "/dashboard"/>';
                        } else {
                            console.log("登录失败");
                        }
                    },
                    "json"
            );
        });
    });
</script>
</body>
</html>

