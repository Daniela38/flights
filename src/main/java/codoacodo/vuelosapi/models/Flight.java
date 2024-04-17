package codoacodo.vuelosapi.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

// Constructor con argumentos
@AllArgsConstructor

// Constructor sin argumentos
@NoArgsConstructor

// Getters y Setters
@Data
@Builder
@Entity
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String origin;
    private String destiny;
    private String departureTime;
    private String arrivalTime;
    private double price;
    private String frequency;
    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    public Flight(String origin, String destiny, String departureTime, String arrivalTime, double price, String frequency) {
        this.origin = origin;
        this.destiny = destiny;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.price = price;
        this.frequency = frequency;
     }
}
