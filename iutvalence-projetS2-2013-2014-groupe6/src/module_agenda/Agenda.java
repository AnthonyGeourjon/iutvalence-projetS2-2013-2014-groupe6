package module_agenda;

import java.util.Date;


/**
 * 
 * @author Valentin
 *
 */

public abstract class Agenda {

	private Evenement ensembleEvenements[];
	
	private static int NB_MAX_EVENEMENTS = 50 ;
	
	private static int nombreDEvenements ;
	
	
	public	Agenda(){
		
	}
	
	
	public void insererEvenementDansLAgenda(Evenement unEvenement){
		this.ensembleEvenements[nombreDEvenements] = unEvenement ;
		nombreDEvenements++ ;
	}
	
	
	public void modifierEvenementDate(Date dateARechercher, int annee, int mois, int jour){
		for(int i = 0; i<nombreDEvenements; i++){

			if(this.ensembleEvenements[i].dateEvenement == dateARechercher){

				this.ensembleEvenements[i].dateEvenement.setYear(annee);
				this.ensembleEvenements[i].dateEvenement.setMonth(mois);
				this.ensembleEvenements[i].dateEvenement.setDate(jour);
			
			}
		}
	}
	
	
	public void modifierEvenementHeure(Date dateARechercher, int heure, int minute){
		for(int i = 0; i<nombreDEvenements; i++){
			
			if(this.ensembleEvenements[i].dateEvenement == dateARechercher){
				this.ensembleEvenements[i].heureEvenement.setHeure(heure);
				this.ensembleEvenements[i].heureEvenement.setMinute(minute);
			}
		}
	}
	
	
	public void modifierEvenementCommentaire(Date dateARechercher, String commentaireAModifier){
		for(int i = 0; i<nombreDEvenements; i++){
			
			if(this.ensembleEvenements[i].dateEvenement == dateARechercher){
				this.ensembleEvenements[i].setCommentaireEvenement(commentaireAModifier);
			}
		}
	}
	
}
