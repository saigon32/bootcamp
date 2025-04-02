package com.onclass.api.helper;

import com.onclass.api.helper.request.BootcampHandlerImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.*;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class RouterRest {

    @Bean()
    @AddRouterRestInfo
    public RouterFunction<ServerResponse> routerFunction(BootcampHandlerImpl handler) {
        return route(POST("/bootcamp"), handler::createBootcamp);
    }

}
