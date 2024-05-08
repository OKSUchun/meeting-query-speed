package com.sparta.meetingqueryspeed.dto;

import com.sparta.meetingqueryspeed.entity.meetingArray.MeetingArray;
import com.sparta.meetingqueryspeed.mapper.CareerMapper;
import com.sparta.meetingqueryspeed.mapper.SkillMapper;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class GetMeetingArrayResponseDto {
    private Long meetingId;
    private String meetingName;

    private List<SkillDto> skillList;
    private List<CareerDto> careerList;
    @Builder
    GetMeetingArrayResponseDto(Long meetingId, String meetingName, List<SkillDto> skillList, List<CareerDto> careerList){
        this.meetingId = meetingId;
        this.meetingName = meetingName;
        this.skillList = skillList;
        this.careerList = careerList;
    }
    public static GetMeetingArrayResponseDto fromEntity(MeetingArray meetingArray) {

        SkillMapper skillMapper = new SkillMapper();
        List<SkillDto> skillList = skillMapper.createSkillResponseList(meetingArray.getSkillIdList());

        CareerMapper careerMapper = new CareerMapper();
        List<CareerDto> careerList = careerMapper.createCareerResponseList(meetingArray.getCareerIdList());


        return GetMeetingArrayResponseDto.builder()
                .meetingId(meetingArray.getId())
                .meetingName(meetingArray.getMeetingName())
                .skillList(skillList)
                .careerList(careerList)
                .build();
    }
}
