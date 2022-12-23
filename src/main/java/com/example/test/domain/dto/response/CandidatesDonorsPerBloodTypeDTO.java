package com.example.test.domain.dto.response;

import com.example.test.domain.model.CandidateDonorsPerBloodType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class CandidatesDonorsPerBloodTypeDTO {
    private Long positiveA;
    private Long negativeA;
    private Long positiveB;
    private Long negativeB;
    private Long positiveAB;
    private Long negativeAB;
    private Long positiveO;
    private Long negativeO;

    public static CandidatesDonorsPerBloodTypeDTO fromModel(CandidateDonorsPerBloodType candidateDonorsPerBloodType){
        return CandidatesDonorsPerBloodTypeDTO
                .builder()
                .positiveA(candidateDonorsPerBloodType.getPositiveA())
                .negativeA(candidateDonorsPerBloodType.getNegativeA())
                .positiveB(candidateDonorsPerBloodType.getPositiveB())
                .negativeB(candidateDonorsPerBloodType.getNegativeB())
                .positiveAB(candidateDonorsPerBloodType.getPositiveAB())
                .negativeAB(candidateDonorsPerBloodType.getNegativeAB())
                .positiveO(candidateDonorsPerBloodType.getPositiveO())
                .negativeO(candidateDonorsPerBloodType.getNegativeO())
                .build();
    }
}
