package org.itadventure.covid.entity.base;//package kh.gov.moc.businessregistration.backofficeapi.locationservice.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.itadventure.covid.entity.base.BaseEntityAudit;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Data
@Entity
@Table(name = "cam_provinces")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CambodiaProvince extends BaseEntityAudit {
    @Column(name = "code", unique = true)
    private String code;
    @Column(name = "province_type_kh")
    private String provinceTypeKh;
    @Column(name = "province_type_en")
    private String provinceTypeEn;
    @Column(name = "reference")
    private String reference;
    @Column(name = "issued_date")
    private Date issuedDate;
    @Column(name = "note")
    private String note;
    @Column(name = "prefix")
    private String prefix;
    @Column(name = "name_en")
    private String nameEn;
    @Column(name = "name_kh")
    private String nameKh;
    @Column(name = "total_district")
    private Integer totalDistrict;
    @Column(name = "total_commune")
    private Integer totalCommune;
    @Column(name = "total_village")
    private Integer totalVillage;

    @Column(name = "country")
    private String country;

}
