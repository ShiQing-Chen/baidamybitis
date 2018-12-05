<#import "/spring.ftl" as spring>
<script type="text/javascript" src="<@spring.url '/webjars/jquery/3.2.1/jquery.min.js'/>"></script>
<script type="text/javascript" src="<@spring.url '/webjars/bootstrap/3.3.7/js/bootstrap.min.js'/>"></script>
<script type="text/javascript" src="<@spring.url '/webjars/bootstrap-notify/3.1.3-1/bootstrap-notify.min.js'/>"></script>
<script type="text/javascript" src="<@spring.url '/webjars/fastclick/1.0.6/lib/fastclick.js'/>"></script>
<script type="text/javascript" src="<@spring.url '/webjars//bootstrap-table/1.11.1/dist/bootstrap-table.min.js'/>"></script>
<script type="text/javascript" src="<@spring.url '/webjars//bootstrap-table/1.11.1/dist/locale/bootstrap-table-zh-CN.min.js'/>"></script>
<script type="text/javascript" src="<@spring.url '/webjars/AdminLTE/2.4.3/dist/js/adminlte.min.js'/>"></script>
<script type="text/javascript" src="<@spring.url '/webjars/AdminLTE/2.4.3/dist/js/demo.js'/>"></script>

<script>
    var productEnv = document.domain.indexOf("521ke")>=0;
    if(productEnv){
        var _hmt = _hmt || [];
        (function() {
            var hm = document.createElement("script");
            hm.src = "//hm.baidu.com/hm.js?a0bf78c95b1cb6b9de06dc6713e3eb34";
            var s = document.getElementsByTagName("script")[0];
            s.parentNode.insertBefore(hm, s);
        })();
    }
</script>
