package Modulo3.hotelsservice.Service;

import Modulo3.hotelsservice.Model.Hotel;

import java.util.List;

public interface IHotelService {

    public List<Hotel>getHotelsByCityId(Long city_id);

}
