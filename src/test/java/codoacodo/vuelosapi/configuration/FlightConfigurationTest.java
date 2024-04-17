package codoacodo.vuelosapi.configuration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;

import codoacodo.vuelosapi.models.Dolar;

public class FlightConfigurationTest {
    
    @Test
    void fetchDolarTest() {

        FlightConfiguration mockedFlightConfiguration = mock(FlightConfiguration.class);

        Dolar dummyDolar = new Dolar();
        dummyDolar.setMoneda("USD");
        dummyDolar.setCasa("blue");
        dummyDolar.setNombre("Blue");
        dummyDolar.setCompra(985.0);
        dummyDolar.setVenta(1005.0);
        
        when(mockedFlightConfiguration.fetchDolar()).thenReturn(dummyDolar);

        Dolar dolar = mockedFlightConfiguration.fetchDolar();
        assertEquals(995, dolar.getAverage());
    }
}
