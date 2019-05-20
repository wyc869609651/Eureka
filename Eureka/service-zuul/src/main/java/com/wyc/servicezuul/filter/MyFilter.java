package com.wyc.servicezuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.logging.Logger;

@Component
public class MyFilter extends ZuulFilter {

    //过滤器的类型。pre:路由之前、routing:路由之时、post:路由之后、error:发送错误调用
    @Override
    public String filterType() {
        return "pre";
    }

    //过滤的顺序
    @Override
    public int filterOrder() {
        return 0;
    }

    //这里可以写判断逻辑，是否要过滤，true永远过滤
    @Override
    public boolean shouldFilter() {
        return true;
    }

    //过滤器的具体逻辑。可以很复杂，包括sql,nosql去判断该请求到底有没有权限
    @Override
    public Object run() throws ZuulException {
        Logger log = Logger.getLogger(MyFilter.class.getName());
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        log.info(String.format("%s >>> %s", request.getMethod(), request.getRequestURL().toString()));
        String token = request.getParameter("token");
        if(token==null){
            log.warning("token is empty");
            //false代表的意思是,这个请求最终不会被zuul转发到后端服务器,
            // 但是如果当前Filter后面还存在其他Filter,那么其他Filter仍然会被调用到,
            // 所以一般我们在Filter的shouldFilter方法中通过cxt.sendZuulResponse来觉得是否拦截掉请求
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);
            try {
                ctx.getResponse().getWriter().write("token is empty");
            }catch (Exception e){
                e.printStackTrace();
            }
            return null;
        }
        log.info("ok");
        return null;
    }
}
