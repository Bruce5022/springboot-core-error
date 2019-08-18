package com.sky.error;

import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;
import java.util.Map;
import static org.springframework.web.context.request.RequestAttributes.SCOPE_REQUEST;

@Component
public class MyDefaultErrorAttributes extends DefaultErrorAttributes {

    @Override
    public Map<String, Object> getErrorAttributes(WebRequest webRequest, boolean includeStackTrace) {
        Map<String, Object> errorAttributes = super.getErrorAttributes(webRequest, includeStackTrace);
        errorAttributes.put("myerr",webRequest.getAttribute("err",SCOPE_REQUEST));
        return errorAttributes;
    }
}
