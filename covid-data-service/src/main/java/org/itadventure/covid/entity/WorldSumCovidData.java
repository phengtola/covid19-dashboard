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
@Audited
public class WorldSumCovidData {

    @Id
    private long id;
    private long totalCases;
    private long newCases;
    private long totalDeaths;
    private long newDeaths;
    private long totalRecovered;
    private long activeCases;
    private long seriousCritical;
    @Column(name = "tot_cases_1m_pop")
    private double totCases1mPop;
    @Column(name = "tot_deaths_1m_pop")
    private double totDeaths1mPop;
    @Column(name = "updated_at", columnDefinition = "TIMESTAMP")
    @LastModifiedDate
    private LocalDateTime updatedAt;



}
