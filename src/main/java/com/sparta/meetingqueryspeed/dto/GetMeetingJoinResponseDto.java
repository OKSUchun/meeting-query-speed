package com.sparta.meetingqueryspeed.dto;

import com.sparta.meetingqueryspeed.entity.meeting.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class GetMeetingJoinResponseDto {
    private Long meetingId;
    private String meetingName;
    private List<Skill> skillList;
    private List<Career> careerList;

    @Builder
    GetMeetingJoinResponseDto(Long meetingId, String meetingName, List<Skill> skillList, List<Career> careerList ){
        this.meetingId = meetingId;
        this.meetingName = meetingName;
        this.skillList = skillList;
        this.careerList = careerList;
    }

    public static GetMeetingJoinResponseDto fromEntity(Meeting meeting) {
        List<Skill> skillList = meeting.getSkills().stream()
                .map(MeetingSkill::getSkill)
                .toList();
        List<Career> careerList = meeting.getCareers().stream()
                .map(MeetingCareer::getCareer)
                .toList();

        return GetMeetingJoinResponseDto.builder()
                .meetingId(meeting.getId())
                .meetingName(meeting.getMeetingName())
                .skillList(skillList)
                .careerList(careerList)
                .build();
    }

}
