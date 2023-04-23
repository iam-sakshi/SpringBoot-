package com.practice.movie_restapi;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class Config {
    @Bean
    List<Movie> movieList()
    {
        return new ArrayList<>();
    }
}
