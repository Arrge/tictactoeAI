# Ohjelman rakenne

## Pelilauta
Pelilaudan tila on tallennettuna GridValues objektiin, joka sisältää (sivu * sivu) kokoisen arrayn, jossa 0 = tyhjä, 1 = ruksi ja 2 = ympyrä.

Graafinen käyttöliittymä koostuu GUI ja Grid luokasta. Grid luokka on jpanel, johon piirretään pelilauta GridValues objektiin talletettujen siirtojen perusteella. GUI luokka on koko peli-ikkuna ja sisältää Grid luokan.

## Tekoäly
Tekoäly antaa arvot mahdollisille siirroille, jonka jälkeen valitaan korkea-arvoisin siirto. Arvon laskemiseen tarvittava informaatio haetaan pelilaudasta BoardScanner-luokkaa apuna käyttäen ja talletetaan SpaceRank luokkaan.
SpaceRank objektit talletetaan max-heappiin, jota kutsutaan RankedGrid-luokan kautta.

### BoardScanner-luokka
BoardScannerille annetaan koordinaatti, GridValues objekti, sekä merkki (ruksi/ympyrä). BoardScanner tarkistaa koordinaatista pysty-, vaaka- ja vinosuunnassa peräkkäisten merkkien määrän, sekä montako avointa ruutua on peräkkäisten merkkien jälkeen (0 - 2). Tämä informaatio tallennetaan SpaceRank objektiin. Sama toistetaan vastustajan merkkiä käyttäen. Lopuksi palautetaan SpaceRank objekti.

### SpaceRank-luokka
SpaceRank-luokka sisältää calculateRank() ja calculateOpponentsRank() metodit, jotka laskevat talletetun informaation perusteella arvon siirrolle. 
- 48 pistettä: 4 peräkkäistä merkkiä koordinaatin vieressä (siirto voittaa pelin).
- 36 pistettä: 3 peräkkäistä merkkiä ja 2 avointa sivua (siirron jälkeinen siirto voittaa pelin).

Vastustajan siirtoarvoa laskettaessa voittoon johtavien siirtojen pistemäärät ovat 75% edellämainituista.
- Muulloin arvoon lisätään peräkkäisten merkkien määrä kerrottuna avointen sivujen määrällä.

Arvoon lisätessä lisättävä luku kerrotaan myös kertoimella (tällä hetkellä 6)
### AI-luokka
Arvokkain siirto etsitään laskemalla siirroille arvot ensin nykyisen pelilaudan perusteella, jonka jälkeen valitaan maksimissaan 5 parasta siirtoa, joille jokaiselle lasketaan maksimissaan 5 parasta siirtoa jne. kunnes saavutaan maksimisyvyyteen ja palataan takaisin valiten aina arvokkain siirto.   


# aika- ja tilavaativuus
pöydän skannauksen ja arvojen laskemisen aikavaativuus on n. tulevia siirtoja laskettaessa valitaan enintään 5 parasta siirtoa, joten aika- ja tilavaativuus ovat isoimmillaan 5^n, jossa n on montako siirtoa eteenpäin lasketaan.

# mahdolliset puutteet ja parannusehdotukset
Tekoäly lopettaa kyseisen suunnan skannaamisen heti, kun vastaan tulee tyhjä ruutu. Eli jos skannattavan koordinaatin ja merkin sisältävän ruudun välissä on tyhjä ruutu, niin se vaikuttaa siiron arvoon vasta tulevia siirtoja laskettaessa.

0 pisteen arvoisia siirtoja (eli koordinaattia ei ympäröi yhtään merkkiä) ei oteta huomioon etsittäessä parasta siirtoa, vaikka kyseiset siirrot voisivat saada pisteitä tulevia siirtoja laskettaessa ja näin ollen ehkä saada jossain todella harvinaisessa tilanteessa isoimman arvon.