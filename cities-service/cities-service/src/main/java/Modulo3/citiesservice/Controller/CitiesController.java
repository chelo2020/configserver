package Modulo3.citiesservice.Controller;

import Modulo3.citiesservice.Dto.CityDto;
import Modulo3.citiesservice.Model.City;
import Modulo3.citiesservice.Service.ICityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cities")
public class CitiesController {

    @Autowired
    private ICityService repoCities;

    @GetMapping("/hotels")
    public ResponseEntity<CityDto>getCityAndHotels(@RequestParam String name,
                                                   @RequestParam String country){
        CityDto cityDto=repoCities.getCitiesHotels(name,country);
        return ResponseEntity.ok(cityDto);
    }


}
