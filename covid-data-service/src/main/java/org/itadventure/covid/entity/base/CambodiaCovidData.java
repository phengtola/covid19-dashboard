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
    private String id;
    private String date;
    private String age;
    private String gender;
    private String nationality;
    private String detectedLocation;
    private String treatmentFacility;
    private String previousTravel;
    private String status;
    private String note;
    private String source;
    private String updatedStatusDate;

    @ManyToOne
    @JoinColumn(name = "province_id")
    private CambodiaProvince province;


}
