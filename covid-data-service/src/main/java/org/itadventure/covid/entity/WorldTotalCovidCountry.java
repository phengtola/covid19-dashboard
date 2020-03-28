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
@Table(name ="world_total_covid_country")
@Audited
public class WorldTotalCovidCountry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(insertable=false, updatable=false, nullable = false)
    private Long id;
    @Column(name = "country_id", unique = true)
    private String countryId;
    @Column(name = "country_en", unique = true)
    private String countryEn;
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
