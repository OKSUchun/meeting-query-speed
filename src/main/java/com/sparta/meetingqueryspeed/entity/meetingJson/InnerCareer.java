package com.sparta.meetingqueryspeed.entity.meetingJson;

import lombok.Builder;
import lombok.Getter;


@Getter
public class InnerCareer {
    private final Long careerId;
    private final String careerName;

    @Builder
    public InnerCareer(Long careerId, String careerName) {
        this.careerId = careerId;
        this.careerName = careerName;
    }

}

