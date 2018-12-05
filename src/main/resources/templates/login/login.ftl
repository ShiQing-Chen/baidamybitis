<#import "/spring.ftl" as spring>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>课程帮活动反馈系统</title>
    <link href="${rc.contextPath}/webjars/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <style>
        .icon-userName{
            display: block;
            height: 32px;
            width: 32px;
            background: url("<@spring.url '/image/login-name.png'/>") no-repeat center center;
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
            background: url("<@spring.url '/image/login-password.png'/>") no-repeat center center;
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
        .ft1{
            color: #404653;
            font-size: 14px;
            text-align: center;
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
            <img src="${rc.contextPath}/static/img/index-logo.png" style="height: 50px;">
            <span class="welcome"><img src="${rc.contextPath}/static/img/system-title.png"></span>
        </div>
    </div>
    <div class="content-center">
        <div class="bg-img">
            <img src="${rc.contextPath}/static/img/banner_backdrop.png" style="width: 100%;">
            <div class="title-img">
                <img src="${rc.contextPath}/static/img/banner-title.png" style="height: 100%;">
            </div>
        </div>
        <div class="login-block">
            <label class="title">登录</label>
            <input id="localhost" type="hidden" value="${rc.contextPath}">
            <form>
                <div class="form-group col-xs-12 col-sm-12">
                    <div class="input-group">
                        <span class="input-group-addon group-custom"><span class="icon-userName"></span></span>
                        <input type="text" class="form-control" id="input_userName" placeholder="请输入用户名">
                    </div>
                </div>
                <div class="form-group col-xs-12 col-sm-12">
                    <div class="input-group">
                        <span class="input-group-addon group-custom"><span class="icon-password"></span></span>
                        <input type="password" class="form-control" id="input_password" placeholder="请输入密码">

                    </div>
                </div>
                <div class="form-group col-xs-12">
                    <div class="form-radbox">
                        <input type="checkbox" name="rem_user" id="rem_user">
                        <label for="rem_user" style="line-height: 16px;">记住用户名</label>
                    </div>
                </div>
                <div class="form-group col-xs-12 col-sm-12">
                    <button id="btn_login" type="button" class="col-xs-12 col-sm-12 btn btn-login">登录
                </div>
            </form>
        </div>
    </div>
    <div class="footer">
        <p class="ft1">北京课程帮科技有限公司</p>
        <p class="ft1"><span>地址：北京市东土城路8号林达大厦A座14层</span><span style="margin-left: 20px;">邮箱：support@dinsmooth.com</span></p>
        <p class="ft2">
            <span>©2015-2018 ALL Right Reserved.</span>
            <span>北京课程帮科技有限公司 and Privacy Policy</span><br>
            <span>京ICP备15058873号</span>   
            <span>京公网安备11010502032728</span>
        </p>
    </div>
</div>


<#include "../layout/script.ftl"/>

</body>
</html>
