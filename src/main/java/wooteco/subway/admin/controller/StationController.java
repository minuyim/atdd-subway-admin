package wooteco.subway.admin.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import wooteco.subway.admin.dto.StationCreateRequest;
import wooteco.subway.admin.dto.StationResponse;
import wooteco.subway.admin.service.StationService;

import java.net.URI;

@RestController
@RequestMapping("/stations")
public class StationController {
    private StationService stationService;

    public StationController(StationService stationService) {
        this.stationService = stationService;
    }

    @PostMapping
    public ResponseEntity createStation(@RequestBody StationCreateRequest view) {
        StationResponse savedStation = stationService.addStation(view);
        return ResponseEntity
                .created(URI.create("/stations/" + savedStation.getId()))
                .body(savedStation);
    }

    @GetMapping
    public ResponseEntity showStations() {
        return ResponseEntity.ok().body(stationService.findAll());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteStation(@PathVariable Long id) {
        stationService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
