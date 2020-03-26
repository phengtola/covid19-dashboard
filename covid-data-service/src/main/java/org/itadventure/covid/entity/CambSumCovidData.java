package org.itadventure.covid.entity;

import lombok.*;
import org.hibernate.envers.Audited;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "camb_sum_covid_data")
public class CambSumCovidData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(insertable=false, updatable=false, nullable = false)
    private Long id;

    private long totalCases;
    private long totalDeaths;
    private long totalRecovered;

    private long totalMale;
    private long totalFemale;

    private long totalUsa;
    private long totalBelgium;
    private long totalChina;
    private long totalEngland;
    private long totalMalaysia;
    private long totalCambodia;

    @Column(name = "updated_date", columnDefinition = "TIMESTAMP")
    @LastModifiedDate
    private LocalDateTime updatedDate;



}
