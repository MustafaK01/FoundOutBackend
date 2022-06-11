package com.mustafak01.foundoutbackendrestaurants;

import com.mustafak01.foundoutbackendrestaurants.mernis.KPSPublicSoap;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class FoundOutBackendRestaurantsApplication {

	public static void main(String[] args) throws Exception {
//		KPSPublicSoap client = new KPSPublicSoap();
//		Long tc = 65879865658L;
//		Boolean isTrue = client.TCKimlikNoDogrula(00000000000L,"İSİM","SOYİSİM",DOĞUMTARİHİ);
//		System.out.println(isTrue);
		SpringApplication.run(FoundOutBackendRestaurantsApplication.class, args);
	}

}
