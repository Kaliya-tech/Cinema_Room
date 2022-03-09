package cinema;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

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
                int price = 0;
                if (row <= 4) {
                    price = 10;
                } else {
                    price = 8;
                }
                for (int column = 1; column <= totalColumns; column++) {
                    seats.add(new Seat(row, column, price));
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

        @PostMapping("/purchase")
        private Map<String, Object> bookSeat(@RequestParam int row, @RequestParam int column,
                                            @RequestParam int price) {

            return (Map<String, Object>) cinemaRoom.get(row);
            //return seats.get(row);

         //   return "\"error\": \"The ticket has been already purchased!\"";
        }
    }
