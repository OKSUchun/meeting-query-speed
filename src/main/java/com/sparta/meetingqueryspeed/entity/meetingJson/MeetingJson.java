package com.sparta.meetingqueryspeed.entity.meetingJson;

import io.hypersistence.utils.hibernate.type.json.JsonType;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Type;
import org.locationtech.jts.geom.Point;

import java.util.List;

@Entity(name = "meeting_json")
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class MeetingJson {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "meeting_name")
    private String meetingName;
    @Column(columnDefinition = "geography(Point,4326)")
    private Point locationPosition;

    @Type(JsonType.class)
    @Column(name = "skill_list",columnDefinition = "jsonb")
    private List<InnerSkill> skillList;

    @Type(JsonType.class)
    @Column(name = "career_list",columnDefinition = "jsonb")
    private List<InnerCareer> careerList;

    @Builder
    public MeetingJson(Long id, String meetingName, List<InnerSkill> skillList, List<InnerCareer> careerList) {
        this.id = id;
        this.meetingName = meetingName;
        this.skillList = skillList;
        this.careerList = careerList;
    }
}
