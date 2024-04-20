package pl.arkadiusz.applicationtransporeon.model.response;


import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import pl.arkadiusz.applicationtransporeon.model.dto.BaseLocationDto;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class
BaseLocationsListResponse {

    private final List<BaseLocationDto> baseLocations;
}
