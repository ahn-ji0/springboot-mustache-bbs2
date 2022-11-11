package com.mustache.bbspractice2.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor // 안하면 findAll 할때 no default constructor for entity 오류
@Getter
@Entity
@Table(name = "hospital")
public class HospitalEntity {
    @Id
    private Integer id;

    @Column(name = "road_name_address")
    private String roadNameAddress;

    @Column(name = "hospital_name")
    private String hospitalName;
}
