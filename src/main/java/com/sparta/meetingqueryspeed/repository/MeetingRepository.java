package com.sparta.meetingqueryspeed.repository;

import com.sparta.meetingqueryspeed.entity.meeting.Meeting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MeetingRepository extends JpaRepository<Meeting, Long> {
    @Query(value = "SELECT m.*, " +
            "ST_Distance( CAST (ST_SetSRID(ST_MakePoint(:locationLng, :locationLat), 4326) AS geography), m.location_position) as dist " +
            "FROM meeting m " +
            "JOIN meeting_career mc ON mc.meeting_id = m.id " +
            "JOIN meeting_skill ms ON ms.meeting_id = m.id " +
            "WHERE " +
            "   ST_Dwithin( CAST (ST_SetSRID(ST_MakePoint(:locationLng, :locationLat), 4326) AS geography), m.location_position, 5000) " +
            "   AND ((ms.skill_id IN (:skillId) OR (:skillId IS NULL)) "+
            "    OR (mc.career_id in (:careerId) OR (:careerId IS NULL))) "+
            " ORDER BY dist asc " +
            "LIMIT :pageSize " +
            "OFFSET :offset", nativeQuery = true)
    List<Meeting> findMeetingST_Dwithin_withJoin(@Param("locationLng") Double locationLng,
                                                 @Param("locationLat") Double locationLat,
                                                 @Param("skillId") List<Long> skillId,
                                                 @Param("careerId") List<Long> careerId,
                                                 @Param("pageSize") int pageSize,
                                                 @Param("offset") int offset);
}
