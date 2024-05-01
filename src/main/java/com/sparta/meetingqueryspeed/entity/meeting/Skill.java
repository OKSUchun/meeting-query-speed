package com.sparta.meetingqueryspeed.entity.meeting;

import jakarta.persistence.*;
import lombok.*;

@Entity(name="skill")
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@Getter
public class Skill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(name = "skill_name")
    private String skillName;

}
