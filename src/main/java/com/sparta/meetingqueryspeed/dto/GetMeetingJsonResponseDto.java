package com.sparta.meetingqueryspeed.dto;

import com.sparta.meetingqueryspeed.entity.meetingJson.CareerResponseDto;
import com.sparta.meetingqueryspeed.entity.meetingJson.MeetingJson;
import com.sparta.meetingqueryspeed.entity.meetingJson.SkillResponseDto;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class GetMeetingJsonResponseDto {
    private Long meetingId;
    private String meetingName;

    private List<SkillResponseDto> skillList;
    private List<CareerResponseDto> careerList;
    @Builder
    GetMeetingJsonResponseDto(Long meetingId, String meetingName, List<SkillResponseDto> skillList, List<CareerResponseDto> careerList){
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
