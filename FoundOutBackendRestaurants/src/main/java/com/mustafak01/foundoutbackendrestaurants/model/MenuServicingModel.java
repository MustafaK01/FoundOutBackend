package com.mustafak01.foundoutbackendrestaurants.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "menu_servicings")
public class MenuServicingModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "menu_servicing_id",unique = true)
    Long id;

    @ManyToOne
    @JoinColumn(name = "menu_id")
    MenuModel menuModel;

    @Column(name = "servicing_name")
    String name;

    @Column(name = "servicing_price")
    String price;

    //Sonradan Eklendi
    @OneToMany(mappedBy = "menuServicingModel",cascade = CascadeType.ALL)
    List<MenuServicingImage> menuServicingModels;
}
