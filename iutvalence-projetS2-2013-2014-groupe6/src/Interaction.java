
/**
 * @author Anthony
 * Dans cette classe, je compte mettre tout nos moyens d'interaction par la console avec l'utilisateur
 */
public interface Interaction
{
	public abstract int choixNumerique();
	
	public abstract Aliment saisirUnAliment();

	public abstract Recette demanderUneRecette();
	
}
