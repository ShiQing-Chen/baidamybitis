<#import "/spring.ftl" as spring>
<#import "../layout/layout.ftl" as layout>
<@layout.header>
<style type="text/css">
</style>
</@layout.header>
<@layout.content>
<section class="content-header">
    <h1>
        系统面板
    </h1>
    <ol class="breadcrumb">
        <li><a href="<@spring.url '/dashboard'/>"><i class="fa fa-dashboard"></i> 首页</a></li>
        <li class="active">系统面板</li>
    </ol>
</section>

<section class="content">
    <div class="row">
        <div class="col-lg-3 col-xs-6">
            <div class="small-box bg-aqua">
                <div class="inner">
                    <h3>${totalCheckIn}</h3>
                    <p>签到总数</p>
                </div>
                <div class="icon">
                    <i class="ion ion-person-add"></i>
                </div>
                <a href="#" class="small-box-footer">查看详情 <i class="fa fa-arrow-circle-right"></i></a>
            </div>
        </div>
        <div class="col-lg-3 col-xs-6">
            <div class="small-box bg-green">
                <div class="inner">
                    <h3>${todayCheckIn}</h3>
                    <p>今日签到</p>
                </div>
                <div class="icon">
                    <i class="ion ion-bag"></i>
                </div>
                <a href="#" class="small-box-footer">查看详情 <i class="fa fa-arrow-circle-right"></i></a>
            </div>
        </div>
        <div class="col-lg-3 col-xs-6">
            <div class="small-box bg-yellow">
                <div class="inner">
                    <h3>${totalTopic}</h3>
                    <p>主题数量</p>
                </div>
                <div class="icon">
                    <i class="fa fa-envira"></i>
                </div>
                <a href="#" class="small-box-footer">查看详情 <i class="fa fa-arrow-circle-right"></i></a>
            </div>
        </div>
        <div class="col-lg-3 col-xs-6">
            <div class="small-box bg-red">
                <div class="inner">
                    <h3>${totalFeedback}</h3>
                    <p>反馈数量</p>
                </div>
                <div class="icon">
                    <i class="ion ion-pie-graph"></i>
                </div>
                <a href="#" class="small-box-footer">查看详情 <i class="fa fa-arrow-circle-right"></i></a>
            </div>
        </div>
    </div>
    <div class="box">
        <div class="box-header with-border">
            <h3 class="box-title">累计签到</h3>
            <div class="box-tools pull-right">
                <button type="button" class="btn btn-box-tool" data-widget="collapse" data-toggle="tooltip"
                        title="Collapse">
                    <i class="fa fa-minus"></i></button>
                <button type="button" class="btn btn-box-tool" data-widget="remove" data-toggle="tooltip" title="Remove">
                    <i class="fa fa-times"></i></button>
            </div>
        </div>
        <div class="box-body">
            <div id="chart-total" style="width: 100%;height:380px;"></div>
        </div>
    </div>
</section>
</@layout.content>
<@layout.script>
<script type="text/javascript" src="<@spring.url '/webjars/echarts/4.1.0/echarts.min.js'/>"></script>
<script type="text/javascript">
    $(document).ready(function(){
        var chartTotal = echarts.init(document.getElementById('chart-total'),'light');
        chartTotal.showLoading({
            text :"正在加载数据"
        });

        $.get("<@spring.url '/backend/chartSignIn'/>", function (response) {
                    console.log(response);
                    var data = response.data;
                    var xData = [];
                    var sData = [];
                    for(var i = 0;i< data.length;i++){
                        var d = data[i];
                        xData.push(d.key);
                        sData.push(d.num);
                    }

                    if (response.success) {
                        console.log(response);
                        chartTotal.hideLoading();
                        var option = {
                            xAxis: {
                                name: '小时时刻',
                                type: 'category',
                                boundaryGap: false,
                                data: xData
                            },
                            yAxis: {
                                name: '人数',
                                type: 'value'
                            },
                            series: [{
                                data: sData,
                                type: 'line',
                                areaStyle: {}
                            }],
                            tooltip: {
                                formatter: function (params) {
                                    return "截止今日"+ params.name + ":00点共累计签到" + params.value + "人";
                                }
                            }
                        };

                        chartTotal.setOption(option);
                    } else {
                        $.toast(response.message, 'danger');
                    }
                },
                "json"
        );

    });
</script>
</@layout.script>