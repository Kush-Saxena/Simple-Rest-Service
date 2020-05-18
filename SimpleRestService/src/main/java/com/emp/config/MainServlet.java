package com.emp.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class MainServlet implements WebApplicationInitializer {

	public void onStartup(ServletContext servletContext) throws ServletException {

		// Ready the web Context to load the spring app first
		AnnotationConfigWebApplicationContext webContext = new AnnotationConfigWebApplicationContext();
		webContext.register(AppConfiguration.class);

		// Make a dispatcherServlet to handle requests by the Spring mvc
		DispatcherServlet ds = new DispatcherServlet(webContext);

		// Register the ds in main servlet container.
		ServletRegistration.Dynamic myServlet = servletContext.addServlet("mainServlet", ds);

		// Adding mappings for the servlet
		// Setting root location as mapping
		myServlet.addMapping("/api/*");

		// enabling servlet loading of server startup 1 for pre loading 0 for lazy
		// loading.
		myServlet.setLoadOnStartup(1);

	}

}
