package affichage;

import java.util.Hashtable;

import module_alimentation.Frigo;
import module_alimentation.Recette;

/**
 * @author geourjoa
 * 
 */
public class AffichageConsole implements Affichage
{
	@Override
	public void afficherLeNomDeLApplication()
	{
		System.out.println("*****************************************\n"
				        + "   Le couteau suisse de l'etudiant :\n"
				        + "*****************************************\n");
	}

	@Override
	public void afficherMenuAlimentation()
	{

		System.out
				.println("===========================\n"
						+ " Module Gestion de frigo :\n"
						+ "===========================\n"
						+ " \n1-Inserer un aliment au frigo, \n2-Supprimer un aliment du frigo, "
						+ "\n3-Afficher les aliments pÃ©rimÃ©s\n4-Supprimer les aliments perimÃ©s, \n5-Afficher le frigo,"
						+ "\n6-Afficher les recettes disponibles,\n7-Afficher les recettes en mémoires,\n8-Saisissez une recette,\n0-Quitter.\n");

	}

	@Override
	public void demanderUnChoix()
	{
		System.out.println("Veuillez saisir votre choix :");

	}

	@Override
	public void demanderUnAliment()
	{
		System.out.println("Saisissez un aliment sous la forme d'un nom, puis d'une quantite.");

	}

	@Override
	public void demanderUneRecette()
	{
		System.out
				.println("Saisissez une recette sous la forme d'un nom, le nombre d'aliment puis saisissez les aliments sous la forme (nom puis quantite :");

	}

	@Override
	public void demanderUnNom()
	{
		System.out.println("Saisissez un nom :");

	}

	@Override
	public void messageDErreur()
	{
		System.out.println("Cette fonction n'est pas disponible pour l'instant.");
	}

	@Override
	public void afficherMenuPrincipal()
	{
		System.out.println("==========================\n"
				+ "     Menu principal : \n"
				+ "==========================\n"
				+ "\n1-Module alimentation");

	}

	@Override
	public void afficherUnFrigo(Frigo leFrigo)
	{
		System.out.println(leFrigo);
	}

	@Override
	public void notifierActionReussie()
	{
		System.out.println("Opération effectuée avec succes. \n\n");
	}

	@Override
	public void afficherDesRecettes(Hashtable<String, Recette> recetteDisponible)
	{
		if(recetteDisponible.isEmpty())
			System.out.println("Il n'y a pas de recette à afficher.\n");
		else
		{
			String affichage = "";

		for (Recette recetteCourante : recetteDisponible.values())
		{
			affichage += recetteCourante.toString() + ", ";
		}

		System.out.println(affichage + ".");
		}
		
		

	}
	

}
