package module_agenda;
import java.util.Date;

import javax.xml.soap.Text;
/**
 * 
 * @author Valentin
 *
 */

public abstract class Evenement {
	
	protected Date dateEvenement ;
	
	protected String commentaireEvenement ;
	
	protected Heure heureEvenement ;
	
	public Evenement(Date date, String commentaire, Heure heure) {
		this.dateEvenement = date ;
		this.commentaireEvenement = commentaire ;
		this.heureEvenement = heure ;
		
	}
	
	public String getCommentaireEvenement(){
		return commentaireEvenement;
	}
	
	public void setCommentaireEvenement(String commentaire){
		this.commentaireEvenement = commentaire ;
	}

}
