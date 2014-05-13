public class Application {

	public static void main(String[] args) {
		
		couteauSuisse unCouteauSuisse = new couteauSuisse(new InteractionClavier(),new AffichageConsole(), new Frigo());
		
		
		unCouteauSuisse.utiliserLeCouteauSuisse();

	}

}
