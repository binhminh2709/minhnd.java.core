package bean;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;

import beans.property.Actor;
import beans.property.Movie;
import beans.property.Person;

public class BeanUtilsExampleV1 {
  
  public static void main(String args[]) throws Exception {
    BeanUtilsExampleV1 diff = new BeanUtilsExampleV1();
    Movie movieBean = diff.prepareData();
    
    System.err.println("Movie Title: " + BeanUtils.getProperty(movieBean, "title"));
    System.err.println("Movie Year: " + BeanUtils.getProperty(movieBean, "dateOfRelease"));
    System.err.println("Movie Director: " + BeanUtils.getProperty(movieBean, "director.name"));
    System.err.println("Movie Director Home Contact: " + BeanUtils.getProperty(movieBean, "director.contactNumber(Home)"));
    System.err.println("Movie Genre (Thriller): " + BeanUtils.getProperty(movieBean, "genre(THR)"));
    System.err.println("Movie Actor 1 name: " + BeanUtils.getProperty(movieBean, "actors[0].name"));
    System.err.println("Movie Actor 1 worth: " + BeanUtils.getProperty(movieBean, "actors[0].worth"));
    System.err.println("Movie Actor 1 other movie 1: " + BeanUtils.getProperty(movieBean, "actors[0].movieCredits[0].title"));
    
  }
  
  private Movie prepareData() {
    Movie movie = new Movie();
    movie.setTitle("The Italian Job");
    movie.setDateOfRelease(new GregorianCalendar(1969, 0, 1).getTime());
    
    // sets the genre
    Map genre_map = new HashMap();
    genre_map.put("THR", "Thriller");
    genre_map.put("ACT", "Action");
    
    movie.setGenre(genre_map);
    
    // creates the Director
    Person director = new Person();
    director.setName("Peter Collinson");
    director.setGender(1);
    Map director_contacts = new HashMap();
    director_contacts.put("Home", "99922233");
    director_contacts.put("Mobile", "0343343433");
    director.setContactNumber(director_contacts);
    
    movie.setDirector(director);
    
    // create the actors
    Actor actor1 = new Actor();
    actor1.setName("Michael Caine");
    actor1.setGender(1);
    actor1.setWorth(10000000);
    List actor1_movies = new ArrayList();
    
    Movie movie2 = new Movie();
    movie2.setTitle("The Fourth Protocol");
    
    Movie movie3 = new Movie();
    movie3.setTitle("Shiner");
    
    actor1_movies.add(movie2);
    actor1_movies.add(movie3);
    
    actor1.setMovieCredits(actor1_movies);
    
    Actor actor2 = new Actor();
    actor2.setName("Margaret Blye");
    actor2.setGender(2);
    actor2.setWorth(20000000);
    
    List actors = new ArrayList();
    actors.add(actor1);
    actors.add(actor2);
    
    movie.setActors(actors);
    
    return movie;
  }
}
