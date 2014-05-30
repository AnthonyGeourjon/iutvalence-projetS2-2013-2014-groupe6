package affichage;

import java.util.Hashtable;

import module_alimentation.Frigo;
import module_alimentation.Recette;
import module_budget.Etat;

/**
 * @author geourjoa
 *
 */
public interface Affichage
{
	
	/**
	 * Afficher le menu
	 */
	public abstract void afficherMenuAlimentation();
	
	/**
	 * Demander un choix num�rique
	 */
	public abstract void demanderUnChoix();
	
	/**
	 * Afficher le nom de l'application
	 */
	public abstract void afficherLeNomDeLApplication();
	
	/**
	 * Demander un aliment
	 */
	public abstract void demanderUnAliment();

	/**
	 * Demander une recette
	 */
	public abstract void demanderUneRecette();

	/**
	 * Demander un nom
	 */
	public abstract void demanderUneChaineDeCaractere();

	/**
	 * Dire � l'utilisateur qu'une fonction n'est pas disponible
	 */
	public abstract void messageDErreur();
	
	/**
	 * Afficher le menu principal
	 */
	public abstract void afficherMenuPrincipal();

	/**
	 * @param leFrigo Le frigo qui sera affich�
	 */
	public abstract void afficherUnFrigo(Frigo leFrigo);
	
	/**
	 * Montrer � l'utilisateur que l'action s'est bien d�roul�e
	 */
	public abstract void notifierActionReussie();

	/**
	 * @param recette affiche les recettes fournies en param�tres
	 */
	public abstract void afficherDesRecettes(Hashtable<String, Recette> recette);

	/**
	 * Demander � l'utilisateur un �venement
	 */
	public abstract void demanderUnEvenement();

	/**
	 * Affiche le menu du module agenda
	 */
	public abstract void afficherMenuAgenda();

	/**
	 * Demander une date � l'utilisateur
	 */
	public abstract void demanderUneDate();

	/**
	 * Demander une UE � l'utilisateur
	 */
	public abstract void demanderUneUE();

	/**
	 * Demander une mati�re � l'utilisateur
	 */
	public abstract void demanderUneMatiere();

	/**
	 * Demander une note � l'utilisateur
	 */
	public abstract void demanderUneNote();

	/**
	 * Affiche le menu du module scolaire
	 */
	public abstract void afficherMenuScolaire();

	/**
	 * Montrez � l'utilisateur que l'action � echou�
	 */
	public abstract void notifierEchec();

	/**
	 * @param moyenneDeLEtudiant moyenne � afficher
	 */
	public abstract void afficherLaMoyenne(float moyenneDeLEtudiant);

	/**
	 * Montrer � l'utilisateur que l'application se termine
	 */
	public abstract void notifierArretApplication();

	/**
	 * Demander un nom d'aliment et une quantite � supprimer 
	 */
	public abstract void demanderUneQuantiteDAlimentAEnlever();

	/**
	 * @param prixDuFrigo prix a afficher
	 */
	public abstract void afficherPrixDuFrigo(Integer prixDuFrigo);


	public abstract void afficherMenuBudget();

	public abstract void demanderSommeDArgent();

	public abstract void afficherLeSoldeDuBudget(float soldeBudget);

	public abstract void afficherDemandeAjoutArgent();

	public abstract void afficherDemandeRetraitArgent();

	public abstract void afficherLEtatDuBudget(Etat etat);

	
	

	public abstract void demanderUnInt();


	/**
	 * Demander un nom de recette � l'utilisateur 
	 */
	public abstract void demanderUnNomDeRecette();

	/**
	 * @param recetteAAfficher recette qui sera affich�e
	 */
	public abstract void afficherUneRecette(Recette recetteAAfficher);	
}
