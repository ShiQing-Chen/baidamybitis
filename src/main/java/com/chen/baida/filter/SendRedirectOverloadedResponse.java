package com.chen.baida.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import java.io.IOException;

/**
 * @author HanHongmin 2018-01-24
 * @since 0.0.1
 */
public class SendRedirectOverloadedResponse extends HttpServletResponseWrapper {
    private static final String HEAD_HTTPS = "x-forwarded-proto";
    private HttpServletRequest request;

    SendRedirectOverloadedResponse(HttpServletRequest request, HttpServletResponse response) {
        super(response);
        this.request = request;
    }

    @Override
    public void sendRedirect(String location) throws IOException {
        //https 并且是相对路径
        if(isHttps()&&!isUrlAbsolute(location)){
            super.sendRedirect("https://" + request.getServerName() + location);
        }else{
            super.sendRedirect(location);
        }
    }

    private boolean isUrlAbsolute(String url) {
        return url.toLowerCase().startsWith("http://")||url.toLowerCase().startsWith("https://");
    }

    private boolean isHttps(){
        return "https".equalsIgnoreCase(request.getHeader(HEAD_HTTPS));
    }
}
