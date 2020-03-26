package org.itadventure.covid.entity.base;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "cam_covid_data")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CambodiaCovidData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(insertable=false, updatable=false, nullable = false)
    private Long id;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date postedDate;
    private long age;
    private String gender;
    private String nationality;
    private String treatmentFacility;
    private String previousTravel;
    private String status;
    private String updatedStatusDate;
    private String description;
    private String detectedLocation;
    @ManyToOne
    @JoinColumn(name = "province_id")
    private CambodiaProvince province;


}
