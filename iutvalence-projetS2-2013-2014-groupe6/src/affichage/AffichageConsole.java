package affichage;

import java.util.Hashtable;

import module_alimentation.Frigo;
import module_alimentation.Recette;
import module_budget.Budget;
import module_budget.Etat;

/**
 * @author geourjoa 
 * 
 */
public class AffichageConsole implements Affichage
{
	@Override
	public void afficherLeNomDeLApplication()
	{
		System.out.println("*****************************************\n" + "   Le couteau suisse de l'etudiant :\n"
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
						+ "\n3-Afficher les aliments périmés\n4-Supprimer les aliments perimés, \n5-Afficher le frigo,"
						+ "\n6-Afficher les recettes disponibles,\n7-Afficher les recettes en m�moires,\n8-Saisissez une recette,\n9-Changez la quantit� de nourriture,\n10-Afficher la valeur du contenu du frigo\n0-Quitter.\n");

	}

	@Override
	public void demanderUnInt()
	{
		System.out.println("Veuillez saisir votre choix :");

	}

	@Override
	public void demanderUnAliment()
	{
		System.out.println("Saisissez un aliment sous la forme d'un nom, une quantite puis le prix.");

	}

	@Override
	public void demanderUneRecette()
	{
		System.out
				.println("Saisissez une recette sous la forme d'un nom, le nombre d'aliment puis saisissez les aliments sous la forme (nom puis quantite :");

	}

	@Override
	public void demanderUneChaineDeCaractere()
	{
		System.out.println("Saisissez un nom :\n");

	}

	@Override
	public void messageDErreur()
	{
		System.out.println("Cette fonction n'est pas disponible pour l'instant.\n");
	}

	@Override
	public void afficherMenuPrincipal()
	{
		System.out.println("==========================\n" + "     Menu principal : \n" + "==========================\n"
				+ "\n1-Module alimentation, \n2-Module scolaire, \n3-Module agenda, \n4-Module budget\n0-Quitter.\n");

	}

	@Override
	public void afficherUnFrigo(Frigo leFrigo)
	{
		System.out.println(leFrigo);
	}

	@Override
	public void notifierActionReussie()
	{
		System.out.println("Op�ration effectu�e avec succes. \n\n");
	}

	@Override
	public void afficherDesRecettes(Hashtable<String, Recette> recetteDisponible)
	{
		if (recetteDisponible.isEmpty())
			System.out.println("Il n'y a pas de recette � afficher.\n");
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

	@Override
	public void afficherMenuAgenda()
	{
		System.out.println("===========================\n" + " Module Gestion agenda :\n"
				+ "===========================\n" + " \n1-Ajouter un �venement, \n2-Supprimer un evenement, "
				+ "\n0-Quitter.\n");

	}

	@Override
	public void demanderUnEvenement()
	{
		System.out.println("Saisissez un �venement (date, nom, commentaire, heure debut, heure fin):\n");

	}

	@Override
	public void demanderUneDate()
	{
		System.out.println("Saisissez une date sous la forme jj-mm-aaaa : \n");

	}

	@Override
	public void demanderUneMatiere()
	{
		System.out.println("Saisissez une mati�re, saisissez le nom puis le coefficient : \n");
	}

	@Override
	public void demanderUneNote()
	{
		System.out
				.println("Saisissez une note, entrez la date de la note, puis votre resultat, son coefficient et enfin un commentaire sur la note : \n");

	}

	@Override
	public void demanderUneUE()
	{
		System.out.println("Saisissez une UE, saisissez le nom puis le coefficient : \n");
	}
	
	@Override
	public void afficherMenuScolaire()
	{
		System.out.println("===========================\n"
				+ " Module Gestion scolaire :\n"
				+ "===========================\n"
				+ " \n1-Inserer une UE, \n2-Supprimer une UE, "
				+ "\n3-Inserer une mati�re\n4-Supprimer une mati�re, \n5-Inserer une note,"
				+ "\n6-Supprimer une note,\n7-Calcul de la moyenne,,\n0-Quitter.\n");	
	}
	
	@Override
	public void notifierEchec()
	{
		System.out.println("Echec de l'op�ration.");
	}
	
	@Override
	public void afficherLaMoyenne(float moyenneDeLEtudiant)
	{
		if (moyenneDeLEtudiant==-1)
			System.out.println("Vous n'avez pas de note enregistr�e.");
		else
			System.out.println("Votre moyenne est de " + moyenneDeLEtudiant + ".");		
	}
	
	@Override
	public void notifierArretApplication()
	{
		System.out.println("Application termin�e.");
	}
	
	@Override
	public void demanderUneQuantiteDAlimentAEnlever()
	{
		System.out.println("Saisissez le nom puis la quantite d'aliment � changer (-1 enleve un aliment, 2 en ajoute 2):");
		
	}
	
	@Override
	public void afficherPrixDuFrigo(Integer prixDuFrigo)
	{
		System.out.println("L'ensemble des aliments du frigo vaut " + prixDuFrigo + " euro(s).\n");
		
	}
	
	
	public void afficherMenuBudget()
	{
		System.out.println("===========================\n"
				+ " Module Gestion BUDGET :\n"
				+ "===========================\n"
				+ " \n1-Initialiser le budget, \n2-Afficher le solde du budget, "
				+ "\n3-ajouter de l'argent, \n4-Retirer de l'argent, "
				+ "\n0-Quitter.\n");
	}

	@Override
	public void demanderSommeDArgent() {
		System.out.println("Saisissez une somme d'argent pour initialiser votre budget: ");
	}
	
	public void afficherLeSoldeDuBudget(float soldeBudget){
		System.out.println("Le solde du budget est de " + soldeBudget + " euro(s).\n");
	}

	@Override
	public void afficherDemandeAjoutArgent() {
		System.out.println("Saisissez la somme que vous voulez ajouter � votre solde");
	}

	@Override
	public void afficherDemandeRetraitArgent() {
		System.out.println("Saisissez la somme que vous voulez soustraitre � votre solde");
		
	}

	@Override
	public void afficherLEtatDuBudget(Etat etat) {
	}

	@Override
	public void demanderUnChoix() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void demanderUnNomDeRecette() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afficherUneRecette(Recette recetteAAfficher) {
		// TODO Auto-generated method stub
		
	}

	

	
	
}
