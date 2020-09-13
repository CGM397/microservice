package nju.cgm.gateway.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @author: Bright Chan
 * @date: 2020/9/12 16:34
 * @description: 请求过滤器
 */

@Component
public class MyFilter extends ZuulFilter {

    private Logger logger = LoggerFactory.getLogger(MyFilter.class);
    /**
     * filter类型：
     * "pre": for pre-routing filtering
     * "route": for routing to an origin
     * "post": for post-routing filters
     * "error": for error handling
     * "static": for static responses
     * @return 上述四种类型之一
     */
    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    /**
     * filter执行顺序
     * @return int值，值越小，优先级越高
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * filter开关
     * @return true-开；false-关
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * 具体的过滤方法
     * @return the return from ZuulFilterResult
     */
    @Override
    public Object run() throws ZuulException {
        RequestContext rc = RequestContext.getCurrentContext();
        HttpServletRequest request = rc.getRequest();
        logger.info("请求路径：{}, 请求提交的方式是{}",
                request.getRequestURL().toString(),
                request.getMethod());
        return null;
    }
}
