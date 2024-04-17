package codoacodo.vuelosapi.controller;

import org.springframework.web.bind.annotation.RestController;

import codoacodo.vuelosapi.models.Dolar;
import codoacodo.vuelosapi.models.Flight;
import codoacodo.vuelosapi.models.FlightDto;
import codoacodo.vuelosapi.services.FlightService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

import javax.swing.text.html.Option;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/flights")

public class FlightController {

    @Autowired
    FlightService flightService;

     @GetMapping("")
    public List<FlightDto> getAllFlights(){
        return flightService.findAll();
    }

    @PostMapping("/add")
    public void createFlight(@RequestBody Flight flight){
        flightService.createFlight(flight);
    }

    @GetMapping("/{id}")
    public Optional<Flight> findFlightById(@PathVariable Long id){
        return flightService.getFlightById(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteFlight(@PathVariable Long id){
        flightService.deleteFlightById(id);
    }

    @PutMapping("/update")
    public Optional<Flight> updateFlight(@RequestBody Flight flight){
        return flightService.updateFlight(flight);
    }

    @GetMapping("/origin") 
    public List<Flight> getFlightsByOrigin(@RequestParam String origin) {
        return flightService.getByOrigin(origin);
    }
    
    @GetMapping("/origin-destiny") 
    public List<Flight> getFlightsByOriginAndDestiny(@RequestParam String origin, String destiny) {
        return flightService.getByOriginDestiny(origin, destiny);
    }

    @GetMapping("/offers")
    public List<Flight> getOffers() {
        return flightService.getOffers(200);
    }

    @GetMapping("/all-dolars")
    public List<Dolar> getAllDolars() {
        return flightService.getAllDolars();
    }
}
