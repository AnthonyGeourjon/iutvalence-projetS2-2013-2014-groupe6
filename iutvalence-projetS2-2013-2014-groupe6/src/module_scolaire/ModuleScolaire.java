package module_scolaire;

import java.util.Hashtable;

/**
 * @author Anthony
 *	Regroupe tout le module de gestion note
 */
public class ModuleScolaire
{
	/**
	 * Les UEs de l'étudiant
	 */
	private Hashtable<String, UE> lesUEs;
	
	/**
	 * Moyenne de l'etudiant
	 */
	private int moyenneDeLEtudiant;
	
	/**
	 * Constructeur
	 */
	public ModuleScolaire()
	{
		this.lesUEs= new Hashtable<>();	
	}
	
	//TODO INSERER UNE NOTE, SUP UNE NOTE
}
