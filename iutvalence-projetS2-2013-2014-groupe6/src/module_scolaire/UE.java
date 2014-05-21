package module_scolaire;
/**
 * @author Anthony
 *
 */
public class UE
{
	private static final int NOMBRE_MAX_DUE = 4;

	private float moyenneDeLUE;
	
	private String nom;
	
	private float coeff;
	
	private Matiere[] lesMatieresDeLUE;
	
	private int nombreDeMatiere;

	public UE(float moyenneDeLUE, String nom, float coeff)
	{
		super();
		this.moyenneDeLUE = moyenneDeLUE;
		this.nom = nom;
		this.coeff = coeff;
		this.lesMatieresDeLUE = new Matiere[NOMBRE_MAX_DUE];
		this.nombreDeMatiere=0;
	}
	
	
}
