package com.practice.movie_restapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MovieController {

    @Autowired
    private List<Movie> movieList;

    @PostMapping("/movie")
    public void createMovie(@RequestBody Movie movie)
    {
        this.movieList.add(movie);
    }

    @GetMapping("/movie")
    Movie getMovie(@RequestParam("name") String name)
    {
        for(Movie movie: movieList)
        {
            if(movie.getName().equals(name))
            {
                return movie;
            }
        }
        return null;
    }

    @PatchMapping("/movie/{name}")
    String updateRatings (@PathVariable("name") String name, @RequestBody Movie movie )
    {
        for(Movie movieIT : movieList)
        {
            if(movieIT.getName().equals(name))
            {
                movieIT.setRatings(movie.getRatings());
                return "Ratings updated";
            }
        }
        return "No movie found";
    }

    //replace with correct
    @PutMapping("/movie")
    String putMapping(@RequestParam("name") String name, @RequestBody Movie movie)
    {
        for(Movie movie1:movieList)
        {
            if(movie1.getName().equals(name))
            {
                movieList.remove(movie1);
                movieList.add(movie);
                return "updated";
            }
        }
        return " not found movie";
    }

    @DeleteMapping("/movie")
    void del(@RequestParam("name") String name)
    {
        for (Movie movie : movieList)
        {
            if(movie.getName().equals(name))
            {
                movieList.remove(movie);
            }
        }
    }
}
