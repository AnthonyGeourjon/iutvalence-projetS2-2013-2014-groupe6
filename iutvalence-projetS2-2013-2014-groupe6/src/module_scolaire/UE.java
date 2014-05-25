package module_scolaire;

import java.util.Hashtable;

/**
 * @author Anthony
 * 
 */
public class UE
{

	/**
	 * Moyenne de l'ue
	 */
	private float moyenneDeLUE;

	/**
	 * Nom de l'ue
	 */
	private String nom;

	/**
	 * Coefficient de l'ue
	 */
	private float coeffient;

	/**
	 * Ensemble des matieres
	 */
	private Hashtable<String , Matiere> lesMatieresDeLUE;

	public UE(float moyenneDeLUE, String nom, float coeff)
	{
		super();
		this.moyenneDeLUE = moyenneDeLUE;
		this.nom = nom;
		this.coeffient = coeff;
		this.lesMatieresDeLUE = new Matiere[NOMBRE_MAX_DUE];
		this.nombreDeMatiere = 0;
	}

}
