package module_scolaire;

import interaction.Interaction;
import java.util.Date;
import java.util.Hashtable;
import affichage.Affichage;
import exception.ChoixIncorrectException;
import exception.MatiereDejaPresenteException;
import exception.MatiereNonPresenteException;
import exception.NoteDejaPresenteException;
import exception.NoteNonPresenteException;
import exception.UEDejaPresenteException;
import exception.UEInconnuException;
import general.Module;

//TODO Faire en sorte que l'affichage soit cohérent -> Stockage dans des variables lorsqu'il y a plusieurs choses à demander à l'utilisateur
/**
 * @author Anthony Regroupe tout le module de gestion note
 */
public class ModuleScolaire implements Module
{
	/**
	 * Les UEs de l'étudiant
	 */
	private Hashtable<String, UE> lesUEs;

	/**
	 * Moyenne de l'etudiant
	 */
	private float moyenneDeLEtudiant;

	/**
	 * Constructeur
	 */
	public ModuleScolaire()
	{
		this.lesUEs = new Hashtable<>();
	}

	/**
	 * @param uEAAjouter
	 *            ue a ajouter
	 * @throws UEDejaPresenteException
	 *             Levé si l'UE est déja presente
	 */
	public void ajouterUneUE(UE uEAAjouter) throws UEDejaPresenteException
	{
		if (!this.lesUEs.containsKey(uEAAjouter.obtenirNom()))
			this.lesUEs.put(uEAAjouter.obtenirNom(), uEAAjouter);
		else
			throw new UEDejaPresenteException();
	}

	/**
	 * @param nomUEAsupprimer
	 *            nom de l'ue a supprimer
	 * @throws MatiereNonPresenteException
	 *             levé si la matiere n'est pas trouvée
	 */
	public void supprimerUneUE(String nomUEAsupprimer) throws MatiereNonPresenteException
	{
		if (this.lesUEs.remove(nomUEAsupprimer) == null)
			throw new MatiereNonPresenteException();
		else
			this.mettreAJourLaMoyenne();
	}

	private void mettreAJourLaMoyenne()
	{
		float moyenne = 0;
		float sommeDesCoefficients = 0;
		int nombreUEInvalide = 0;

		for (UE uECourante : this.lesUEs.values())
		{
			if (uECourante.obtenirMoyenneDeLUE() != -1)
			{
				moyenne += uECourante.obtenirMoyenneDeLUE() * uECourante.obtenirCoefficient();
				sommeDesCoefficients += uECourante.obtenirCoefficient();
			}
			else
				nombreUEInvalide++;
		}

		if (moyenne == 0)
			this.moyenneDeLEtudiant=-1;
		else
			this.moyenneDeLEtudiant=((moyenne / sommeDesCoefficients) / (this.lesUEs.size() - nombreUEInvalide));
	}

	/**
	 * @param nomUE
	 * @param matiereAAjouter
	 * @throws MatiereDejaPresenteException
	 * @throws UEInconnuException
	 */
	public void insererUneMatiere(String nomUE, Matiere matiereAAjouter) throws MatiereDejaPresenteException,
			UEInconnuException
	{
		if (!this.lesUEs.containsKey(nomUE))
			throw new UEInconnuException();
		else
			this.lesUEs.get(nomUE).insererUneMatiere(matiereAAjouter);
	}

	/**
	 * @param nomMatiereASupprimer
	 *            nom de la matiere a supprimer
	 * @param nomUE
	 *            nom de l'UE qui contient la matiere
	 * @throws MatiereNonPresenteException
	 *             Lévé si matiere non trouvé
	 * @throws UEInconnuException
	 *             Levé si l'UE est inconnu
	 */
	public void supprimerUneMatiere(String nomMatiereASupprimer, String nomUE) throws MatiereNonPresenteException,
			UEInconnuException
	{
		if (this.lesUEs.containsKey(nomUE))
			this.lesUEs.get(nomUE).supprimerUneMatiere(nomMatiereASupprimer);
		else
			throw new UEInconnuException();
	}
	
	/**
	 * @param nomUE nom de L'UE auquelle sera ajouté la note
	 * @param nomMatiere nom de la matiere auquelle sera ajouté la note
	 * @param noteAAjouter note qui sera ajoutée
	 * @throws UEInconnuException levé si l'UE est inconnu
	 * @throws NoteDejaPresenteException  levé si une note est deja presente à ce jour la
	 */
	public void insererUneNote(String nomUE, String nomMatiere, Note noteAAjouter) throws UEInconnuException, NoteDejaPresenteException
	{
		if (this.lesUEs.containsKey(nomUE))
			this.lesUEs.get(nomUE).insererUneNote(nomMatiere, noteAAjouter);
		else						
			throw new UEInconnuException();
	}
	
	/**
	 * @param nomUE nom de l'UE auquelle on supprimera une note
	 * @param nomMatiere nom de la matiere auquelle on supprimera une note
	 * @param dateNoteASupprimer date de la note a supprimer
	 * @throws NoteNonPresenteException levé si la note n'existe pas
	 * @throws UEInconnuException levé si l'UE est inconnu
	 */
	public void supprimerUneNote(String nomUE, String nomMatiere, Date dateNoteASupprimer) throws NoteNonPresenteException, UEInconnuException
	{
		if (this.lesUEs.containsKey(nomUE))
			this.lesUEs.get(nomUE).supprimerUneNote(nomMatiere, dateNoteASupprimer);
		else						
			throw new UEInconnuException();
	}

	/**
	 * @return la moyenne de l'étudiant
	 */
	public float obtenirMoyenneDeLEtudiant()
	{
		this.mettreAJourLaMoyenne();
		return this.moyenneDeLEtudiant;
	}
	
	@Override
	public void utiliserModule(Affichage affichageUtilise, Interaction interactionUtilise)
	{
		Boolean application = true;

		while (application)
		{
			affichageUtilise.afficherMenuAlimentation();

			switch (interactionUtilise.demanderUnInt())
			{
			case 0:
				application = false;
				break;
			case 1:
				affichageUtilise.demanderUneUE();
				try
				{
					this.ajouterUneUE(interactionUtilise.demanderUneUE());
				}
				catch (UEDejaPresenteException e1)
				{
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				break;
			case 2:
				affichageUtilise.demanderUneChaineDeCaractere();
				try
				{
					this.supprimerUneUE(interactionUtilise.demanderUneChaineDeCaractere());
				}
				catch (MatiereNonPresenteException e1)
				{
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}				
			case 3:
				affichageUtilise.demanderUneChaineDeCaractere();
				affichageUtilise.demanderUneMatiere();
				try
				{
					this.insererUneMatiere(interactionUtilise.demanderUneChaineDeCaractere(), interactionUtilise.demanderUneMatiere());
				}
				catch (MatiereDejaPresenteException | UEInconnuException e1)
				{
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			case 4 :
				affichageUtilise.demanderUneChaineDeCaractere();
				try
				{
					this.supprimerUneMatiere(interactionUtilise.demanderUneChaineDeCaractere(), interactionUtilise.demanderUneChaineDeCaractere());
				}
				catch (MatiereNonPresenteException | UEInconnuException e1)
				{
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			case 4 :
				affichageUtilise.demanderUneChaineDeCaractere();
				affichageUtilise.demanderUneChaineDeCaractere();
				affichageUtilise.demanderUneNote();
				this.insererUneNote(interactionUtilise.demanderUneChaineDeCaractere(), interactionUtilise.demanderUneChaineDeCaractere(), interactionUtilise.demanderUneNote());
				
			
			default:
				try
				{
					throw new ChoixIncorrectException();

				}
				catch (ChoixIncorrectException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		}

		
	}


	
	
}
