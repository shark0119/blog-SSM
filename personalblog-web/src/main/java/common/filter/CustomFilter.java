/*
 * 作者		www.TheWk.cn.vc
 * 开发环境	Windows7 64位 MyEclipse8.6 JDK1.6.0_45
 * 开发日期	2014年5月4日
 */
package common.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * <hr/>
 */
public class CustomFilter implements Filter {

	public void init(FilterConfig filterConfig) throws ServletException {

	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		chain.doFilter(request, response);
	}

	public void destroy() {
	}

}
