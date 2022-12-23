package com.example.test.domain.repository;

import com.example.test.domain.entity.Candidate;
import com.example.test.domain.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CandidatesRepository extends JpaRepository<Candidate, Long> {

    @Query(value = "SELECT new com.example.test.domain.model.CandidateCountPerState(COUNT(c.id)," +
            " c.state) FROM Candidate c GROUP BY c.state")
    List<CandidateCountPerState> countPerState();

    @Query(value = "SELECT new com.example.test.domain.model" +
            ".CandidateAgeRangeImc(FLOOR(((YEAR(CURRENT_DATE) - YEAR(c.birthDate)) - 1)/10)," +
            " ROUND(AVG((c.weight / POW(c.height,2)) + 0.0),3))" +
            " FROM Candidate c" +
            " GROUP BY FLOOR(((YEAR(CURRENT_DATE) - YEAR(c.birthDate)) - 1)/10)" +
            " ORDER BY FLOOR(((YEAR(CURRENT_DATE) - YEAR(c.birthDate)) - 1)/10)")
    List<CandidateAgeRangeImc> ageRangeImc();

    @Query(value = "SELECT new com.example.test.domain.model" +
            ".CandidateObesePercentage(SUM(CASE WHEN sex = 'masculino' THEN 1 ELSE 0 END) AS mens," +
            "SUM(CASE WHEN sex = 'feminino' THEN 1 ELSE 0 END) AS women," +
            "SUM(CASE WHEN (weight / POW(height,2)) > 30 AND sex = 'masculino' THEN 1 ELSE 0 END) AS obese_mens," +
            "SUM(CASE WHEN (weight / POW(height,2)) > 30 AND sex = 'feminino' THEN 1 ELSE 0 END))" +
            " FROM Candidate c")
    CandidateObesePercentage obesePercentage();

    @Query(value = "SELECT new com.example.test.domain.model.CandidateAverageAgeBloodType(" +
            "ROUND(AVG((YEAR(CURRENT_DATE) - YEAR(c.birthDate))), 0), c.bloodType)" +
            "  FROM Candidate c GROUP BY c.bloodType" +
            " ORDER BY ROUND(AVG((YEAR(CURRENT_DATE) - YEAR(c.birthDate))), 0) DESC")
    List<CandidateAverageAgeBloodType> averageAgeBloodType();

    @Query(value = "SELECT new com.example.test.domain.model" +
            ".CandidateDonorsPerBloodType(SUM(CASE WHEN c.bloodType IN('A+', 'A-', 'O+', 'O-') THEN 1 ELSE 0 END)," +
            "SUM(CASE WHEN c.bloodType IN('A-', 'O-') THEN 1 ELSE 0 END)," +
            "SUM(CASE WHEN c.bloodType IN('B+', 'B-', 'O+', 'O-') THEN 1 ELSE 0 END)," +
            "SUM(CASE WHEN c.bloodType IN('B-', 'O-') THEN 1 ELSE 0 END)," +
            "SUM(CASE WHEN c.bloodType IN('A+', 'B+', 'O+', 'AB+', 'A-', 'B-', 'O-', 'AB-') THEN 1 ELSE 0 END)," +
            "SUM(CASE WHEN c.bloodType IN('A-', 'B-', 'O-', 'AB-') THEN 1 ELSE 0 END)," +
            "SUM(CASE WHEN c.bloodType IN('O+', 'O-') THEN 1 ELSE 0 END)," +
            "SUM(CASE WHEN c.bloodType IN('O-') THEN 1 ELSE 0 END))" +
            " FROM Candidate c" +
            " WHERE (YEAR(CURRENT_DATE) - YEAR(c.birthDate)) BETWEEN 16 AND 69" +
            " AND c.weight > 50")
    CandidateDonorsPerBloodType countDonorsByBloodType();
}
