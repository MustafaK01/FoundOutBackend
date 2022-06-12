package com.mustafak01.foundoutbackendrestaurants.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="menus")
public class MenuModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "menu_id",unique = true)
    Long id;

    @ManyToOne
    @JoinColumn(name = "servicings_category_id")
    MenuServicingCategoryModel menuServicingCategoryModel;

    //Menü Adının Tutulduğu Tablo Ayrılabilir.
    @Column(name = "menu_name",unique = false,nullable = false)
    String menuName;

    @Column(name = "menu_explanation",unique = false)
    String explanation;
    @ManyToOne
    @JoinColumn(name = "user_id",nullable = false,unique = false)
    UserModel userModel;

    //Sonradan Eklendi
    @OneToMany(mappedBy = "menuModel",cascade = CascadeType.ALL,orphanRemoval = true)
    List<MenuServicingModel> menuServicingModels;
}
