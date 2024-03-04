package Modulo3.citiesservice.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor

public class CityDto {

    private Long city_id;
    private String name;
    private String country;
    private String continent;
    private String state;
    private List<HotelsDto>listHotels;

}
