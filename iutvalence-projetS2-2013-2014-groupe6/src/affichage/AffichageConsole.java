package affichage;
/**
 * @author geourjoa
 *
 */
public class AffichageConsole implements Affichage
{
	@Override
	public void afficherLeNomDeLApplication()
	{
		System.out.println("Le couteau suisse de l'etudiant :\n\n");
	}

	@Override
	public void afficherLeMenu()
	{

		System.out.println("Menu principal : \n\nModule Gestion de frigo : \n1-Inserer un aliment au frigo, \n2-Supprimer un aliment du frigo, \n3-Afficher les aliments périmés\n4-Supprimer les aliments perimés, \n5-Afficher le frigo\n0-Quitter.\n");

	}

	@Override
	public void demanderUnChoix()
	{
		System.out.println("Veuillez saisir votre choix :");

	}

		
	@Override
	public void demanderUnAliment()
	{
		System.out.println("Saisissez un aliment sous la forme d'un nom, puis d'une date (format: jj-mm-aaaa), une quantite et un prix unitaire.");
		
	}
	
	
	@Override
	public void demanderUneRecette()
	{
		System.out.println("Saisissez une recette sous la forme d'un nom puis un nombre d'aliment. Ensuite saisissez les aliments sous cette forme : (un nom, une date (format: jj-mm-aaaa), une quantite, et un prix.");
		
	}
	
	@Override
	public void demanderUnNom()
	{
		System.out.println("Saisissez un nom :");
		
	}
}
