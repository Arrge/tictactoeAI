#viikkoraportti 4

#tuntikirjanpito

##keskiviikko 28.9: 1h
suunnittelua

##torstai 29.9: 3h
GUI:n säätelyä, koodin siistimistä ja parantelua

##perjantai 30.9: 4h
ensimmäinen versio tulevien siirtojen laskemisesta ja häröjen bugien korjaamista

##lauantai 31.9: 4h
debuggausta, outojen bugien syynä se, että kutsuin rekursiivista funktiota getFutureMoves(iteration++), eli funktio kutsutaan vielä vanhalla iteraatio arvolla jonka seurauksena syntyi paljon 'käsittämättömiä' bugeja joita yritin korjailla tuhlaten monta tuntia aikaa tässä parin päivän aikana. AI osaa nyt ottaa huomioon jopa seuraavat 7 siirtoa. ei jäänyt aikaa säädellä rankki systeemin eri tapausten arvoja, eli voi olla, että esim 6 ja 7 siirto eteenpäin arvioivat AI:t antavat aina saman arvon.


ensiviikolla rankkisysteemin hiomista, oma maxheap, dokumentaatiota jne. 