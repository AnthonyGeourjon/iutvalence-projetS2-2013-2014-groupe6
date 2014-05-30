package module_budget;
/**
 * 
 * @author Valentin
 *
 */


public class Budget {
	
	private float solde ;
	private Etat etat ;
	
	public Budget(float solde, Etat etat){
		this.solde = solde ;
		this.etat = etat ;
	}
	
	public float getSolde() {
		return solde;
	}
	
	
	public void setSolde(float solde) {
		this.solde = solde;
	}
	
	
	public Etat getEtat() {
		return etat;
	}
	
	
	public void setEtat(Etat etat) {
		this.etat = etat;
	}

	public void ajouterDeLArgent(float sommeDArgent) {
		this.solde += sommeDArgent ;
	}

	public void soustraireDeLArgent(float sommeDArgent) {
		this.solde -= sommeDArgent ;	
	}


}
