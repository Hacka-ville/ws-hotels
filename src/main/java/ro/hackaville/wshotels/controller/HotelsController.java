package ro.hackaville.wshotels.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ro.hackaville.wshotels.model.dto.HotelsDto;
import ro.hackaville.wshotels.model.dto.body.HotelsRequest;
import ro.hackaville.wshotels.service.HotelsService;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/api/hotels")
@RestController
public class HotelsController {

    private final HotelsService hotelsService;

    @GetMapping("/{id}")
    public HotelsDto getHotelsById(@PathVariable final String id) {
        return hotelsService.getHotelById(id);
    }

    @PostMapping
    public List<HotelsDto> getHotelsByFilters(@RequestBody final HotelsRequest request) {
        return hotelsService.getHotelsByFilter(request);
    }
}
