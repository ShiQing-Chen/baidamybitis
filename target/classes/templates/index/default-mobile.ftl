<#import "/spring.ftl" as spring>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <meta name="description" content="">
    <meta name="keywords" content="新高考,课程帮,教育,云平台">
    <title>课程帮新高考教育云</title>

    <link href="<@spring.url '/webjars/bootstrap/3.3.7/css/bootstrap.min.css'/>" rel="stylesheet">
    <style>

    </style>
</head>
<body class="body-index" style='background-image: url("<@spring.url '/image/index/index_bg.jpg'/>")'>
<!-- login-Modal -->
<section id="login-content">
    <div class="main">
        <div class="title">课程帮新高考教育云</div>
        <div class="banner-bg" style="z-index: 100;">
            <div id="login-modal">
                <div class="modal-dialog" role="document">
                    <div class="body-index">
                        <div class="modal-body">
                            <div id="usersloginmodel" class="container-fluid">
                                <form id="form_Login" action="" method="post">
                                    <input type="hidden" id="r" name="r" value="${r!""}"/>
                                    <div class="row">
                                        <div class="col-md-3 col-md-offset-9">
                                        </div>
                                    </div>
                                    <div class="row loginpad01"
                                         style="font-size: 20px;color: #00a4ff;font-weight: bold;">
                                        登录
                                    </div>
                                    <div class="row loginpad01" style="height:10px;"></div>
                                    <div id="prompt_message" class="row loginpad01 prompt-message"
                                         style="height:20px;"></div>
                                    <div class="row loginpad01" id="loginbox">
                                        <div class="col-md-12 loginpad02">
                                            <input type="text" class="ec-form-control ec-loginname" id="j_username"
                                                   name="userName" placeholder="手机号/用户名/邮箱" maxlength="40"/>
                                        </div>
                                    </div>
                                    <div class="row loginpad01 prompt-message"></div>
                                    <div class="row loginpad01" id="logpwdbox">
                                        <div class="col-md-12 loginpad02">
                                            <input type="password" class="ec-form-control ec-password" id="j_password"
                                                   name="password" placeholder="输入密码" maxlength="40"/>
                                        </div>
                                    </div>
                                    <div class="row loginpad01 prompt-message"></div>
                                    <div class="row loginpad01">
                                        <div class="col-md-12 loginpad02">
                                            <button id="btn_Login" class="btn btn-blue">登录</button>
                                        </div>
                                    </div>
                                    <div class="row loginpad01" style="height:55px;"></div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>

<script type="text/javascript" src="<@spring.url '/webjars/jquery/3.2.1/jquery.min.js'/>"></script>
<script type="text/javascript" src="<@spring.url '/webjars/bootstrap/3.3.7/js/bootstrap.min.js'/>"></script>


<script type="text/javascript">
    $(document).ready(function () {
    });
</script>
</body>
</html>
