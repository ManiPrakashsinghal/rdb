package com.configuration;


import javax.servlet.Filter;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class RdbInitializer extends AbstractAnnotationConfigDispatcherServletInitializer{
	 @Override
	    protected Class<?>[] getRootConfigClasses() {
	        return new Class[] { RdbConfiguration.class };
	    }
	   
	    @Override
	    protected Class<?>[] getServletConfigClasses() {
	        return null;
	    }
	   
	    @Override
	    protected String[] getServletMappings() {
	    	System.out.println("running");
	        return new String[] { "/" };
	    }
	     
	   /* @Override
	    protected Filter[] getServletFilters() {
	        Filter [] singleton = { new CORSFilter() };
	        return singleton;
	    }*/
}
