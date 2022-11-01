package ro.hackaville.wshotels.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import ro.hackaville.wshotels.model.dao.HotelInformations;
import ro.hackaville.wshotels.model.dao.Location;
import ro.hackaville.wshotels.model.dao.RoomType;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "hotels")
public class Hotel {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", unique = true)
    private String id;

    private String name;

    @Embedded
    private HotelInformations hotelInformations;

    @Embedded
    private Location location;

    @OneToMany(cascade=CascadeType.ALL)
    @JoinTable(
            name = "hotel_rooms",
            joinColumns = {@JoinColumn(name = "room_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "hotel_id", referencedColumnName = "id")})
    private List<Room> rooms = new ArrayList<>();
}
