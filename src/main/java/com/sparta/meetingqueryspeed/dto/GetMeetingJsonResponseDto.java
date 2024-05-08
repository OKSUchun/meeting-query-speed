package com.sparta.meetingqueryspeed.dto;

import com.sparta.meetingqueryspeed.entity.meetingJson.InnerCareer;
import com.sparta.meetingqueryspeed.entity.meetingJson.MeetingJson;
import com.sparta.meetingqueryspeed.entity.meetingJson.InnerSkill;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class GetMeetingJsonResponseDto {
    private Long meetingId;
    private String meetingName;

    private List<InnerSkill> skillList;
    private List<InnerCareer> careerList;
    @Builder
    GetMeetingJsonResponseDto(Long meetingId, String meetingName, List<InnerSkill> skillList, List<InnerCareer> careerList){
        this.meetingId = meetingId;
        this.meetingName = meetingName;
        this.skillList = skillList;
        this.careerList = careerList;
    }
    public static GetMeetingJsonResponseDto fromEntity(MeetingJson meetingJson) {
        return GetMeetingJsonResponseDto.builder()
                .meetingId(meetingJson.getId())
                .meetingName(meetingJson.getMeetingName())
                .skillList(meetingJson.getSkillList())
                .careerList(meetingJson.getCareerList())
                .build();
    }
}
