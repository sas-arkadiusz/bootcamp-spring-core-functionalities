package pl.arkadiusz.applicationtransporeon.mapper.response;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import pl.arkadiusz.applicationtransporeon.model.dto.BaseLocationDto;
import pl.arkadiusz.applicationtransporeon.model.response.BaseLocationsListResponse;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class AllBaseLocationsResponseMapper {

    public static BaseLocationsListResponse map(final List<BaseLocationDto> baseLocationDtoList) {
        return BaseLocationsListResponse.builder()
                .baseLocations(baseLocationDtoList)
                .build();
    }
}
