package com.sparta.meetingqueryspeed.dto;

import lombok.Builder;
import lombok.Getter;


@Getter
public class CareerDto {
    private final Integer careerId;
    private final String careerName;

    @Builder
    public CareerDto(Integer careerId, String careerName) {
        this.careerId = careerId;
        this.careerName = careerName;
    }

}

