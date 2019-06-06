/*
 *  
  Scenario: document inkomend registreren voor medewerker 'Tester Een' en Tester Twee' en teams 'Administratie Applicaties' en 'Administratie Belastingen'
   Given: gebruiker bevindt zich in scherm 'een nieuwe zaak starten na registreren D-zaak
   When: gebruiker gaat naar tab 'mijn zaken'
   Then: werkvoorraad wordt geopend
   When: gebruiker selecteert de rol 'Drie Tester'
   Then: zaken op rol 'Drie Tester' worden getoond
   When: gebruiker zoekt testzaak door de tekst 'test kopie aan' in te vullen in de kolom 'betreft'
   Then: zoekresultaten worden getoond
   When: gebruiker selecteert zaak onder kopje 'Registreren'
   Then: zaak wordt geopend
   When: gebruiker typt in tekstvak 'Vermoedelijk zaaktype:' de tekst 'beleid'
   And: gebruiker drukt op enter
   Then: opties worden getoond in drop-down menu
   When: gebruiker selecteert de optie 'Beleid'
   And: gebruiker selecteert bij de vraag 'Kopie is voor:' het vakje 'Team'
   Then: tekstvak 'Kopie aan team:' verschijnt
   When: gebruiker klikt op pijltje rechts in het tekstvak
   Then: mogelijkheden verschijnen in drop-down menu
   When: gebruiker selecteert 'Administratie Applicaties' en 'Administratie Advies en Projecten'
   When: gebruiker selecteert bij de vraag 'Kopie is voor:' het vakje 'Medewerker'
   Then: tekstvak 'Kopie aan medewerker:' verschijnt
   When: gebruiker voert de tekst 'tester' in
   Then: opties worden getoond in drop-down menu
   When: gebruiker selecteert de opties 'Een Tester' 
   And: gebruiker herhaalt invoeren tekst 'tester' en selecteert 'Twee Tester'
   And: gebruiker klikt op knop 'volgende fase' links bovenin
   Then: pop-up met de tekst 'Naar fase CONTROLEREN' wordt getoond
   When: gebruiker klikt op 'Ja'
   Then: zaak gaat door naar fase Controleren, dit is te zien aan het groene vinkje dat verschijnt naast 'Beoordelen' links bovenin
   When: gebruiker klikt op 'volgende fase'
   Then: pop-up wordt getoond met titel 'Naar fase AFGEHANDELD'
   When: gebruiker klikt op 'OK'
   Then: zaak wordt afgesloten 
   And: gebruiker komt terecht in werkvoorraad van rol 'Drie Tester'
   And: zaak met 'betreft' 'test kopie aan' is zichtbaar onder het kopje 'Afgehandeld'
 * 
 * * 
 */

package Belastingen;

public class TC_ScenarioDocumentInkomendRegistrerenVoorMedewerkerTesterEenenTesterTweeEnTeamsAdministratieApplicatiesEnAdministratieBelastingen {

	public static void main(String[] args) {
	

	}

}
