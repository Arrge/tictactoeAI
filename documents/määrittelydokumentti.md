#määrittelydokumentti

##Aihe
Tekoäly laajennetulle risti-nollalle. Ainakin näin alustavasti 15x15 kokoisella ruudukolla ja voittoehtona 5 ristiä/nollaa vierekkäin.

##Algoritmit & tietorakenteet
Toteutetaan minimax tyylinen algoritmi, joka määrittää arvon jokaiselle siirtomahdollisuudelle, jonka perusteella valitaan paras siirto. tietorakenteena puu, joka sisältää mahdolliset siirrot ja siirtoja seuraavat siirrot jne.

##Ongelma
Ongelmana on luoda kriteerit, joiden perusteella voidaan tarpeeksi nopeasti määrittää arvot mahdollisille siirroille.

Kriteereinä voi olla esimerkiksi:
- Kuinka monta mahdollista jatkosiirtoa kyseinen siirto luo. Esimerkiksi nurkkaan laitettu ruksi luo vähemmän jatkosiirtomahdollisuuksia, kuin ruudukon keskelle laitettu ruksi.
- Kuinka monta vastustajan jatkosiirtoa kyseinen siirto estää.
- johtaako siirron tekemättä jättäminen häviöön.

##syöte
Ohjelmalla tulee olemaan simppeli graafinen käyttöliittymä, joka sisältää ruudukon. Ruutua klikkaamalla voi siihen sijoittaa ristin/nollan, jonka jälkeen tekoäly tekee oman siirtonsa. vaihtoehtoisesti voi myös laittaa tekoälyn pelaamaan itseään vastaan.

##aikavaativuudet
Aikavaativuus tulee luultavasti olemaan O(n), nykyisen pelilaudan siirtojen arvojen määrittämiseen. Tämän jälkeen voi tehokkuudesta riippuen tarkentaa parhaiden siirtojen arvoja laskemalla myös kuinka hyviä siirtoja on mahdollista suorittaa kyseisen siirron jälkeen jne. määrättyyn aikarajaan asti.

##lähteet
https://en.wikipedia.org/wiki/Minimax