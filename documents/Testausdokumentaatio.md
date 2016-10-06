##Testausdokumentaatio

Laskiessa 7 siirtoa eteenpäin:

ensimmäinen siirto: ~1440 ms
toinen siirto: 		~1140 ms
kolmas siirto:		~800 ms

Tämän jälkeen aikaa menee 10-600 ms riippuen arvokkaiden siirtomahdollisuuksien määrästä. (keskimäärin ~250 ms)

Erot 7 ja 5 siirtoa eteenpäin laskevalla tekoälyllä on vaikeustasollisesti ja siirtojen eroavuuden mukaan mitätön, koska toteutuksellani 7 siirron päässä olevan siirron arvo on vain: arvo / (1 + 7 / 2), eli yleisesti: arvo / (1 + siirto / 2)

Esimerkiksi 5 siirtoa eteenpäin laskeva ensin aloittava tekoäly voittaa 7 siirtoa eteenpäin laskevan tekoälyn. 	


Laskiessa 5 siirtoa eteenpäin:

ensimmäinen siirto: ~90 ms
toinen siirto: 		~80 ms
kolmas siirto:		~60 ms

Tämän jälkeen aikaa menee 10-60 ms riippuen arvokkaiden siirtomahdollisuuksien määrästä. (keskimäärin ~25 ms)

pienemmillä syvyyksillä aikaa kuluu enään keskimäärin ~12 ms