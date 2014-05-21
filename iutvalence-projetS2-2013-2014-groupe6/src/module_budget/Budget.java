package module_budget;
/**
 * @author Valentin
 */

import java.util.Scanner;


public class Budget {
	
	private float solde ;
	private Etat etat ;
	
	
	public Budget(float solde){
		this.solde = solde ;
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
	
	
	// Est ce vraiment utile en sachant que il y a deja le Setter ??
	public void initialiserBudget(float soldeDepart){
		this.solde = soldeDepart ;
	}
	
	public void ajouterOuSoustraireArgentAuSolde(float sommeArgent){
		this.solde += sommeArgent ;
	}
}
