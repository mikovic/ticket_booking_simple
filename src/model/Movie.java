package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;

public class Movie {
//    fields: id, movie title, object GregorianCalendar dataRelease, initilise ArrayList session where we store movie session objects
    int id;
    String title;
    GregorianCalendar dataRelease;
    ArrayList<SessionMovie> sessions = new ArrayList<>();
// Getter and Setter
    public void addSession(SessionMovie session){
        this.sessions.add(session);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public GregorianCalendar getDataRelease() {
        return dataRelease;
    }

    public void setDataRelease(GregorianCalendar dataRelease) {
        this.dataRelease = dataRelease;
    }

    public ArrayList<SessionMovie> getSessions() {
        return sessions;
    }

    public void setSessions(ArrayList<SessionMovie> sessions) {
        this.sessions = sessions;
    }

}
