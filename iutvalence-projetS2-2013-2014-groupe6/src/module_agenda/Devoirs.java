package module_agenda;

import java.util.Date;

public class Devoirs {
	
	private Matieres matiere ;
	private String descriptionDuDevoir ;
	private Date datePourRendreLeDevoir ;
	
	
	public Matieres getMatiere() {
		return matiere;
	}
	
	
	public void setMatiere(Matieres matiere) {
		this.matiere = matiere;
	}
	
	
	public String getDevoirAFAire() {
		return descriptionDuDevoir;
	}

	
	public Date getDatePourRendreLeDevoir() {
		return datePourRendreLeDevoir;
	}


	public void setDatePourRendreLeDevoir(Date datePourRendreLeDevoir) {
		this.datePourRendreLeDevoir = datePourRendreLeDevoir;
	}
	
	
	public void setDevoirAFAire(String devoirAFAire) {
		this.descriptionDuDevoir = devoirAFAire;
	}
	
	
	public Devoirs(Matieres matiere, String description, Date delaiRenduDevoir){
		this.matiere = matiere ;
		this.descriptionDuDevoir = description ;
		this.datePourRendreLeDevoir = delaiRenduDevoir ;
	}


}
