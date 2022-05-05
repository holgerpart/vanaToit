package com.bcs.vanaToit.domain.shopfood;

import com.bcs.vanaToit.domain.food.food.Food;
import com.bcs.vanaToit.domain.food.unit.Unit;
import com.bcs.vanaToit.domain.shop.shop.Shop;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.Instant;
import java.time.LocalDate;
@Getter
@Setter
@Entity
@Table(name = "shop_food")
public class ShopFood {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "shop_id", nullable = false)
    private Shop shop;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "food_id", nullable = false)
    private Food food;

    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "unit_id", nullable = false)
    private Unit unit;

    @Column(name = "is_available", nullable = false)
    private Boolean isAvailable = false;

    @Column(name = "date_time", nullable = false)
    private Instant dateTime;

    @Column(name = "expiration_date")
    private LocalDate expirationDate;

    @Column(name = "comments", length = 1000)
    private String comments;

}