package org.itadventure.covid.entity;

import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.envers.Audited;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Last Updated At 28/03/2020 By Tola
 */

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

    /** TotalCases **/
    @ColumnDefault("0")
    private long totalCases;
    @ColumnDefault("0")
    private long totalCasesFemale;
    @ColumnDefault("0")
    private long totalCasesMale;
    @ColumnDefault("0")
    private long totalCasesUsa;
    @ColumnDefault("0")
    private long totalCasesBelgium;
    @ColumnDefault("0")
    private long totalCasesChina;
    @ColumnDefault("0")
    private long totalCasesEngland;
    @ColumnDefault("0")
    private long totalCasesMalaysia;
    @ColumnDefault("0")
    private long totalCasesCambodia;
    @ColumnDefault("0")
    private long totalCasesIndonesia;
    @ColumnDefault("0")
    private long totalCasesCanada;
    @ColumnDefault("0")
    private long totalCasesFrance;

    /** TotalActiveCases **/
    @ColumnDefault("0")
    private long totalActiveCases;
    @ColumnDefault("0")
    private long totalActiveCasesFemale;
    @ColumnDefault("0")
    private long totalActiveCasesMale;

    /** totalRecovered **/
    @ColumnDefault("0")
    private long totalRecovered;
    @ColumnDefault("0")
    private long totalRecoveredFemale;
    @ColumnDefault("0")
    private long totalRecoveredMale;
    @ColumnDefault("0")
    private long totalRecoveredUsa;
    @ColumnDefault("0")
    private long totalRecoveredBelgium;
    @ColumnDefault("0")
    private long totalRecoveredChina;
    @ColumnDefault("0")
    private long totalRecoveredEngland;
    @ColumnDefault("0")
    private long totalRecoveredMalaysia;
    @ColumnDefault("0")
    private long totalRecoveredIndonesia;
    @ColumnDefault("0")
    private long totalRecoveredCanada;
    @ColumnDefault("0")
    private long totalRecoveredFrance;
    @ColumnDefault("0")
    private long totalRecoveredCambodia;

    /** totalDeaths **/
    @ColumnDefault("0")
    private long totalDeaths;
    @ColumnDefault("0")
    private long totalDeathsFemale;
    @ColumnDefault("0")
    private long totalDeathsMale;


    @Column(name = "updated_date", columnDefinition = "TIMESTAMP DEFAULT NOW()")
    @LastModifiedDate
    private LocalDateTime updatedDate;

}
