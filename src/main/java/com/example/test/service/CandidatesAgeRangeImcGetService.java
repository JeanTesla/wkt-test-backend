package com.example.test.service;

import com.example.test.domain.dto.response.CandidatesAgeRangeImcResponseDTO;
import com.example.test.domain.model.CandidateAgeRangeImc;
import com.example.test.domain.repository.CandidatesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CandidatesAgeRangeImcGetService {

    @Autowired
    CandidatesRepository candidatesRepository;

    public List<CandidatesAgeRangeImcResponseDTO> execute() {

        List<CandidateAgeRangeImc> candidateAgeRangeImcList = candidatesRepository.ageRangeImc();

        return candidateAgeRangeImcList.stream()
                .map(CandidatesAgeRangeImcResponseDTO::fromModel).collect(Collectors.toList());
    }
}
