package module_agenda;

/**
 * 
 * @author Valentin
 *
 */

import java.util.Date;

public class SeanceSport extends Evenement {
	
	private double duree;

	public double getDuree() {
		return duree;
	}

	public void setDuree(double duree) {
		this.duree = duree;
	}

	public SeanceSport (Date date, Heure heure, double duree, String Commentaire){
		super(date, Commentaire, heure);
		this.duree = duree ;
		
	}
	
}
