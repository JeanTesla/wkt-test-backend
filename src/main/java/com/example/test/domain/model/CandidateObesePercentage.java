package com.example.test.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CandidateObesePercentage {
    private Long countMen;
    private Long countWomen;
    private Long obeseMen;
    private Long obeseWomen;
}
