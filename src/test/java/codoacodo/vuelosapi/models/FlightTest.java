package codoacodo.vuelosapi.models;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class FlightTest {
    
    private static Flight flight;

    @Test
    public void setAndGetOriginTest(){
        String testedOrigin = "EZE";
        flight.setOrigin(testedOrigin);
        System.out.println("Se le asigna el origen: " + testedOrigin);
        Assertions.assertEquals(flight.getOrigin(), testedOrigin);
    }

    @Test
    public void setAndGetDestinityTest(){
        String testedDestinity = "COR";
        flight.setDestiny(testedDestinity);
        Assertions.assertEquals(flight.getDestiny(), testedDestinity);
    }

    @BeforeAll
    public static void setUp() {
        System.out.println("Se está creando el vuelo");
        flight = new Flight();
    }
}