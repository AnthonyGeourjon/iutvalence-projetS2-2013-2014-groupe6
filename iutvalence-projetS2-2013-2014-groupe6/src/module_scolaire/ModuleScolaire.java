package module_scolaire;

/**
 * @author Anthony
 *	Regroupe tout le module de gestion note
 */
public class ModuleScolaire
{
	private static final int NOMBRE_MAX_DE_MODULE = 4;

	/**
	 * Les UEs de l'étudiant
	 */
	private UE[] lesUEs;
	
	/**
	 * Le nombre d'UE de l'etudiant
	 */
	private int nombreDUEs;
	
	public ModuleScolaire()
	{
		this.lesUEs= new UE[NOMBRE_MAX_DE_MODULE];
		this.nombreDUEs=0;
	}
	
	
}
