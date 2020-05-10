package wooteco.subway.admin.dto;


import wooteco.subway.admin.domain.Station;

import javax.validation.constraints.NotBlank;

public class StationCreateRequest {
    @NotBlank
    private String name;

    public StationCreateRequest() {
    }

    public StationCreateRequest(String name) {
        this.name = name;
    }

    public Station toStation() {
        return new Station(name);
    }

    public String getName() {
        return name;
    }
}
