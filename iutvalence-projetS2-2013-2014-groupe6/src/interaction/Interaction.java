package interaction;
import module_alimentation.Aliment;
import module_alimentation.Recette;


/**
 * @author Anthony
 * Dans cette classe, je compte mettre tout nos moyens d'interaction par la console avec l'utilisateur
 */
public interface Interaction
{
	public static final String ERREUR_1 = "Nous n'avons pas pu ajouter cet aliment car le nombre max d'aliment à été atteint";
	
	public static final String ERREUR_2 = "Nous n'avons pas pu ajouter cette recette car le nombre max de recette à été eteint à été atteint";
	
	public abstract int choixNumerique();
	
	public abstract Aliment saisirUnAliment();

	public abstract Recette demanderUneRecette();
	
}
