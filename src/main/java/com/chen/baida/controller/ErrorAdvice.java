package com.chen.baida.controller;

import com.chen.baida.task.MailSenderTask;
import com.chen.baida.util.HttpRequestUtils;
import com.chen.baida.util.ServerInfoUtils;
import com.chen.baida.vo.MessageVo;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.task.TaskExecutor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mobile.device.Device;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

/**
 * @author HanHongmin 2017-11-26
 */
@ControllerAdvice
public class ErrorAdvice {
    private static final Logger LOGGER = LoggerFactory.getLogger(ErrorAdvice.class);
    private static final String REPORT_TO = " ";

    @Value("${application.name}")
    private String applicationName;

    private final TaskExecutor taskExecutor;

    @Autowired
    public ErrorAdvice(TaskExecutor taskExecutor) {
        this.taskExecutor = taskExecutor;
    }

    @ExceptionHandler(RuntimeException.class)
    public Object defaultError(HttpServletRequest request, Exception e){
        //时间戳,只适用于查找具体报错日志方便
        long currentTimeMillis = System.currentTimeMillis();
        String serverIp = ServerInfoUtils.getServerIp();
        String ipLast = serverIp.substring(serverIp.lastIndexOf('.')+1);
        String errorCode = ipLast + "-" + currentTimeMillis;

        boolean isAjax = HttpRequestUtils.isAjax(request);

        String subject = "["+applicationName+"]错误报告["+serverIp+"]["+errorCode+"]";

        MailSenderTask task = new MailSenderTask(REPORT_TO,subject, ExceptionUtils.getStackTrace(e));
        taskExecutor.execute(task);
        LOGGER.error("====错误:[{}]====[{}]====[{}]",errorCode,isAjax,request.getRequestURL(),e);

        if(isAjax){
            MessageVo result = new MessageVo(false,"错误",errorCode);
            return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON_UTF8).body(result);
        }else{
            ModelAndView mv = new ModelAndView("error/error");
            mv.addObject("errorCode",errorCode);
            return mv;
        }
    }

    @RequestMapping(value = "/error/403",produces = MediaType.TEXT_HTML_VALUE)
    public String error403(String r, Model model, Device device){
        model.addAttribute("r",r);
        //判断浏览器是否是PC端
        if(device.isNormal()){
            return "error/403";
        }else{
            return "error/403-mobile";
        }
    }

    @RequestMapping("/error")
    public String handleError(HttpServletRequest request) {
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);

        if (status != null) {
            Integer statusCode = Integer.valueOf(status.toString());
            if(statusCode == HttpStatus.NOT_FOUND.value()) {
                return "error-404";
            }
            else if(statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
                return "error-500";
            }
        }
        return "error";
    }
}
