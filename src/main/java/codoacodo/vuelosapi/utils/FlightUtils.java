package codoacodo.vuelosapi.utils;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import codoacodo.vuelosapi.models.Flight;
import codoacodo.vuelosapi.models.FlightDto;

@Component
public class FlightUtils {

    public List<Flight> detectOffers(List<Flight> flights, double offerPrice) {
        // programación imperativa
        /*List<Flight> offers = new ArrayList<>();
        for(Flight flight: flights) {
            if (flight.getPrecio_en_pesos() <= offerPrice) {
                offers.add(flight);
            }
        }
        return offers;*/
        // programación funcional
        return flights.stream()
                    .filter(flight -> flight.getPrice() <= offerPrice)
                    .collect(Collectors.toList()); 
    }

    public List<FlightDto> flightMapper(List<Flight> flights, double dolarPrice) {
        List<FlightDto> flightDtos = new ArrayList<>();
        for(Flight flight : flights) {
            flightDtos.add(new FlightDto(flight.getId(), flight.getOrigin(), flight.getDestiny(), flight.getDepartureTime(), flight.getArrivalTime(), flight.getFrequency(), flight.getPrice() * dolarPrice));
        }
        return flightDtos;
    }

    /*public FlightDto flightMapper(Flight flight, double price) {
        return new FlightDto(flight.getId(), flight.getOrigin(), flight.getDestiny(), flight.getDepartureTime(), flight.getArrivalTime(), flight.getFrequency(), flight.getPrice() * price);
    }*/
}
