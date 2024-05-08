package com.sparta.meetingqueryspeed.mapper;

import com.sparta.meetingqueryspeed.dto.CareerDto;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CareerMapper {

    private static final Map<Integer, String> CAREER_MAP = Map.ofEntries(
            Map.entry(1, "신입"),
            Map.entry(2, "주니어(1~3)"),
            Map.entry(3, "미들(5~8)"),
            Map.entry(4,"시니어(9~12)"),
            Map.entry(5,"엑스퍼트(13이상)")
    );

    public List<String> mapCareerIdsToNames(List<Long> careerIds) {
        return careerIds.stream()
                .map(CAREER_MAP::get)
                .collect(Collectors.toList());
    }
    public List<CareerDto> createCareerResponseList(int[] careerIds) {
        return Arrays.stream(careerIds) // Creates an IntStream
                .mapToObj(id -> CareerDto.builder()
                        .careerId(id)
                        .careerName(CAREER_MAP.get(id))
                        .build())
                .collect(Collectors.toList());
    }
    
}
