package com.example.test.domain.dto.response;

import com.example.test.domain.model.CandidateAverageAgeBloodType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class CandidatesAverageAgePerBloodTypeDTO {
    private Double averageAge;
    private String bloodType;

    public static CandidatesAverageAgePerBloodTypeDTO fromModel(
            CandidateAverageAgeBloodType candidateAverageAgeBloodType){
        return CandidatesAverageAgePerBloodTypeDTO
                .builder()
                .averageAge(candidateAverageAgeBloodType.getAverageAge())
                .bloodType(candidateAverageAgeBloodType.getBloodType())
                .build();
    }
}
