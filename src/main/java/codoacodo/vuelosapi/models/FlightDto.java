package codoacodo.vuelosapi.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FlightDto {
    private Long id;
    private String origin;
    private String destiny;
    private String departureDate;
    private String arrivalDate;
    private String frequency;
    private double convertedPrice;
}
