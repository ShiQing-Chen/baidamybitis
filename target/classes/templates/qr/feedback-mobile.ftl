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
    <style>
        .margin-bt10{margin-bottom: 10px;}
        .form-control {
            box-shadow: 0;
            outline: none;
        }
        .form-control:focus {
            box-shadow: 0;
            outline: none;
        }
        .regular-radio {
            display: none;
        }

        .regular-radio + label {
            -webkit-appearance: none;
            background-color: #fff;
            border: 1px solid #aaa;
            padding: 10px;
            border-radius:50px;
            display: inline-block;
            position: relative;
        }

        .regular-radio:checked + label:after {
            content: ' ';
            width: 14px;
            height: 14px;
            border-radius: 50px;
            position: absolute;
            top: 3px;
            background:#6dd5fa;
            /*box-shadow:0 0 5px 0 #6dd5fa;*/
            left: 3px;
        }
        .sty-inline{
            display: inline-block;vertical-align: middle;
        }
        .feed-title{margin-bottom: 10px;}
    </style>
</head>
<body>
<div class="container-fluid">
    <div class="row">
        <div class="col-xs-12 col-md-8"><h3>${(topic.topicName)!""}</h3></div>
    </div>
    <div class="row" style="margin-top: 10px;">
        <form>
            <div class="col-xs-12">
                <label class="feed-title" for="exampleInputEmail1">您对这堂课或讲座的整体感受评价：</label>
            </div>

            <div class="col-xs-6 margin-bt10">
                <div class="sty-inline">
                    <input type="radio" id="inlineRadio1" name="feedbackOption" value="1" class="regular-radio"
                           checked="checked"/>
                    <label for="inlineRadio1" style="margin-bottom: -3px;"></label>
                </div>
                <div class="sty-inline">非常满意</div>
            </div>
            <div class="col-xs-6 margin-bt10">
                <div class="sty-inline">
                    <input type="radio" id="inlineRadio2" name="feedbackOption" value="2" class="regular-radio"/>
                    <label for="inlineRadio2" style="margin-bottom: -3px;"></label>
                </div>
                <div class="sty-inline">满意</div>
            </div>
            <div class="col-xs-6 margin-bt10">
                <div class="sty-inline">
                    <input type="radio" id="inlineRadio3" name="feedbackOption" value="3" class="regular-radio"/>
                    <label for="inlineRadio3" style="margin-bottom: -3px;"></label>
                </div>
                <div class="sty-inline">一般</div>
            </div>
            <div class="col-xs-6 margin-bt10">
                <div class="sty-inline">
                    <input type="radio" id="inlineRadio4" name="feedbackOption" value="4" class="regular-radio"/>
                    <label for="inlineRadio4" style="margin-bottom: -3px;"></label>
                </div>
                <div class="sty-inline">较差</div>
            </div>
            <div class="col-xs-12">
                <label class="feed-title" for="exampleInputPassword1">您对这堂课或讲座的建议：</label>
                <textarea id="text-suggestion" class="form-control" rows="5" placeholder="输入建议"
                          style="resize: none;"></textarea>
                <button id="btn-save" type="button" class="btn btn-success" style="width: 100%;margin-top: 40px;">提交</button>
            </div>

        </form>
    </div>
</div>
<script type="text/javascript" src="<@spring.url '/webjars/jquery/3.2.1/jquery.min.js'/>"></script>
<script type="text/javascript" src="<@spring.url '/webjars/bootstrap/3.3.7/js/bootstrap.min.js'/>"></script>

<script type="text/javascript">
    $(document).ready(function () {
        $('#btn-save').click(function(){
            $.post("<@spring.url '/qr/addFeedback/${topic.id}'/>",
                    {
                        feedbackOption:$("input[name='feedbackOption']:checked").val(),
                        suggestion: $("#text-suggestion").val()
                    }, function (response) {
                        console.log(response);
                        if (response.success) {
                            document.location = "<@spring.url '/qr/success/${topic.id}'/>";
                        } else {
                            $.toast(response.message, 'danger');
                        }
                    },
                    "json"
            );
        });
    });
</script>
</body>
</html>

