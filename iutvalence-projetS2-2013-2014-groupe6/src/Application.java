import interaction.InteractionClavier;
import affichage.AffichageConsole;
import module_alimentation.Aliment;
import module_alimentation.Frigo;
import module_alimentation.Recette;

public class Application {

	public static void main(String[] args) {
		
		//TODO Trouver méthode plus propre pour initialiser un attribut de classe dans tous les cas.
		
		Aliment.initialiserTableauEnsembleDesAlimentsConnus();
		
		CouteauSuisse unCouteauSuisse = new CouteauSuisse(new InteractionClavier(),new AffichageConsole(), new Frigo());
		
		
		unCouteauSuisse.utiliserLeCouteauSuisse();

	}

}
