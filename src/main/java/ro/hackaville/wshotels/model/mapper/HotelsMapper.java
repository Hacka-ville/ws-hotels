package ro.hackaville.wshotels.model.mapper;

import org.mapstruct.Mapper;
import ro.hackaville.wshotels.model.dto.HotelsDto;
import ro.hackaville.wshotels.model.entity.Hotel;

import java.util.List;

@Mapper
public interface HotelsMapper {

    HotelsDto toDto(final Hotel hotel);

    Hotel toEntity(final HotelsDto hotelsDto);

    List<Hotel> toEntityList(final List<HotelsDto> hotelsDtoList);
}
