package model;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

public class Booking {
//    fields: id,  customer name, initilise object GregorianCalendar dateTicket, object ticket, moniie id
    int id;
    String customerName;
    GregorianCalendar dateTicket = new GregorianCalendar();
    Ticket ticket;
    int movieId;

//   Getter and Setter

    public int getId() {
        return id;
    }

    public String getCustomerName() {
        return customerName;
    }


    public int getMovieId() {
        return movieId;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }


    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public GregorianCalendar getDateTicket() {
        return dateTicket;
    }

    public void setDateTicket(GregorianCalendar dateTicket) {
        this.dateTicket = dateTicket;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

}