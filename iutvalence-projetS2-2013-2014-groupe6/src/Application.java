import general.CouteauSuisse;
import interaction.InteractionClavier;
import affichage.AffichageConsole;
import module_alimentation.Aliment;

/**
 * @author geourjoa
 *
 */
public class Application {

	@SuppressWarnings("javadoc")
	public static void main(String[] args) {
		
		//TODO Trouver méthode plus propre pour initialiser un attribut de classe dans tous les cas, utilisation de sentinnelle au lieu de nombre d'élément
		
		Aliment.initialiserTableauEnsembleDesAlimentsConnus();
		
		CouteauSuisse unCouteauSuisse = new CouteauSuisse(new InteractionClavier(),new AffichageConsole());
		
		
		unCouteauSuisse.utiliserLeCouteauSuisse();

	}

}
