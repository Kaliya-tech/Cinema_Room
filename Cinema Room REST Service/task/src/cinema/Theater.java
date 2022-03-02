package cinema;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Theater {

    @JsonProperty("total_rows")
    private final int totalRows;
    @JsonProperty("total_columns")
    private final int totalColumns;
    @JsonProperty("all_seats")
    private final List<Theater> allSeats;

    public Theater(int rows, int columns) {
        this.totalRows = rows;
        this.totalColumns = columns;
        this.allSeats = availableSeats();
    }

    private List<Theater> availableSeats() {
        List<Theater> seats = new ArrayList<>();
        for (int row = 1; row <= totalRows; row++) {
            for (int column = 1; column <= totalColumns; column++) {
                seats.add(new Theater(row, column));
            }
        }
        return Collections.unmodifiableList(seats);
    }

    public int getTotalRows() {
        return totalRows;
    }

    public int getTotalColumns() {
        return totalColumns;
    }
}