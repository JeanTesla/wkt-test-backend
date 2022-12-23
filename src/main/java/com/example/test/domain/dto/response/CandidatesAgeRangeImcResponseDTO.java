package com.example.test.domain.dto.response;

import com.example.test.domain.model.CandidateAgeRangeImc;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CandidatesAgeRangeImcResponseDTO {
    private Double imc;
    private String range;

    public static CandidatesAgeRangeImcResponseDTO fromModel(CandidateAgeRangeImc candidateAgeRangeImc){
        return CandidatesAgeRangeImcResponseDTO
                .builder()
                .imc(candidateAgeRangeImc.getImc())
                .range(calcAgeRange(candidateAgeRangeImc.getAgeRangeCode()))
                .build();
    }

    private static String calcAgeRange(Integer ageRangeCode){
        int ageRange = 10;
        int rangeBase = ageRangeCode * ageRange;
        return ageRangeCode == 0 ? String.format("%d - %d", 0, ageRange) :
                String.format("%d - %d", rangeBase + 1, rangeBase + 10);
    }
}
