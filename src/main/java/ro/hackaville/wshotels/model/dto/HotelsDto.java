package ro.hackaville.wshotels.model.dto;

import lombok.*;
import ro.hackaville.wshotels.model.dao.HotelInformations;
import ro.hackaville.wshotels.model.dao.Location;

import java.math.BigDecimal;
import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class HotelsDto {

    private String id;

    private Integer number;

    private HotelInformations hotelInformations;

    private BigDecimal price;

    private Location location;

    private LocalTime delay;
}
