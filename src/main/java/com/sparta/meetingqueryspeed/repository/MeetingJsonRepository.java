package com.sparta.meetingqueryspeed.repository;

import com.sparta.meetingqueryspeed.entity.meetingJson.MeetingJson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MeetingJsonRepository extends JpaRepository<MeetingJson, Long> {
    @Query(value = "SELECT m.*, " +
            "ST_Distance( CAST (ST_SetSRID(ST_MakePoint(:locationLng, :locationLat), 4326) AS geography), m.location_position) as dist " +
            "FROM meeting_json m " +
            "WHERE " +
            "   ST_Dwithin( CAST (ST_SetSRID(ST_MakePoint(:locationLng, :locationLat), 4326) AS geography), m.location_position, 5000) " +
            "   AND ((:skillIdsStr IS NULL OR EXISTS (" +
            "         SELECT 1 FROM jsonb_array_elements(m.skill_list) AS skill_json " +
            "         WHERE CAST(skill_json->>'skillId' AS TEXT) = ANY(string_to_array(:skillIdsStr, ',')) " +
            "       )) " +
            "   OR (:careerIdsStr IS NULL OR EXISTS (" +
            "         SELECT 1 FROM jsonb_array_elements(m.career_list) AS career_json " +
            "         WHERE CAST(career_json->>'careerId' AS TEXT) = ANY(string_to_array(:careerIdsStr, ',')) " +
            "       ))) " +
            " ORDER BY dist asc " +
            "LIMIT :pageSize " +
            "OFFSET :offset", nativeQuery = true)
    List<MeetingJson> findMeetingST_Dwithin(@Param("locationLng") Double locationLng,
                                        @Param("locationLat") Double locationLat,
                                        @Param("skillIdsStr") String skillIdsStr,
                                        @Param("careerIdsStr") String careerIdsStr,
                                        @Param("pageSize") int pageSize,
                                        @Param("offset") int offset);
}
