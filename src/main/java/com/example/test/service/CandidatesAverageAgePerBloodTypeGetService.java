package com.example.test.service;

import com.example.test.domain.dto.response.CandidatesAverageAgePerBloodTypeDTO;
import com.example.test.domain.repository.CandidatesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CandidatesAverageAgePerBloodTypeGetService {

    @Autowired
    CandidatesRepository candidatesRepository;

    public List<CandidatesAverageAgePerBloodTypeDTO> execute(){

        return candidatesRepository.averageAgeBloodType().stream()
                .map(CandidatesAverageAgePerBloodTypeDTO::fromModel).collect(Collectors.toList());
    }

}
