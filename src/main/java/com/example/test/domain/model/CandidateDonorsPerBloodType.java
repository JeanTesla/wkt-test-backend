package com.example.test.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CandidateDonorsPerBloodType {
    private Long positiveA;
    private Long negativeA;
    private Long positiveB;
    private Long negativeB;
    private Long positiveAB;
    private Long negativeAB;
    private Long positiveO;
    private Long negativeO;
}
