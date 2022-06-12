package com.mustafak01.foundoutbackendrestaurants.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Optional;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "servicing_images")
public class MenuServicingImage {

	@Id
	@Column(name = "servicing_image_id",unique = true)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long servicingImageId;

	@Column(name = "servicing_image_name", unique = false)
	private String name;

	@Column(name = "servicing_image_type", unique = false)
	private String type;

	@Column(name = "servicing_image", unique = false, nullable = false, length = 100000)
	private byte[] image;

	@ManyToOne
	@JoinColumn(name="menu_servicing_id")
	MenuServicingModel menuServicingModel;

}