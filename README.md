# Springboot 自定义异常实现
**默认响应及原因分析**
```
默认响应:
1.浏览器访问异常时返回默认的错误页面
2.客户端请求异常响应的是json数据
原因:
不同请求携带的请求头差异
```
**异常自动装配相关类**
```
DefaultErrorAttributes指定错误页面展示哪些错误数据
BasicErrorController默认的错误响应Controller
ErrorPageCustomizer自定义错误页面
DefaultErrorViewResolver默认的视图解析器
```
**自定义异常拦截**
```
@ControllerAdvice
public class MyExceptionHandler {
    @ExceptionHandler(DemoException.class)
    public Object handleException(Exception e, HttpServletRequest request) {
        // 必须指定错误码,不然默认成功200,不走我们的错误界面
        request.setAttribute("javax.servlet.error.status_code",400);
        Map<String,Object> map = new HashMap<>();
        map.put("status",-1);
        map.put("message",e.getMessage());
        request.setAttribute("err",map);
        return "forward:/error";
    }
}
```
**定制异常显示信息**
```
@Component
public class MyDefaultErrorAttributes extends DefaultErrorAttributes {

    @Override
    public Map<String, Object> getErrorAttributes(WebRequest webRequest, boolean includeStackTrace) {
        Map<String, Object> errorAttributes = super.getErrorAttributes(webRequest, includeStackTrace);
        errorAttributes.put("myerr",webRequest.getAttribute("err",SCOPE_REQUEST));
        return errorAttributes;
    }
}
```
