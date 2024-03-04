package Modulo3.citiesservice.Repository;

import Modulo3.citiesservice.Dto.HotelsDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient("hotel-service")
public interface IHotelsRepository {

    @GetMapping("/hotels/{city_id}")
    public List<HotelsDto>getHotelsByCityId(@PathVariable("city_id") Long city_id);
}
