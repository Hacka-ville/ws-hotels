package ro.hackaville.wshotels.model.dto.body;

import lombok.*;
import ro.hackaville.wshotels.model.dao.Location;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HotelsRequest {

    @Builder.Default
    private Location location = Location.builder().build();

    @Builder.Default
    private HotelsFilter hotelsfilter = HotelsFilter.builder().build();

    private LocalDate startDate;

    private LocalDate endDate;

    @Builder.Default
    private Integer page = 0;
}
