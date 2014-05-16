public class Application {

	public static void main(String[] args) {
		
		CouteauSuisse unCouteauSuisse = new CouteauSuisse(new InteractionClavier(),new AffichageConsole(), new Frigo());
		
		
		unCouteauSuisse.utiliserLeCouteauSuisse();

	}

}
