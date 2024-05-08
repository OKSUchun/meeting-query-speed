package com.sparta.meetingqueryspeed.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class SkillDto {
    private Integer skillId;
    private String skillName;

    @Builder
    public SkillDto(Integer skillId, String skillName) {
        this.skillId = skillId;
        this.skillName = skillName;
    }
}
