package com.upgrad.mtb.services;

import com.upgrad.mtb.beans.Movie;
import com.upgrad.mtb.exceptions.LanguageDetailsNotFoundException;
import com.upgrad.mtb.exceptions.MovieDetailsNotFoundException;
import com.upgrad.mtb.exceptions.StatusDetailsNotFoundException;

import java.util.List;

public interface MovieService {
     Movie acceptMovieDetails(Movie movie,String languageName,int status)throws StatusDetailsNotFoundException,LanguageDetailsNotFoundException;
     Movie getMovieDetails(int id) throws MovieDetailsNotFoundException;
     boolean removeMovie(int id)  throws MovieDetailsNotFoundException ;
     List<Movie> getAllMoviesDetails();
     List<Movie> searchMovieDetailsByReleaseDate(String releaseDate);
     Movie searchMovieDetailsByName  (String name);
     Movie movieTheatreDetails(String name);
     List<Movie> getAllMoviesDetailsByLanguage(String language) throws LanguageDetailsNotFoundException;
}
