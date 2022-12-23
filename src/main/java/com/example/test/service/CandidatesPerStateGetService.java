package com.example.test.service;

import com.example.test.domain.dto.response.CandidatesCountPerStateResponseDTO;
import com.example.test.domain.repository.CandidatesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CandidatesPerStateGetService {

    @Autowired
    CandidatesRepository candidatesRepository;

    public List<CandidatesCountPerStateResponseDTO> execute(){
        return candidatesRepository.countPerState().stream()
                .map(CandidatesCountPerStateResponseDTO::fromModel).collect(Collectors.toList());
    }
}
