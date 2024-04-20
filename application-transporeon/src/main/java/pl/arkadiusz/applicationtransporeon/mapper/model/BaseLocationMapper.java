package pl.arkadiusz.applicationtransporeon.mapper.model;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import pl.arkadiusz.applicationtransporeon.model.dto.BaseLocationDto;
import pl.arkadiusz.applicationtransporeon.model.entity.BaseLocation;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class BaseLocationMapper {

    public static BaseLocation map(final BaseLocationDto baseLocationDto) {
        return BaseLocation.builder()
                .id(baseLocationDto.getId())
                .cityName(baseLocationDto.getCityName())
                .countryName(baseLocationDto.getCountryName())
                .build();
    }

    public static BaseLocationDto map(final BaseLocation baseLocation) {
        return BaseLocationDto.builder()
                .id(baseLocation.getId())
                .cityName(baseLocation.getCityName())
                .countryName(baseLocation.getCountryName())
                .build();
    }
}
