package Modulo3.hotelsservice.Service;

import Modulo3.hotelsservice.Model.Hotel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HotelService implements IHotelService {

    List<Hotel>hotelsList=new ArrayList<>();
    @Override
    public List<Hotel> getHotelsByCityId(Long city_id) {

        //Carga de la lista logica
        this.loadHotels();
        for (Hotel h:hotelsList){
            if (h.getCity_id()==city_id){
                hotelsList.add(h);
            }
        }

        return hotelsList;
    }
    public void loadHotels(){
        hotelsList.add(new Hotel(1L,"Paredise",5,1l));
        hotelsList.add(new Hotel(2L,"Paredise",4,2l));
        hotelsList.add(new Hotel(3L,"Paredise",3,3l));
        hotelsList.add(new Hotel(4L,"Paredise",2,1l));
        hotelsList.add(new Hotel(5L,"Paredise",3,2l));
        hotelsList.add(new Hotel(6L,"Paredise",4,3l));
        hotelsList.add(new Hotel(7L,"Paredise",3,1l));
        hotelsList.add(new Hotel(8L,"Paredise",4,2l));
        hotelsList.add(new Hotel(9L,"Paredise",4,3l));
        hotelsList.add(new Hotel(10L,"Paredise",2,5l));


    }
}
