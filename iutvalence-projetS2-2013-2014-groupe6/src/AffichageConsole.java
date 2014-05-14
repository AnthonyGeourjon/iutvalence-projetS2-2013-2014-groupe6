public class AffichageConsole implements Affichage
{
	@Override
	public void afficherLeNomDeLApplication()
	{
		System.out.println("Le couteau suisse de l'étudiant :\n\n");
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
				.println("Module Gestion de frigo : \n1-Inserer un aliment au frigo, \n2-Supprimer un aliment du frigo, \n3-Afficher les aliments périmés\n4-Supprimer les aliments perimés, \n5-Afficher le frigo\n0-Menu prinicpal");

	}
	
	@Override
	public void demanderUnAliment()
	{
		System.out.println("Saisissez un aliment sous la forme d'un nom, puis d'une date (format: jj-mm-aaaa), une quantite et un prix.");
		
	}
}
