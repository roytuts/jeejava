package com.jeejava.cache.resource.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

import com.jeejava.cache.resource.enums.CacheConfigParameter;
import com.jeejava.cache.resource.enums.Cacheability;
import com.jeejava.cache.resource.enums.HTTPCacheHeader;

/**
 * 
 * @author https://www.jeejava.com
 *
 */

public class CacheFilter implements Filter {
	private Cacheability cacheability;

	private boolean isStatic;

	private long seconds;

	/**
	 * Default constructor.
	 */
	public CacheFilter() {
	}

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletResponse httpServletResponse = (HttpServletResponse) response;
		StringBuilder cacheControl = new StringBuilder(cacheability.getValue()).append(", max-age=").append(seconds);

		if (!isStatic) {
			cacheControl.append(", must-revalidate");
		}

		// Set cache directives
		httpServletResponse.setHeader(HTTPCacheHeader.CACHE_CONTROL.getName(), cacheControl.toString());
		httpServletResponse.setDateHeader(HTTPCacheHeader.EXPIRES.getName(),
				System.currentTimeMillis() + seconds * 1000L);

		if (httpServletResponse.containsHeader("Pragma")) {
			httpServletResponse.setHeader(HTTPCacheHeader.PRAGMA.getName(), null);
		}

		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
		cacheability = (Boolean.valueOf(fConfig.getInitParameter(CacheConfigParameter.PRIVATE.getName())))
				? Cacheability.PRIVATE
				: Cacheability.PUBLIC;
		isStatic = Boolean.valueOf(fConfig.getInitParameter(CacheConfigParameter.STATIC.getName()));

		try {
			seconds = Long.valueOf(fConfig.getInitParameter(CacheConfigParameter.EXPIRATION_TIME.getName()));
		} catch (NumberFormatException e) {
			throw new ServletException(new StringBuilder("The initialization parameter ")
					.append(CacheConfigParameter.EXPIRATION_TIME.getName()).append(" is missing for filter ")
					.append(fConfig.getFilterName()).append(".").toString());
		}

	}

}
