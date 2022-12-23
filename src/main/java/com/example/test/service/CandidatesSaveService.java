package com.example.test.service;

import com.example.test.domain.dto.request.CandidatesRequestDTO;
import com.example.test.domain.entity.Candidate;
import com.example.test.domain.repository.CandidatesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CandidatesSaveService {

    @Autowired
    CandidatesRepository candidatesRepository;

    public void execute(List<CandidatesRequestDTO> candidatesRequestDTOList){
        List<Candidate> candidates = candidatesRequestDTOList.stream().map(it -> {
                    try {
                        return CandidatesRequestDTO.toEntity(it);
                    } catch (ParseException e) {
                        throw new RuntimeException(e);
                    }
                })
                .collect(Collectors.toList());

        candidatesRepository.saveAll(candidates);
    }

}
