package com.mustafak01.foundoutbackendrestaurants.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="menus")
public class MenuModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "menu_id")
    Long id;

    @ManyToOne
    @JoinColumn(name = "servicings_category_id")
    MenuServicingCategoryModel menuServicingCategoryModel;

    //Menü Adının Tutulduğu Tablo Ayrılabilir.
    @Column(name = "menu_name")
    String menuName;

    @ManyToOne
    @JoinColumn(name = "user_id")
    UserModel userModel;

}
