package com.sparta.meetingqueryspeed.mapper;

import com.sparta.meetingqueryspeed.dto.SkillDto;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SkillMapper {

    private static final Map<Integer, String> SKILL_MAP = Map.ofEntries(
            Map.entry(1, "Java"),
            Map.entry(2, "React"),
            Map.entry(3, "Python"),
            Map.entry(4,"JavaScript"),
            Map.entry(5,"Spring"),
            Map.entry(6,"NodeJs"),
            Map.entry(7,"C#"),
            Map.entry(8,"Vue.js"),
            Map.entry(9,"Ruby"),
            Map.entry(10,"Swift"),
            Map.entry(11,"HTML"),
            Map.entry(12,"CSS"),
            Map.entry(13,"SQL"),
            Map.entry(14,"Angular"),
            Map.entry(15,"PHP"),
            Map.entry(16,"Kotlin"),
            Map.entry(17,"Docker"),
            Map.entry(18,"Kubernetes"),
            Map.entry(19,"AWS"),
            Map.entry(20,"GCP"),
            Map.entry(21,"Git"),
            Map.entry(22,"Jenkins"),
            Map.entry(23,"Agile Methodology"),
            Map.entry(24,"React Native"),
            Map.entry(25,"Flutter"),
            Map.entry(26,"TypeScript"),
            Map.entry(27,"AngularJS"),
            Map.entry(28,"Express.js"),
            Map.entry(29,"Flask"),
            Map.entry(30,"Django"),
            Map.entry(31,"Laravel"),
            Map.entry(32,"Ruby"),
            Map.entry(33,"ASP.NET"),
            Map.entry(34,"Unity"),
            Map.entry(35,"Unreal Engine"),
            Map.entry(36,"PostgreSQL"),
            Map.entry(37,"MySQL"),
            Map.entry(38,"MongoDB"),
            Map.entry(39,"Redis"),
            Map.entry(40,"Elasticsearch"),
            Map.entry(41,"GraphQL"),
            Map.entry(42,"Microservices"),
            Map.entry(43,"Serverless Architecture"),
            Map.entry(44,"Blockchain"),
            Map.entry(45,"Machine Learning"),
            Map.entry(46,"Deep Learning"),
            Map.entry(47,"NLP"),
            Map.entry(48,"Data Engineering"),
            Map.entry(49,"DevOps"),
            Map.entry(50,"CI/CD"),
            Map.entry(51,"IaC"),
            Map.entry(52,"C++")
    );

    public List<String> mapSkillIdsToNames(List<Long> skillIds) {
        return skillIds.stream()
                .map(SKILL_MAP::get)
                .collect(Collectors.toList());
    }
    public List<SkillDto> createSkillResponseList(int[] skillIds) {
        return Arrays.stream(skillIds) // Creates an IntStream
            .mapToObj(id -> SkillDto.builder()
                    .skillId(id)
                    .skillName(SKILL_MAP.get(id))
                    .build())
            .collect(Collectors.toList());
    }
    
}
