package com.example.test.service;

import com.example.test.domain.dto.response.CandidatesObesePercentageDTO;
import com.example.test.domain.repository.CandidatesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CandidatesObesePercentageGetService {

    @Autowired
    CandidatesRepository candidatesRepository;

    public CandidatesObesePercentageDTO execute(){
        return CandidatesObesePercentageDTO.fromModel(candidatesRepository.obesePercentage());
    }
}
