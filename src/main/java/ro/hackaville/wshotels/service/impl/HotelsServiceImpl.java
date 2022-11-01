package ro.hackaville.wshotels.service.impl;


import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ro.hackaville.wshotels.exceptions.HotelNotFoundException;
import ro.hackaville.wshotels.exceptions.NoDataFoundException;
import ro.hackaville.wshotels.model.dto.HotelsDto;
import ro.hackaville.wshotels.model.dto.body.HotelsRequest;
import ro.hackaville.wshotels.model.entity.Hotel;
import ro.hackaville.wshotels.model.mapper.HotelsMapper;
import ro.hackaville.wshotels.repository.HotelRepository;
import ro.hackaville.wshotels.service.HotelsService;

import java.util.List;

@RequiredArgsConstructor
@Service
public class HotelsServiceImpl implements HotelsService {

    private final HotelRepository hotelRepository;
    private final HotelsMapper hotelsMapper;

    public Hotel handleHotel(final String id) {
        return hotelRepository.getHotelById(id)
                .orElseThrow(() -> new HotelNotFoundException(id));

    }

    @Override
    public HotelsDto getHotelById(final String id) {
        return hotelsMapper.toDto(handleHotel(id));
    }

    @Override
    public List<HotelsDto> getHotelsByFilter(HotelsRequest request) {
        final List<HotelsDto> hotelsList;

        final Pageable pageable = PageRequest.of(request.getPage(), 10);

        if ("ASC".equals(request.getHotelsfilter().getOrderType())) {
            hotelsList = hotelRepository.getFlightsByFiltersOrderbyAsc(request.getStartDate(),
                            request.getEndDate(), request.getLocation().getFlightLocation(), request.getLocation().getArriveLocation(),
                            request.getHotelsfilter().getFlightOperator(),
                            request.getHotelsfilter().getMinPrice(),
                            request.getHotelsfilter().getMaxPrice(),
                            request.getHotelsfilter().getFlightHourStart(),
                            request.getHotelsfilter().getFlightHourEnd(),
                            request.getHotelsfilter().getArriveHourStart(),
                            request.getHotelsfilter().getArriveHourEnd(),
                            request.getHotelsfilter().getOrderBy(),
                            pageable)
                    .stream()
                    .map(hotelsMapper::toDto)
                    .toList();

        } else if ("DESC".equals(request.getHotelsfilter().getOrderType())) {
            hotelsList = hotelRepository.getFlightsByFiltersOrderbyDesc(request.getStartDate(),
                            request.getEndDate(), request.getLocation().getFlightLocation(), request.getLocation().getArriveLocation(),
                            request.getHotelsfilter().getFlightOperator(),
                            request.getHotelsfilter().getMinPrice(),
                            request.getHotelsfilter().getMaxPrice(),
                            request.getHotelsfilter().getFlightHourStart(),
                            request.getHotelsfilter().getFlightHourEnd(),
                            request.getHotelsfilter().getArriveHourStart(),
                            request.getHotelsfilter().getArriveHourEnd(),
                            request.getHotelsfilter().getOrderBy(),
                            pageable)
                    .stream()
                    .map(hotelsMapper::toDto)
                    .toList();

        } else {
            hotelsList = hotelRepository.getFlightsByFilters(request.getStartDate(),
                            request.getEndDate(), request.getLocation().getFlightLocation(), request.getLocation().getArriveLocation(),
                            request.getHotelsfilter().getFlightOperator(),
                            request.getHotelsfilter().getMinPrice(),
                            request.getHotelsfilter().getMaxPrice(),
                            request.getHotelsfilter().getFlightHourStart(),
                            request.getHotelsfilter().getFlightHourEnd(),
                            request.getHotelsfilter().getArriveHourStart(),
                            request.getHotelsfilter().getArriveHourEnd(),
                            pageable)
                    .stream()
                    .map(hotelsMapper::toDto)
                    .toList();
        }

        if (hotelsList.isEmpty()) {
            throw new NoDataFoundException();
        }

        return hotelsList;
    }


}
