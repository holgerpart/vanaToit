package com.bcs.vanaToit.domain.shop.profile;

import com.bcs.vanaToit.domain.shop.city.City;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
@Getter
@Setter
@Entity
@Table(name = "profile")
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "aadress", nullable = false)
    private String aadress;

    @Column(name = "tel_number", nullable = false)
    private String telNumber;

    @Column(name = "longitude", precision = 7, scale = 5)
    private BigDecimal longitude;

    @Column(name = "latitude", precision = 7, scale = 5)
    private BigDecimal latitude;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "city_id", nullable = false)
    private City city;

}