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
@Table(name = "camb_total_covid_province")
public class CambTotalCovidDataProvince {

    @Id
    @Column(name = "province_en")
    private String provinceEn;
    @Column(name = "country")
    private String country;
    @Column(name = "province_kh")
    private String provinceKh;
    private long totalCases;
    private long totalDeaths;
    private long totalRecovered;
    @Column(name = "updated_date", columnDefinition = "TIMESTAMP")
    @LastModifiedDate
    private LocalDateTime updatedDate;



}
