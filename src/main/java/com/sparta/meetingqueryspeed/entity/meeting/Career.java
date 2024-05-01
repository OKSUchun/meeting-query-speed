package com.sparta.meetingqueryspeed.entity.meeting;

import jakarta.persistence.*;
import lombok.*;


@Entity(name="career")
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@Getter
public class Career {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(name = "career_name")
    private String careerName;

}
