package com.dz3_2.mvc.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;


public class LikeWebXmlDispatcherServletInit extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return null;
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{MySpringConf.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/dz3_2/*"};
    }
}
