package com.raya.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.HashSet;
import java.util.Set;

@Controller
public class HomeController {

    @Autowired
    ActorRepository actorRepository;


    @RequestMapping("/")
    public String index(Model model){
        //First lets create an actor
        Actor actor = new Actor();
        actor.setName("Sandra Bullock");
        actor.setRealname("Sandra Mae Bullowski");

        //Now lets create a movie
        Movie movie = new Movie();
        movie.setTitle("Emoji Movie");
        movie.setYear(2017);
        movie.setDescription("About Emojis..");

        //add the movies to empty list
        Set<Movie> movies = new HashSet<Movie>();
        movies.add(movie);

        //Add the list of movies to the actors movie list
        actor.setMovies(movies);

        //Save the actors to the database
        actorRepository.save(actor);

        //Grab all the actors from the database and send them to the template

        model.addAttribute("actors",actorRepository.findAll());
        return "index";
    }

}

