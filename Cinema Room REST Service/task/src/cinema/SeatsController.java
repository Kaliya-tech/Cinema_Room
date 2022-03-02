package cinema;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class SeatsController {

    Theater theater = new Theater(9,9);

    @GetMapping("/seats")
    public Theater showSeats() {

        return theater;
    }
}