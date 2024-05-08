package com.sparta.meetingqueryspeed.entity.meetingArray;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name = "meeting_array")
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class MeetingArray {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "meeting_name")
    private String meetingName;

    @Column(name = "career_id_list", columnDefinition = "integer[]")
    private int[] careerIdList;

    @Column(name = "skill_id_list", columnDefinition = "integer[]")
    private int[] skillIdList;


}
