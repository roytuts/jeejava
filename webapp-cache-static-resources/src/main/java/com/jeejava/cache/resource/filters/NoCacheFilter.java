package com.jeejava.cache.resource.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

import com.jeejava.cache.resource.enums.HTTPCacheHeader;

/**
 * 
 * @author https://www.jeejava.com
 *
 */

public class NoCacheFilter implements Filter {

	public NoCacheFilter() {
	}

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletResponse httpServletResponse = (HttpServletResponse) response;

		httpServletResponse.setHeader(HTTPCacheHeader.CACHE_CONTROL.getName(), "no-cache, no-store, must-revalidate");
		httpServletResponse.setDateHeader(HTTPCacheHeader.EXPIRES.getName(), 0L);

		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {

	}

}
