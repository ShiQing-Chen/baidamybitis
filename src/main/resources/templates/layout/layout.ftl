<#import "/spring.ftl" as spring>
<#macro header>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <title>${systemTitle!"课程帮活动反馈系统"}</title>
    <link rel="stylesheet" type="text/css" href="<@spring.url '/webjars/bootstrap/3.3.7/css/bootstrap.min.css'/>"
          media="screen"/>
    <link rel="stylesheet" type="text/css"
          href="<@spring.url '/webjars/font-awesome/4.7.0/css/font-awesome.min.css'/>"
          media="screen"/>
    <link rel="stylesheet" type="text/css" href="<@spring.url '/webjars/ionicons/2.0.1/css/ionicons.min.css'/>"
          media="screen"/>
    <link rel="stylesheet" type="text/css" href="<@spring.url '/webjars/animate.css/3.5.2/animate.min.css'/>"
          media="screen"/>
    <link rel="stylesheet" type="text/css"
          href="<@spring.url '/webjars/bootstrap-table/1.11.1/dist/bootstrap-table.min.css'/>"
          media="screen"/>
    <link rel="stylesheet" type="text/css" href="<@spring.url '/webjars/AdminLTE/2.4.3/dist/css/AdminLTE.min.css'/>"
          media="screen"/>
    <link rel="stylesheet" type="text/css"
          href="<@spring.url '/webjars/AdminLTE/2.4.3/dist/css/skins/skin-black.min.css'/>"
          media="screen"/>
    <#nested/>
    <style type="text/css">
        .fixed-table-pagination{
            padding-left: 10px;
            padding-right: 10px;
        }
    </style>
</head>
<body class="hold-transition skin-black sidebar-mini fixed">
</#macro>

<#macro content>
<div class="wrapper">
    <header class="main-header">
        <a href="/" class="logo">
            <span class="logo-mini">
                <img src="<@spring.url '/image/layout/logo-mini.png'/>" height="40">
            </span>
            <span class="logo-lg">
                <img src="<@spring.url '/image/layout/logo.png'/>" height="40">
            </span>
        </a>

        <!-- Header Navbar: style can be found in header.less -->
        <nav class="navbar navbar-static-top">
            <!-- Sidebar toggle button-->
            <a href="#" class="sidebar-toggle" data-toggle="push-menu" role="button">
                <span class="sr-only">侧边栏控制</span>
            </a>
            <!-- Navbar Right Menu -->
            <div class="navbar-custom-menu">
                <ul class="nav navbar-nav">
                    <!-- User Account: style can be found in dropdown.less -->
                    <li class="dropdown user user-menu">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                            <img src='${(curUser.headImg)!rc.contextPath+"/image/layout/user2-160x160.jpg"}' class="user-image"
                                 alt="User Image">
                            <span class="hidden-xs">${(curUser.name)!"未登录"}</span>
                        </a>
                        <ul class="dropdown-menu">
                            <!-- User img -->
                            <li class="user-header">
                                <img src='${(curUser.headImg)!rc.contextPath+"/image/layout/user2-160x160.jpg"}' class="img-circle" alt="User Image">
                                <p>
                                ${(curUser.name)!"未登录"} - ${(curUser.schoName)!"未知学校"}
                                    <small>欢迎</small>
                                </p>
                            </li>
                            <!-- Menu Body -->
                            <!-- Menu Footer-->
                            <li class="user-footer">
                                <div class="pull-left">
                                    <a href="#" class="btn btn-default btn-flat">个人信息</a>
                                </div>
                                <div class="pull-right">
                                    <a id="btn-logout" href="#" class="btn btn-default btn-flat">登出</a>
                                </div>
                            </li>
                        </ul>
                    </li>
                </ul>
            </div>
        </nav>
    </header>
    <!-- Left side column. contains the logo and sidebar -->
    <aside class="main-sidebar">
        <!-- sidebar: style can be found in sidebar.less -->
        <section class="sidebar">
            <!-- sidebar menu: : style can be found in sidebar.less -->
            <ul class="sidebar-menu" data-widget="tree">
                <li class="header">系统菜单</li>
                <li><a href="<@spring.url '/dashboard'/>"><i class="fa fa-dashboard"></i> <span>系统面板</span></a></li>
                <li><a href="<@spring.url '/backend/activity'/>"><i class="fa fa-laptop" aria-hidden="true"></i> <span>活动管理</span></a></li>
                <li><a href="<@spring.url '/backend/topic'/>"><i class="fa fa-envira" aria-hidden="true"></i> <span>主题管理</span></a></li>
                <li><a href="<@spring.url '/backend/feedback'/>"><i class="fa fa-heart" aria-hidden="true"></i> <span>反馈管理</span></a></li>
                <li><a href="<@spring.url '/backend/checkIn'/>"><i class="glyphicon glyphicon-copy" aria-hidden="true"></i> <span>签到查询</span></a></li>
            </ul>
        </section>
        <!-- /.sidebar -->
    </aside>

    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <#nested/>
    </div>
    <!-- /.content-wrapper -->
    <footer class="main-footer">
        <div class="pull-right hidden-xs" style="color: gray;">
            <b>版本</b> ${buildVersion}
        </div>
        <strong>Copyright &copy; 2017-2018 <a href="https://www.521ke.com">课程帮</a></strong> 版权所有
    </footer>
</div>
</#macro>

<#macro script>
    <#include "script.ftl"/>
    <#nested/>

<script type="text/javascript">
    $(document).ready(function(){
        $('#btn-logout').click(function() {
            $.post('${rc.contextPath}/sso/doLogout',
                    {},
                    function (response) {
                        console.log(response);
                        if (response.success) {//登录成功
                            document.location = "${rc.contextPath}/sso/login";
                        } else {//登录失败
                            $.notify({
                                // options
                                message: response.message
                            }, {
                                // settings
                                type: 'danger',
                                newest_on_top: true
                            });
                        }
                    });
        });

        var url = window.location;

// for sidebar menu entirely but not cover treeview
        $('ul.sidebar-menu a').filter(function() {
            return this.href == url;
        }).parent().addClass('active');

// for treeview
        $('ul.treeview-menu a').filter(function() {
            return this.href == url;
        }).parentsUntil(".sidebar-menu > .treeview-menu").addClass('active');
    });
</script>
</body>
</html>
</#macro>