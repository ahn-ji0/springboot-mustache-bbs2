package com.mustache.bbspractice2.domain.dto;

import lombok.*;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HospitalResponse {
    private Integer id;
    private String roadNameAddress;
    private String hospitalName;
    private String businessTypeName;
    private Integer totalNumberOfBeds;
    private String businessStatusName;

    public HospitalResponse(Integer id, String roadNameAddress, String hospitalName, String businessTypeName, Integer totalNumberOfBeds) {
        this.id = id;
        this.roadNameAddress = roadNameAddress;
        this.hospitalName = hospitalName;
        this.businessTypeName = businessTypeName;
        this.totalNumberOfBeds = totalNumberOfBeds;
    }

    public void setBusinessStatusName(String businessStatusName){
        this.businessStatusName = businessStatusName;
    }
}
