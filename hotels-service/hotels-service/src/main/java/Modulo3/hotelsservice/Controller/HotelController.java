package Modulo3.hotelsservice.Controller;

import Modulo3.hotelsservice.Model.Hotel;
import Modulo3.hotelsservice.Service.IHotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/hotels")
public class HotelController {
    @Autowired
    private IHotelService repoHotel;

    @GetMapping("/{city_id}")
    public ResponseEntity<List<Hotel>>getHotelsByCityId(@PathVariable Long city_id){

        List<Hotel>list=repoHotel.getHotelsByCityId(city_id);
        if (list.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(list);

    }


}
