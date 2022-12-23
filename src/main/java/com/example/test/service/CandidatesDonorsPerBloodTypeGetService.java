package com.example.test.service;

import com.example.test.domain.dto.response.CandidatesDonorsPerBloodTypeDTO;
import com.example.test.domain.repository.CandidatesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CandidatesDonorsPerBloodTypeGetService {

    @Autowired
    CandidatesRepository candidatesRepository;

    public CandidatesDonorsPerBloodTypeDTO execute(){
        return CandidatesDonorsPerBloodTypeDTO.fromModel(candidatesRepository.countDonorsByBloodType());
    }
}
