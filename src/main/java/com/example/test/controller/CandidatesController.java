package com.example.test.controller;

import com.example.test.domain.dto.request.CandidatesRequestDTO;
import com.example.test.domain.dto.response.*;
import com.example.test.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/candidates")
@Validated
public class CandidatesController {

    @Autowired
    CandidatesSaveService candidatesSaveService;

    @Autowired
    CandidatesPerStateGetService candidatesPerStateGetService;

    @Autowired
    CandidatesAgeRangeImcGetService candidatesAgeRangeImcGetService;

    @Autowired
    CandidatesObesePercentageGetService candidatesObesePercentageGetService;

    @Autowired
    CandidatesAverageAgePerBloodTypeGetService candidatesAverageAgePerBloodTypeGetService;

    @Autowired
    CandidatesDonorsPerBloodTypeGetService candidatesDonorsPerBloodTypeGetService;

    @PostMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.CREATED)
    public void saveCandidates(@Valid @RequestBody List<CandidatesRequestDTO> candidatesRequestDTOList) {
        candidatesSaveService.execute(candidatesRequestDTOList);
    }

    @GetMapping(value = "/perstates", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<CandidatesCountPerStateResponseDTO> getCandidatesPerState() {
        return candidatesPerStateGetService.execute();
    }

    @GetMapping(value = "/agerangeimcs", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<CandidatesAgeRangeImcResponseDTO> getAgeRangeImc(){
        return candidatesAgeRangeImcGetService.execute();
    }

    @GetMapping(value = "/obesepercentages", produces = MediaType.APPLICATION_JSON_VALUE)
    public CandidatesObesePercentageDTO getObesePercentage(){
        return candidatesObesePercentageGetService.execute();
    }

    @GetMapping(value = "/averageageperbloodtypes", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<CandidatesAverageAgePerBloodTypeDTO>  getAverageAgesPerBloodType(){
        return candidatesAverageAgePerBloodTypeGetService.execute();
    }

    @GetMapping(value = "/donorsperbloodtype", produces = MediaType.APPLICATION_JSON_VALUE)
    public CandidatesDonorsPerBloodTypeDTO getDonorsPerBloodType(){
        return candidatesDonorsPerBloodTypeGetService.execute();
    }

}
