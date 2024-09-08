package com.example.uploadfile.configuration;

import jakarta.servlet.MultipartConfigElement;
import jakarta.servlet.ServletRegistration;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class AppInit extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Value("${file-upload}")
    private String TMP_FOLDER;
    private static final int MAX_UPLOAD_SIZE = 6 * 1024 * 1024;

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{AppConfiguration.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    // Upload file
    @Override
    protected void customizeRegistration(ServletRegistration.Dynamic registration) {
        registration.setMultipartConfig(
                new MultipartConfigElement(
                        TMP_FOLDER,
                        MAX_UPLOAD_SIZE,
                        MAX_UPLOAD_SIZE * 2L,
                        MAX_UPLOAD_SIZE / 2
                )
        );
    }
}
