package model;


import java.util.GregorianCalendar;

public class SessionMovie {
//    fields: id, objects GregorianCalendar showTime and Ticket [][] tickets
    int id;
    GregorianCalendar showTime;
    Ticket [][] tickets;
//    Constructor init Ticket [][] tickets. rows ahd seats define   size of two dimensional array
    public SessionMovie(int rows, int seats){
        this.tickets = new Ticket[rows][seats];
    }


    public void setShowTime(GregorianCalendar showTime) {
        this.showTime = showTime;
    }
// add tickets for sale. Fill two dimensional array tickets.
    public void addTicketsSale(int rows, int places) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < places; j++) {
//                Array start from 0, ticket row and seat from 1.
                this.tickets[i][j] = new Ticket(i +1, j+1);
            }
        }
    }
// show available seats. In loop check bolean field bought of the ticket. If false,show
    public void showAvailableSeats(){
        System.out.println("Available seats:");
            for (int i = 0; i < this.tickets.length; i++) {
                int row = i+1;
            System.out.println("ROW:" + row);
            System.out.print("SEAT: ");
            for (int j = 0; j < this.tickets[i].length; j++) {
                if (!this.tickets[i][j].isBought())
                    System.out.print(this.tickets[i][j].seat + "\t");
            }
            System.out.println();
        }
    }
//    Getter and Setter
    public GregorianCalendar getShowTime() {
        return showTime;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Ticket[][] getTickets() {
        return tickets;
    }

    public void setTickets(Ticket[][] tickets) {
        this.tickets = tickets;
    }
    public Ticket getTicket(int row, int seat){
        return this.tickets[row-1][seat-1];

    }


}
