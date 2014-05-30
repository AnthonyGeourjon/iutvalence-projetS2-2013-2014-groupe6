//TODO Faire en sorte que les méthodes renvois toujours un truc potable

package interaction;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Hashtable;
import java.util.Scanner;

import exception.HeureIncorrecteException;
import exception.MatiereSaisieIncorrecteException;
import exception.NoteSaisieIncorrecteException;
import exception.RecetteDejaEnMemoireException;
import module_agenda.Evenement;
import module_agenda.Heure;
import module_alimentation.Aliment;
import module_alimentation.Recette;
import module_scolaire.Matiere;
import module_scolaire.Note;
import module_scolaire.UE;

/**
 * @author geourjoa
 * 
 */
public class InteractionClavier implements Interaction
{
	// ************************
	// ** Fonctions de base **
	// ************************

	@Override
	public int demanderUnInt()
	{
		// sc.close(); Leve l'exception "java.util.NoSuchElementException". Car
		// fermer un scanner ferme Systeme.in.
		// http://stackoverflow.com/questions/20739587/scanner-java-util-nosuchelementexception

		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);

		return sc.nextInt();

	}

	@Override
	public String demanderUneChaineDeCaractere()
	{
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		return sc.nextLine();
	}

	
	
	@Override
	public float demanderUnFloat()
	{
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		return sc.nextFloat();
	}
	
	// ************************
	// ** Fonctions composées **
	// ************************
	
	
	@Override
	public Aliment demanderUnAliment()
	{
		return new Aliment(this.demanderUneChaineDeCaractere(), this.demanderUnInt(), this.demanderUnInt());
	}
	
	@Override
	public Recette demanderUneRecette() throws RecetteDejaEnMemoireException
	{
		String nom = this.demanderUneChaineDeCaractere();

		int nombreDAlimentDeLARecette = this.demanderUnInt();

		Hashtable<String, Aliment> alimentsNecessaires = new Hashtable<>();

		for (int alimentNumero = 0; alimentNumero < nombreDAlimentDeLARecette; alimentNumero++)
		{
			Aliment alimentCourant = this.demanderUnAliment();
			alimentsNecessaires.put(alimentCourant.obtenirNom(), alimentCourant);
		}

		return new Recette(alimentsNecessaires, nom);

	}

	@Override
	public Evenement demanderUnEvenement() throws HeureIncorrecteException
	{
		return new Evenement(this.demanderUneDate(), this.demanderUneChaineDeCaractere(),
				this.demanderUneChaineDeCaractere(), this.demanderUneHeure(), this.demanderUneHeure());

	}

	@Override
	public Heure demanderUneHeure() throws HeureIncorrecteException
	{
		return new Heure(this.demanderUnInt(), this.demanderUnInt());
	}

	@Override
	public Date demanderUneDate()
	{
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		
		DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
		Date date = null;
		try
		{
			date = df.parse(sc.next());
		}
		catch (ParseException e)
		{
			e.printStackTrace();
		}

		return date;

	}

	@Override
	public UE demanderUneUE()
	{
		return new UE(this.demanderUneChaineDeCaractere(), this.demanderUnFloat());
	}

	

	@Override
	public Matiere demanderUneMatiere() throws MatiereSaisieIncorrecteException
	{
		return new Matiere(this.demanderUneChaineDeCaractere(), this.demanderUnFloat());
	}

	@Override
	public Note demanderUneNote() throws NoteSaisieIncorrecteException
	{
		return new Note(this.demanderUneDate(), this.demanderUnFloat(), this.demanderUnFloat(),
				this.demanderUneChaineDeCaractere());
	}
}
