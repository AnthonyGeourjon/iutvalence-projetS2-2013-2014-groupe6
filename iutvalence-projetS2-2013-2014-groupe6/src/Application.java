import general.CouteauSuisse;
import interaction.InteractionClavier;
import affichage.AffichageConsole;

/**
 * @author geourjoa
 * 
 */
public class Application
{

	@SuppressWarnings("javadoc")
	public static void main(String[] args)
	{
		CouteauSuisse unCouteauSuisse = new CouteauSuisse(new InteractionClavier(), new AffichageConsole());

		unCouteauSuisse.utiliserLeCouteauSuisse();
	}

}
