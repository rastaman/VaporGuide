package com.bsalm.vaporguide.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

public class CORSFilter implements Filter {

	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException 
	{
		HttpServletResponse response = (HttpServletResponse) res;
		
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "GET,PUT,POST,DELETE");
		response.addHeader("Access-Control-Allow-Headers", "Content-Type");
		//response.setHeader("Access-Control-Allow-Headers", "x-requested-with");
		response.setHeader("Access-Control-Expose-Headers", "x-requested-with"); 

		chain.doFilter(req, res);
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}
}