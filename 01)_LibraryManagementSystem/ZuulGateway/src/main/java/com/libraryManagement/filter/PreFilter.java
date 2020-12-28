package com.libraryManagement.filter;

import javax.servlet.http.HttpServletRequest;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

public class PreFilter extends ZuulFilter {

	@Override
	public String filterType() {
		return "pre";
	}

	@Override
	public int filterOrder() {
		return 0;
	}

	@Override
	public boolean shouldFilter() {
//		RequestContext ctx = RequestContext.getCurrentContext();
//
//	    HttpServletRequest request = ctx.getRequest();
//
//	    String url = request.getRequestURI();
//
//	    if(url.contains("swagger-ui.html") || url.contains("swagger-resources") || url.contains("swagger")
//
//	    || url.contains("v2") || url.contains("webjars")){
//
//	        return false;
//
//	    }
	    return true;
	}

	@Override
	public Object run() {
		RequestContext ctx = RequestContext.getCurrentContext();
		HttpServletRequest request = ctx.getRequest();

		System.out.println(
				"Request Method : " + request.getMethod() + " Request URL : " + request.getRequestURL().toString());

		return null;
	}

}