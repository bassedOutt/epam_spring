package com.epam.spring.homework3;

import com.epam.spring.homework3.dto.UserDto;
import com.epam.spring.homework3.model.Movie;
import com.epam.spring.homework3.model.User;

public class Util {

    public static UserDto getUser(){
        return null;
    }

    public static Movie createMovie(){
        Movie movie = new Movie();
        movie.setDuration(156);
        movie.setEnDescription("The lives of two mob hitmen, a boxer, a gangster and his wife, and a pair of diner bandits intertwine in four tales of violence and redemption.");
        movie.setEnTitle("Pulp Fiction");
        movie.setImageUrl("https://upload.wikimedia.org/wikipedia/uk/0/06/Pulp_Fiction_%28Soundtrack%29.png");
        movie.setPrice(135);
        movie.setUaDescription("Життя двох вбивць, боксера, гангстера та його дружини, а також пари бандитів із закусочної переплітаються в чотирьох казках про насильство та спокуту.");
        movie.setUaTitle("Життя двох вбивць, боксера, гангстера та його дружини, а також пари бандитів із закусочної переплітаються в чотирьох казках про насильство та спокуту.");
        return movie;
    }

}
