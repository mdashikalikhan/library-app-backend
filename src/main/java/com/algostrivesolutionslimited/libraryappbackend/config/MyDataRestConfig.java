package com.algostrivesolutionslimited.libraryappbackend.config;

import com.algostrivesolutionslimited.libraryappbackend.entity.BookEntity;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

public class MyDataRestConfig implements RepositoryRestConfigurer {

    private String theAllowedOrigins = "http://localhost:3000"

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config,
                                                     CorsRegistry cors) {

        HttpMethod[] unsupportedMethods = {
                HttpMethod.POST,
                HttpMethod.PUT,
                HttpMethod.PATCH,
                HttpMethod.DELETE
        };
        config.exposeIdsFor(BookEntity.class);


        disableHttpMethods(BookEntity.class, config, unsupportedMethods);


    }

    private void disableHttpMethods(Class<BookEntity> bookEntityClass,
                                    RepositoryRestConfiguration config,
                                    HttpMethod[] unsupportedMethods) {

        config.getExposureConfiguration()
                .forDomainType(bookEntityClass)
                .withItemExposure(((metdata, httpMethods) ->
                        httpMethods.disable(unsupportedMethods)))
                .withCollectionExposure(((metdata, httpMethods) ->
                        httpMethods.disable(unsupportedMethods)));

    }


}
