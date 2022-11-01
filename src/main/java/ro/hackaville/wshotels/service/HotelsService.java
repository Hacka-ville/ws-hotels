package ro.hackaville.wshotels.service;

import ro.hackaville.wshotels.model.dto.HotelsDto;
import ro.hackaville.wshotels.model.dto.body.HotelsRequest;

import java.util.List;

public interface HotelsService {

    HotelsDto getHotelById(final String id);

    List<HotelsDto> getHotelsByFilter(final HotelsRequest request);
}
