package com.example.test.domain.dto.response;

import com.example.test.domain.model.CandidateObesePercentage;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CandidatesObesePercentageDTO {
    private Long obeseMenPercentage;
    private Long obeseWomenPercentage;
    private Long obeseMen;
    private Long obeseWomen;
    private Long totalMen;
    private Long totalWomen;

    public static CandidatesObesePercentageDTO fromModel(CandidateObesePercentage candidateObesePercentage){
        return CandidatesObesePercentageDTO
                .builder()
                .obeseMenPercentage(calcPercentage(candidateObesePercentage.getObeseMen(),
                        candidateObesePercentage.getCountMen()))
                .obeseWomenPercentage(calcPercentage(candidateObesePercentage.getObeseWomen(),
                        candidateObesePercentage.getCountWomen()))
                .obeseMen(candidateObesePercentage.getObeseMen())
                .obeseWomen(candidateObesePercentage.getObeseWomen())
                .totalMen(candidateObesePercentage.getCountMen())
                .totalWomen(candidateObesePercentage.getCountWomen())
                .build();
    }

    private static Long calcPercentage(Long event, Long samplingSpace){
        System.out.println(event + " " + samplingSpace);
        return (event * 100) / samplingSpace;
    }
}
