package com.sparta.meetingqueryspeed.controller;

import com.sparta.meetingqueryspeed.dto.GetMeetingJoinResponseDto;
import com.sparta.meetingqueryspeed.service.MeetingService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Slice;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/meetings")
public class MeetingController {
    private final MeetingService meetingService;

    /*비정규화 json*/


    /* 정규화 JOIN*/
    @GetMapping("/withJoin")
    public ResponseEntity<Slice<GetMeetingJoinResponseDto>> getMeetingListPostgreWithJoin(
            @RequestParam Double locationLat,
            @RequestParam Double locationLng,
            @RequestParam(required = false) List<Long> skillId,
            @RequestParam(required = false) List<Long> careerId,
            @RequestParam(defaultValue = "1") int page)
    {

        if (skillId == null || skillId.isEmpty()) {
            skillId = new ArrayList<Long>();
        }
        if (careerId == null || careerId.isEmpty()) {
            careerId = new ArrayList<Long>();
        }

        Slice<GetMeetingJoinResponseDto> responseDtoList = meetingService.getMeetingListPostgreWithJoin(
                page
                , locationLat
                , locationLng
                , skillId
                , careerId
        );

        return ResponseEntity.ok().body(responseDtoList);
    }
}
