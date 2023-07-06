import model.*;
import java.io.*;
import java.util.*;

/*In the program, booking data is stored on the booking file. FileWriter csvWriter writes orders to a file.
 BufferedReader csvReader reads data from a file. To enter information for booking from the console, use a scanner
  */
public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("New booking system,!");
//      initialise object theatre
        Theatre theatre = new Theatre();
        theatre.setRows(5);
        theatre.setSeats(10);
//      call a booking file name
        String bookingFileName = "booking.csv";
//      set the initial value of the movie and session ID
        int movieID = 1;
        int bookingID = 1;
//      initialise 2 movie objects and 2 movie sessions. Then we add the data from them to the booking file
        Movie movie1 = new Movie();
        movie1.setId(movieID++);
        movie1.setTitle("Avatar: The Way of Water");
        movie1.setDataRelease(new GregorianCalendar(2022, 12, 16));

        SessionMovie sessionAvatar1 = new SessionMovie(theatre.getRows(), theatre.getSeats());
        sessionAvatar1.setId(1);
        sessionAvatar1.setShowTime(new GregorianCalendar(2024, 10, 15, 11, 15));
        sessionAvatar1.addTicketsSale(theatre.getRows(), theatre.getSeats());

        SessionMovie sessionAvatar2 = new SessionMovie(theatre.getRows(), theatre.getSeats());
        sessionAvatar2.setId(2);
        sessionAvatar2.setShowTime(new GregorianCalendar(2024, 10, 15, 18, 15));
        sessionAvatar2.addTicketsSale(theatre.getRows(), theatre.getSeats());

        movie1.addSession(sessionAvatar1);
        movie1.addSession(sessionAvatar2);

        Movie movie2 = new Movie();
        movie2.setId(movieID++);
        movie2.setTitle("Top Gun: Maverick");
        movie2.setDataRelease(new GregorianCalendar(2022, 5, 27));

        SessionMovie sessionMaverick1 = new SessionMovie(theatre.getRows(), theatre.getSeats());
        sessionMaverick1.setId(1);
        sessionMaverick1.setShowTime(new GregorianCalendar(2024, 10, 15, 15, 15));
        sessionMaverick1.addTicketsSale(theatre.getRows(), theatre.getSeats());
        SessionMovie sessionMaverick2 = new SessionMovie(theatre.getRows(), theatre.getSeats());
        sessionMaverick2.setId(2);
        sessionMaverick2.setShowTime(new GregorianCalendar(2024, 10, 15, 21, 15));
        sessionMaverick2.addTicketsSale(theatre.getRows(), theatre.getSeats());
        movie2.addSession(sessionMaverick1);
        movie2.addSession(sessionMaverick2);

        theatre.addMovie(movie1);
        theatre.addMovie(movie2);

        Ticket ticket1 = sessionAvatar1.getTicket(1, 2);
        ticket1.setShowTime(sessionAvatar1.getShowTime());
        ticket1.setTitleMovie(movie1.getTitle());
        ticket1.setBought(true);
        Ticket ticket2 = sessionAvatar1.getTicket(1, 4);
        ticket2.setShowTime(sessionAvatar1.getShowTime());
        ticket2.setTitleMovie(movie1.getTitle());
        ticket2.setBought(true);

        Booking booking1 = new Booking();
        booking1.setId(bookingID++);
        booking1.setMovieId(movie1.getId());
        booking1.setCustomerName("Smith");
        booking1.setTicket(ticket1);

        Booking booking2 = new Booking();
        booking2.setId(bookingID++);
        booking2.setMovieId(movie1.getId());
        booking2.setCustomerName("Brown");
        booking2.setTicket(ticket2);

//      initialise list of rows. Fill rows with the data from booking1 and booking2. Then, we write the data inside the booking file
        List<List<String>> rows = Arrays.asList(
                Arrays.asList(booking1.getId() + "", booking1.getCustomerName(),
                        booking1.getDateTicket().getTime().toString(), booking1.getMovieId() + "",
                        booking1.getTicket().getRow()+"", booking1.getTicket().getSeat()+""),
                Arrays.asList(booking2.getId() + "", booking2.getCustomerName(),
                        booking2.getDateTicket().getTime().toString(), booking2.getMovieId() + "",
                        booking2.getTicket().getRow()+"", booking2.getTicket().getSeat()+"")

        );

//      initialise FileWriter, BufferedReader  and File csvFile
        FileWriter csvWriter = new FileWriter(bookingFileName);
        BufferedReader csvReader = new BufferedReader(new FileReader(bookingFileName));
        File csvFile = new File(bookingFileName);
//      check the existence of file. If the file exists, then BufferedReader csvReader reads it.If no,FileWriter write data from  List<List<String>> rows
        if (!csvFile.exists()) {
            String row;
            while ((row = csvReader.readLine()) != null) {
                System.out.println(row);
            }
            csvReader.close();
        } else {
            csvWriter = new FileWriter(bookingFileName);
            csvWriter.append("ID");
            csvWriter.append(",");
            csvWriter.append("customer name");
            csvWriter.append(",");
            csvWriter.append("date and time of the ticket");
            csvWriter.append(",");
            csvWriter.append("Movie ID");
            csvWriter.append(",");
            csvWriter.append("ROW");
            csvWriter.append(",");
            csvWriter.append("SEAT");
            csvWriter.append("\n");

            for (List<String> rowData : rows) {
                csvWriter.append(String.join(",", rowData));
                csvWriter.append("\n");
            }
            csvWriter.flush();
        }
//       to enter data from the console, initialise Scanner scanner
        Scanner scanner = new Scanner(System.in);
//        Show available movies and sessons
        System.out.println("Movies in the cinema:");
        for (Movie movie : theatre.getMovies()) {

            System.out.println("ID movie: " + movie.getId() + "   movie title: " + movie.getTitle());
            System.out.println("Available sessions: ");
            for (SessionMovie session : movie.getSessions()) {
                System.out.println(session.getShowTime().getTime());
            }
            System.out.println();
        }
//      offer an option to select a movie by entering its ID. If we enter it incorrectly, the loop starts again
        System.out.println("To select a movie, enter its ID. For exit enter 'exit' : ");
        while (scanner.hasNext()) {
            if  (scanner.hasNextInt()) {
                int movieId = scanner.nextInt();
//           find a movie from the array of movies by its id. If null, the loop starts again
                Movie movie = theatre.getMovies().stream().filter(film -> movieId == film.getId()).findAny().orElse(null);
                if (movie != null) {
                    System.out.println(" movie title: " + movie.getTitle());
//                  Show available sessions of the selected movie
                    System.out.println("Available sessions: ");
                    for (SessionMovie session : movie.getSessions()) {
                        System.out.println("Session ID: " + session.getId() + "   Show time: " + session.getShowTime().getTime().toString());
                    }
//           offer to select a movie session by entering it id. If we enter incorrectly, the loop starts again
                    System.out.println("Select a session, Enter ID:");
                    if (scanner.hasNextInt()) {
                        int sessionId = scanner.nextInt();
//          find a session from the array of sessions by its id. If null, the cycle starts again
                        SessionMovie session = movie.getSessions().stream().filter(ses -> sessionId == ses.getId()).findAny().orElse(null);
                        if (session != null) {
                            System.out.println("Session:" + session.getShowTime().getTime().toString());
//             show available seats
                            session.showAvailableSeats();
//            select row and seat. Check the selected row and seat. If the check fails, start the loop again.
                            System.out.println("Select row : ");
                            if (scanner.hasNextInt()) {
                                int row = scanner.nextInt();
                                if (1 <= row && row <= theatre.getRows()) {
                                    System.out.println("Select seat : ");
                                    if (scanner.hasNextInt()) {
                                        int seat = scanner.nextInt();
                                        if (1 <= seat && seat <= theatre.getSeats()) {
//          we find a ticket by its row and seat. Check, if a ticket has been bought or not
                                            Ticket ticket = session.getTicket(row, seat);
                                            if (!ticket.isBought()) {
//         after successful check, we suggest entering a name
                                                System.out.println("Your name : ");
                                                if (scanner.hasNext()) {
                                                    String customerName = scanner.next();
//          set fields for the ticket
                                                    ticket.setTitleMovie(movie.getTitle());
                                                    ticket.setShowTime(session.getShowTime());
                                                    ticket.setBought(true);
                                                    ticket.showTicket();
//          initialise Booking booking
                                                    Booking booking = new Booking();
                                                    booking.setId(bookingID++);
                                                    booking.setCustomerName(customerName);
                                                    booking.setMovieId(movie.getId());
                                                    booking.setTicket(ticket);
//          add a new booking to the booking file using csvWriter.
                                                    csvWriter.append(booking.getId() + "");
                                                    csvWriter.append(",");
                                                    csvWriter.append(booking.getCustomerName());
                                                    csvWriter.append(",");
                                                    csvWriter.append(booking.getDateTicket().getTime().toString());
                                                    csvWriter.append(",");
                                                    csvWriter.append(booking.getMovieId() +"");
                                                    csvWriter.append(",");
                                                    csvWriter.append(booking.getTicket().getRow() + "");
                                                    csvWriter.append(",");
                                                    csvWriter.append(booking.getTicket().getSeat() + "");
                                                    csvWriter.append("\n");
//                                               flush the stream. Start a new booking. For exit enter 'exit'
                                                    csvWriter.flush();
                                                    System.out.println("To select a movie, enter its ID. For exit enter 'exit'");
                                                    continue;                                              }

                                            }else {
                                                System.out.println("This ticket has already been purchased.Start again. Enter ID movie: ");
                                                continue;
                                            }

                                        }else {
                                            System.out.println("There is no such seat. Choose a movie. Enter ID movie:");
                                            continue;
                                        }

                                    }else {
                                        System.out.println("Wrong format. Choose a movie. Enter ID movie:");
                                        continue;
                                    }

                                }else {
                                    System.out.println("There is no such row. Start again. Enter ID movie:");
                                    continue;
                                }

                            }else {
                                System.out.println("Wrong format. Choose a movie. Enter ID movie:");
                                continue;
                            }

                        }else {
                            System.out.println("There is no such session. Start again. Enter ID movie:");
                            continue;
                        }

                    }else {
                        System.out.println("Wrong format. Choose a movie. Enter ID movie:");
                        continue;
                    }

                }else {
                    System.out.println("There is no such movie Start again. Enter ID movie:");
                    continue;
                }

            }else {
                String str = scanner.next();
                if (str.equalsIgnoreCase("exit")) break;
                else {
                    System.out.println("Wrong format. Choose a movie. Enter ID movie:");
                }
            }

            }
//        clos resources. Exit
            csvWriter.close();
            scanner.close();
            System.out.println("Bye!");
        }
}
