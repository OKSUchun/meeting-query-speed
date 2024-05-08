package com.sparta.meetingqueryspeed.entity.meetingJson;

import lombok.Builder;
import lombok.Getter;

@Getter
public class InnerSkill {
    private Long skillId;
    private String skillName;

    @Builder
    public InnerSkill(Long skillId, String skillName) {
        this.skillId = skillId;
        this.skillName = skillName;
    }
}
