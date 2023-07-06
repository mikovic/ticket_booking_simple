package model;

import java.util.GregorianCalendar;

public class Ticket {
//    fields: title movie, obgect GregorianCalendar showTime, row and seat, initialise  boolean bought
    String titleMovie;
    GregorianCalendar showTime;
    int row;
    int seat;
    boolean bought = false;
// Constructor set row and seat
    public Ticket(int row, int seat) {
        this.row = row;
        this.seat = seat;
    }
// Getter and Setter
    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getSeat() {
        return seat;
    }

    public void setPlace(int place) {
        this.seat = seat;
    }

    public boolean isBought() {
        return bought;
    }

    public void setBought(boolean bought) {
        this.bought = bought;
    }

    public String getTitleMovie() {
        return titleMovie;
    }

    public void setTitleMovie(String titleMovie) {
        this.titleMovie = titleMovie;
    }

    public GregorianCalendar getShowTime() {
        return showTime;
    }

    public void setShowTime(GregorianCalendar showTime) {
        this.showTime = showTime;
    }
//    show ticket
    public void showTicket() {
        System.out.println("Title movie: " + getTitleMovie() + " \n"+
        "Show time: " + getShowTime().getTime().toString() + " \n"+ "Row: " + getRow() + " \n"+ "Seat: " + getSeat());
    }


}
