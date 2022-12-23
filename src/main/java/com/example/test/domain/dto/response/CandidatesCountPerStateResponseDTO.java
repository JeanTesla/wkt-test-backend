package com.example.test.domain.dto.response;

import com.example.test.domain.model.CandidateCountPerState;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class CandidatesCountPerStateResponseDTO {
    private Long count;
    private String state;

    public static CandidatesCountPerStateResponseDTO fromModel(CandidateCountPerState candidateCountPerState){
        return CandidatesCountPerStateResponseDTO
                .builder()
                .count(candidateCountPerState.getCount())
                .state(candidateCountPerState.getState())
                .build();
    }
}
