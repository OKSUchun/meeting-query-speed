package com.sparta.meetingqueryspeed.entity.meeting;

import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class MeetingSkill {
    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @ManyToOne
    @JoinColumn(name = "meeting_id")
    private Meeting meeting;

    @ManyToOne
    @JoinColumn(name = "skill_id")
    private Skill skill;

    @Builder
    public MeetingSkill(Meeting meeting, Skill skill) {
        this.meeting = meeting;
        this.skill = skill;
    }
}