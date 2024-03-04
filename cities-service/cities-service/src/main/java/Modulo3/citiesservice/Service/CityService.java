package Modulo3.citiesservice.Service;

import Modulo3.citiesservice.Dto.CityDto;
import Modulo3.citiesservice.Model.City;
import Modulo3.citiesservice.Repository.IHotelsRepository;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CityService implements ICityService{

    @Autowired
    private IHotelsRepository repoHotels;

    List<City>cities=new ArrayList<>();

    @Override
    @CircuitBreaker(name = "hotels-service",fallbackMethod = "fallbackGetCitiesHotel")
    @Retry(name = "hotels-service")
    public CityDto getCitiesHotels(String name, String country) {

        City city=this.findcity(name,country);

        CityDto cityDto=new CityDto();
        cityDto.setCity_id(city.getCity_id());
        cityDto.setName(city.getName());
        cityDto.setCountry(city.getCountry());
        cityDto.setContinent((city.getContinent()));
        cityDto.setState(city.getState());

        cityDto.setListHotels(repoHotels.getHotelsByCityId(city.getCity_id()));

        createException();

        return cityDto;
    }
    /*método que va a esquivar todo*/
    //Esto podemos manipular como queramos
    public CityDto fallbackGetCitiesHotel (Throwable throwable) {

        return new CityDto(9999999L, "Fallido", "Fallido", "Fallido", "Fallido", null);

    }

    //método para provocar una excepción a ver qué pasa
    public void createException () {

        throw new IllegalArgumentException("Prueba Resilience y Circuit Breaker");

    }



    public City findcity(String name, String country){
        this.loadCities();
        for (City c:cities){
            if (c.getName().equals(name)){
                if ((c.getCountry().equals(country))){
                    return c;
                }
            }
        }
        return null;
    }
    public void loadCities () {

        cities.add(new City(1L, "Buenos Aires", "South America", "Argentina", "Buenos Aires"));
        cities.add(new City(2L, "Oberá", "South America", "Argentina", "Misiones"));
        cities.add(new City(3L, "Mexico City", "North America", "Mexico", "Mexico City"));
        cities.add(new City(4L, "Guadalajara", "North America", "Mexico", "Jalisco"));
        cities.add(new City(5L, "Bogotá", "South America", "Colombia", "Cundinamarca"));
        cities.add(new City(6L, "Medellín", "South America", "Colombia", "Antioquia"));
        cities.add(new City(7L, "Santiago", "South America", "Chile", "Santiago Metropolitan"));
        cities.add(new City(8L, "Valparaíso", "South America", "Chile", "Valparaíso"));
        cities.add(new City(9L, "Asunción", "South America", "Paraguay", "Asunción"));
        cities.add(new City(10L, "Montevideo", "South America", "Uruguay", "Montevideo"));
        cities.add(new City(11L, "Madrid", "Europe", "Spain", "Community of Madrid"));
        cities.add(new City(12L, "Barcelona", "Europe", "Spain", "Catalonia"));
        cities.add(new City(13L, "Seville", "Europe", "Spain", "Andalucia"));
        cities.add(new City(14L, "Monterrey", "North America", "Mexico", "Nuevo León"));
        cities.add(new City(15L, "Valencia", "Europe", "Spain", "Valencian Community"));

    }
}
