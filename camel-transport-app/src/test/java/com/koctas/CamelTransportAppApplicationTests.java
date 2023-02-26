package com.koctas;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.koctas.service.CamelTransportService;

@SpringBootTest
class CamelTransportAppApplicationTests {

	@Autowired
	CamelTransportService mainService;
	
	
	@Test
	void test1() throws Exception {
		int elmaSayisi=1000;
		int mesafe=999;
		
		int beklenenSonuc=1;
		int hesaplanan = mainService.calculateMaxTransportedApples(elmaSayisi, mesafe);
		Assertions.assertEquals(beklenenSonuc, hesaplanan);
	}
	

	@Test
	void test2() throws Exception {
		int elmaSayisi=500;
		int mesafe=200;
		
		int beklenenSonuc=300;
		int hesaplanan = mainService.calculateMaxTransportedApples(elmaSayisi, mesafe);
		Assertions.assertEquals(beklenenSonuc, hesaplanan);
	}
	
	@Test
	void test3() throws Exception {
		int elmaSayisi=1500;
		int mesafe=200;
		//ilk seferde 1000 tane taınır 200u yolda yenır kalan 500 un 200 u son seferde yine yolda yenir 400 yendi 1100 tasindi
		int beklenenSonuc=1100;
		int hesaplanan = mainService.calculateMaxTransportedApples(elmaSayisi, mesafe);
		Assertions.assertEquals(beklenenSonuc, hesaplanan);
	}
	
	@Test
	void test4() throws Exception {
		int elmaSayisi=1100;
		int mesafe=200;
		//ilk seferde 1000 tane taınır 200 u yolda yenir kalan 100 tanesinin tasinmasindan vaz gecilir(100 tane ile 200 km yol gidilemez)
		int beklenenSonuc=800;
		int hesaplanan = mainService.calculateMaxTransportedApples(elmaSayisi, mesafe);
		Assertions.assertEquals(beklenenSonuc, hesaplanan);
	}

	@Test
    public void mesefeAsimiHatasi(){

		int elmaSayisi=1500;
		int mesafe=1001;

        Executable executable = () -> mainService.calculateMaxTransportedApples(elmaSayisi, mesafe);

        Assertions.assertThrows(Exception.class, executable);
    }
	
	@Test
    public void tumElmalarYoldaYenirHatasi(){

		int elmaSayisi=400;
		int mesafe=500;

        Executable executable = () -> mainService.calculateMaxTransportedApples(elmaSayisi, mesafe);

        Assertions.assertThrows(Exception.class, executable);
    }
}
