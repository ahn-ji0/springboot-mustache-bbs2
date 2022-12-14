package com.mustache.bbspractice2.domain.entity;

import com.mustache.bbspractice2.domain.dto.HospitalResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor // 안하면 findAll 할때 no default constructor for entity 오류
@Getter
@Entity
@Builder
@Table(name = "hospital")
public class HospitalEntity {
    @Id
    private Integer id;

    @Column(name = "road_name_address")
    private String roadNameAddress;

    @Column(name = "hospital_name")
    private String hospitalName;

    @Column(name = "business_type_name")
    private String businessTypeName;

    @Column(name = "total_number_of_beds")
    private int totalNumberOfBeds;

    @Column(name = "business_status_code")
    private Integer businessStatusCode;

    public static HospitalResponse of(HospitalEntity hospitalEntity) {
        return new HospitalResponse(hospitalEntity.getId(), hospitalEntity.getRoadNameAddress(),
                hospitalEntity.getHospitalName(), hospitalEntity.getBusinessTypeName(),
                hospitalEntity.getTotalNumberOfBeds());
    }
}
