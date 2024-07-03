package com.tableOrder.table_order.menu.entity;

import com.tableOrder.table_order.restaurant.entity.RestaurantEntity;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "information")
public class InformationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Integer id;

    @Column(nullable = false, name = "comment")
    private String comment;

    @OneToOne
    @JoinColumn(name = "menu_id", referencedColumnName = "id", nullable = false)
    private MenuEntity menu;

}
