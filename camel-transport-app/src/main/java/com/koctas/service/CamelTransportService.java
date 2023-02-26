package com.koctas.service;

import org.springframework.stereotype.Service;

@Service
public class CamelTransportService {

	public int calculateMaxTransportedApples(int elmaSayisi, int mesafe) throws Exception {

		// eger mesafe 1000 km den fazla ise deve 1 seferde 1000 den fazla elma
		// tasıyamadıgından tum elmaları yer o yuzden exception firlatmak gerekir
		if (mesafe >= 1000) {
			throw new Exception("Bir deve 1000 kilometreden fazla tasiyamaz");
		} else {
			// devenin yoll boyunca yiyecegi elma sayisi tasinacak elmadan fazla is exception
			// firlatilir
			if ((elmaSayisi - mesafe * 1) <= 0) {
				throw new Exception("Tasinacak tum elemalar deve tarafindan yenir");
			} else {
				// elma saysisi devenin bir seferde tasiyacagindan fazla ise sefer saysisi
				// hesaplanir
				if (elmaSayisi > 1000) {
					int seferSayisi = elmaSayisi / 1000;// son sefer haric sefer saysisi
					int kalanElmaAdedi = elmaSayisi - seferSayisi * mesafe * 1; // son sefer haric kalan elma sayisi
					int sonSefereKalanElmaAdedi = elmaSayisi % 1000;// son sefere kalan elma sayisi
					// Son sefere kalan elma saysıs devenin yolda yiyecegi elma sayisindan fazla ise
					// son sefere cikilir
					if (sonSefereKalanElmaAdedi != 0 && (sonSefereKalanElmaAdedi - mesafe * 1) >= 0) {
						return kalanElmaAdedi - mesafe * 1;
						// Son sefere kalan elma saysıs devenin yolda yiyecegi elma sayisindan az ise
						// son seferden vaz gecilir
					} else if (sonSefereKalanElmaAdedi != 0 && (sonSefereKalanElmaAdedi - mesafe * 1) <= 0) {
						return kalanElmaAdedi - sonSefereKalanElmaAdedi;
						// eger elma adedi 1000 in tam katlari ise asagisi calisir
					} else {
						return kalanElmaAdedi;
					}

				} else {
					// elma sayisi 1000den az ise tek seferde tum elmalar tainir
					return elmaSayisi - mesafe * 1;
				}

			}
		}
	}

}
