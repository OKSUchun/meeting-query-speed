package com.sparta.meetingqueryspeed.service;

import com.sparta.meetingqueryspeed.dto.GetMeetingJoinResponseDto;
import com.sparta.meetingqueryspeed.entity.meeting.Meeting;
import com.sparta.meetingqueryspeed.paginator.ListPaginator;
import com.sparta.meetingqueryspeed.paginator.Paginator;
import com.sparta.meetingqueryspeed.repository.MeetingRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.SliceImpl;
import org.springframework.stereotype.Service;

import java.util.List;
@Slf4j(topic = "Meeting Service Log")
@Service
@RequiredArgsConstructor
public class MeetingService {
    private final MeetingRepository meetingRepository;
    private final Paginator<Meeting> paginator = new ListPaginator<>();

    /*정규화 JOIN*/
    public Slice<GetMeetingJoinResponseDto> getMeetingListPostgreWithJoin(
            int page
            , Double locationLat
            , Double locationLng
            , List<Long> skillId
            , List<Long> careerId
    ) {
        int extraItem = 1; // pagination 을 위한 추가 요청
        int pageSize = 10;
        int offset = Math.max(page - 1, 0) * pageSize;

        List<Meeting> meetingList = meetingRepository.findMeetingST_Dwithin_withJoin(
                locationLng
                , locationLat
                , skillId
                , careerId
                , pageSize + extraItem
                , offset
        );

        Pageable pageable = PageRequest.of(Math.max(page - 1, 0), pageSize);
        boolean hasNext = hasNextPage(meetingList, pageable.getPageSize());
        List<GetMeetingJoinResponseDto> sliceList = meetingList.stream().limit(pageSize).map(GetMeetingJoinResponseDto::fromEntity).toList();
        return new SliceImpl<>(sliceList, pageable, hasNext);
    }

    private boolean hasNextPage(List<Meeting> meetingList, int pageSize) {
        return paginator.hasNextPage(meetingList, pageSize);
    }
}
