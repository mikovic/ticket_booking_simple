package model;

import java.util.ArrayList;

public class Theatre {
//    fields: number of rows in the theatre and number of seats in a row
    int rows;
    int seats;
//    initialise an ArrayList. In it we store movie objects
    ArrayList<Movie> movies = new ArrayList<>();
//    Getter and Setter.

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public ArrayList<Movie> getMovies() {
        return movies;
    }

    public void setMovies(ArrayList<Movie> movies) {
        this.movies = movies;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }
// add movie into an ArrayList<Movie> movies
    public void addMovie(Movie movie){
        this.movies.add(movie);
    }

}
