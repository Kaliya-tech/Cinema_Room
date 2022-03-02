package cinema;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;


@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}

    @RestController
    class SeatsController {

        Map<String, Object> cinemaRoom = new TreeMap<>();
        List<Seat> seats = new LinkedList<>();

        private static final int totalRows = 9;
        private static final int totalColumns = 9;

        public SeatsController() {
            for (int row = 1; row <= totalRows; row++) {
                for (int column = 1; column <= totalColumns; column++) {
                    seats.add(new Seat(row, column));
                }
            }
            cinemaRoom.put("total_rows", totalRows);
            cinemaRoom.put("total_columns", totalColumns);
            cinemaRoom.put("available_seats", seats);
        }

        @GetMapping("/seats")
        private Map<String, Object> showSeats() {
            return cinemaRoom;
        }
    }