public class AffichageConsole implements Affichage
{
	@Override
	public void afficherLeNomDeLApplication()
	{
		System.out.println("Le couteau suisse de l'�tudiant :\n\n");
	}

	@Override
	public void afficherLeMenu()
	{

		System.out.println("Menu principal : \n\n1-Module Frigo, \n0-Quitter.\n");

	}

	@Override
	public void demanderUnChoix()
	{
		System.out.println("Veuillez saisir votre choix :");

	}
	
	@Override
	public void afficherSousMenu()
	{
		System.out
		.println("Module Gestion de frigo : \n1-Inserer un aliment au frigo, \n2-Supprimer un aliment du frigo, \n3-Afficher les aliments p�rim�s\n4-Supprimer les aliments perim�s, \n5-Afficher le frigo\n0-Menu prinicpal");

		
	}
}
