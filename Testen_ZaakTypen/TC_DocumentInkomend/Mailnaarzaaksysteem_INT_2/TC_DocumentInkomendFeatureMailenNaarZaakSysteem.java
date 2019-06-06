/**
 * Testcase: Document inkomend

 Feature: splitsen van bijlagen in document inkomend
 Background: gebruiker heeft een mailaccount bij de gemeente Amstelveen
 Background: gebruiker is geautoriseerd voor de rol Behandelaar Document Inkomend
 
  Scenario: testbijlagen mailen naar zaaksysteem
   Given: gebruiker is ingelogd in mailaccount op Outlook
   And: drie testbijlagen zijn beschikbaar om te mailen
   When: gebruiker klikt op 'Nieuwe e-mail'
   Then: scherm om nieuwe mail op te stellen verschijnt
   When: gebruiker vult het vakje achter 'Aan:' met de tekst 'fu-inprocesacceptatie'
   And: gebruiker vult het vakje achter 'Onderwerp:' met de tekst 'Test splitsen bijlagen'
   And: gebruiker klikt op de button 'Bestand' bovenaan
   Then: scherm om bijlage te selecteren verschijnt
   When: gebruiker klikt links op de knop '(H:) informatiebeheer'
   And: gebruiker klikt op de map 'Beheer InProces 2.10'
   And: gebruiker klikt op de map 'Upgrade 2.13'
   And: gebruiker klikt op de map 'Tests'
   And: gebruiker selecteert middels ctrl-toets de bijlagen 'TEST bijlage', 'TEST bijlage 2' en 'TEST bijlage 3'
   And: gebruiker klikt op de knop 'Invoegen'
   Then: venster sluit zich
   And: bijlagen worden aan mail toegevoegd in het veld naast 'Bijgevoegd:'   
   When: gebruiker klikt op 'Verzenden'
   Then: mail venster sluit zich 
 */
package Mailnaarzaaksysteem_INT_2;

import java.io.IOException;

import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.MultiPartEmail;
/**
 * @author G5888
 *
 */
public abstract class TC_DocumentInkomendFeatureMailenNaarZaakSysteem extends Email{

	public static void main(String[] args) throws IOException, Exception {
	
		System.out.println("===============Start test====================");

        // Create the attachment
        EmailAttachment attachment = new EmailAttachment();
        EmailAttachment attachmentx = new EmailAttachment();
        EmailAttachment attachmenty = new EmailAttachment();
attachment.setPath("G:\\My pictures\\appel.jpg" );
attachmentx.setPath("G:\\My pictures\\aardbei.jpg" );
attachmenty.setPath("G:\\My pictures\\banaan.jpg" );
        attachment.setDisposition(EmailAttachment.ATTACHMENT);
        attachment.setDescription("fruit is gezond");
        attachment.setName("Testmail van Milton");


        // Create the email message
        MultiPartEmail email = new MultiPartEmail();
        email.setHostName("ASVEXC001.ad.amstelveen.nl ");
        email.addTo("m.nihora@amstelveen.nl", "Testmailmetattachment");
        email.setFrom("noreply@amstelveen.nl", "Me");
        email.setSubject("The picture");
        email.setMsg("Check this out: Testmailmetattachment ");

        // add the attachment
        email.attach(attachment);
        email.attach(attachmentx);
        email.attach(attachmenty);

        // send the email
        email.send();
        System.out.println("===============Email Sent====================");

		
			
		
		}
	}
	
		
		
			

       
                    
        
			
	