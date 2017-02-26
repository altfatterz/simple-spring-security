package org.example;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * @author Zoltan Altfatter
 */
public class CustomWebApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        // null meaning that registration of a root context is not desired
        return null;
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{WebMvcConfiguration.class};
    }

    @Override
    protected String[] getServletMappings() {
        // the servlet mapping(s) for the DispatcherServlet
        return new String[]{"/"};
    }

}
