package com.sparta.meetingqueryspeed.repository;

import com.sparta.meetingqueryspeed.entity.meetingArray.MeetingArray;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MeetingArrayRepository extends JpaRepository<MeetingArray, Long> {
    @Query(value = "SELECT m.*, " +
            "ST_Distance( CAST (ST_SetSRID(ST_MakePoint(:locationLng, :locationLat), 4326) AS geography), m.location_position) as dist " +
            "FROM meeting_array m " +
            "WHERE " +
            "   ST_Dwithin( CAST (ST_SetSRID(ST_MakePoint(:locationLng, :locationLat), 4326) AS geography), m.location_position, 5000) " +
            "   AND (" +
            "       (:skillIdsStr IS NULL OR m.skill_id_list && CAST(string_to_array(:skillIdsStr, ',') AS integer[])) " +
            "    OR (:careerIdsStr IS NULL OR m.career_id_list && CAST(string_to_array(:careerIdsStr, ',') AS integer[])) " +
            ")" +
            " ORDER BY dist asc " +
            "LIMIT :pageSize " +
            "OFFSET :offset", nativeQuery = true)
    List<MeetingArray> findMeetingST_Dwithin_array(@Param("locationLng") Double locationLng,
                                              @Param("locationLat") Double locationLat,
                                              @Param("skillIdsStr") String skillIdsStr,
                                              @Param("careerIdsStr") String careerIdsStr,
                                              @Param("pageSize") int pageSize,
                                              @Param("offset") int offset);
}
