package codoacodo.vuelosapi.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import codoacodo.vuelosapi.models.Dolar;
import codoacodo.vuelosapi.models.Flight;
import codoacodo.vuelosapi.models.FlightDto;

@SpringBootTest
public class FlightUtilsTest {

    @Autowired
    FlightUtils flightUtils;

    @BeforeEach
    public void setUp() {
        List<Flight> flightList;
        List<FlightDto> flightDtoList;
    }

    @Test
    void flightMapperTest() {

        double dolarPrice = 1015;
        List<Flight> flightList = new ArrayList<>();
        List<FlightDto> flightDtoList = new ArrayList<>();
        
        Flight flight = new Flight();
        flight.setId(1L);
        flight.setOrigin("COR");
        flight.setDestiny("EZE");
        flight.setArrivalTime("SomeDate");
        flight.setDepartureTime("AnotherDate");
        flight.setPrice(150);
        flight.setFrequency("daily");
        flightList.add(flight);

        flightDtoList = flightUtils.flightMapper(flightList, dolarPrice);
        FlightDto flightDto = flightDtoList.get(0);
        assertEquals(1, flightDto.getId());
        assertEquals(flight.getPrice() * dolarPrice, flightDto.getConvertedPrice());
    }
}
