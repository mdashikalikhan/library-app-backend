package com.algostrivesolutionslimited.libraryappbackend.config;

import com.algostrivesolutionslimited.libraryappbackend.entity.BookEntity;
import com.algostrivesolutionslimited.libraryappbackend.entity.ReviewEntity;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@Configuration
public class MyDataRestConfig implements RepositoryRestConfigurer {

    private String theAllowedOrigins = "http://localhost:3000";

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config,
                                                     CorsRegistry cors) {

        HttpMethod[] unsupportedMethods = {
                HttpMethod.POST,
                HttpMethod.PUT,
                HttpMethod.PATCH,
                HttpMethod.DELETE
        };
        config.exposeIdsFor(BookEntity.class, ReviewEntity.class);


        disableHttpMethods(BookEntity.class, config, unsupportedMethods);

        disableHttpMethods(ReviewEntity.class, config, unsupportedMethods);

        /**
         * Configure CORS origin
         */

        cors.addMapping(config.getBasePath() + "/**")
                .allowedOrigins(theAllowedOrigins);


    }

    private void disableHttpMethods(Class entityClass,
                                    RepositoryRestConfiguration config,
                                    HttpMethod[] unsupportedMethods) {

        config.getExposureConfiguration()
                .forDomainType(entityClass)
                .withItemExposure(((metdata, httpMethods) ->
                        httpMethods.disable(unsupportedMethods)))
                .withCollectionExposure(((metdata, httpMethods) ->
                        httpMethods.disable(unsupportedMethods)));

    }


}
