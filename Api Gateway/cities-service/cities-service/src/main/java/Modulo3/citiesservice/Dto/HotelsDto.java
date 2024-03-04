package Modulo3.citiesservice.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class HotelsDto {

    private Long id;
    private String name;
    private int stars;
    private Long city_id;

}
