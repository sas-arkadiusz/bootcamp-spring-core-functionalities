package pl.arkadiusz.applicationtransporeon.model.dto;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@Builder
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class BaseLocationDto {

    private final Long id;
    private final String cityName;
    private final String countryName;
}
