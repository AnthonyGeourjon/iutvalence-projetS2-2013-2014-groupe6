package interaction;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Hashtable;
import java.util.Scanner;

import exception.NombreMaxDAlimentAtteintException;
import exception.NombreMaxDAlimentException;
import exception.RecetteDejaEnMemoireException;
import module_alimentation.Aliment;
import module_alimentation.Recette;

/**
 * @author geourjoa
 * 
 */
public class InteractionClavier extends InteractionAbstraite
{

	@Override
	public int choixNumerique()
	{
		Scanner sc = new Scanner(System.in);

		int choix = sc.nextInt();

		// sc.close(); Leve l'exception "java.util.NoSuchElementException". Car
		// fermer un scanner ferme Systeme.in.
		// http://stackoverflow.com/questions/20739587/scanner-java-util-nosuchelementexception

		return choix;

	}

	@Override
	public Aliment saisirUnAliment() 
	{
		Scanner sc = new Scanner(System.in);

		String nom = sc.next();

		// Utiliser pour l'attribut date d'un aliment.

		// DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
		// Date date=null;
		// try
		// {
		// date= df.parse(sc.next());
		// }
		// catch (ParseException e)
		// {
		// e.printStackTrace();
		// }

		int quantite = sc.nextInt();

		return new Aliment(nom, quantite);

	}

	@Override
	public Recette demanderUneRecette()
	{
		Scanner sc = new Scanner(System.in);

		String nom = sc.next();

		int nombreDAlimentDeLARecette = sc.nextInt();

		Hashtable<String, Aliment> alimentsNecessaires = new Hashtable<>();

		for (int alimentNumero = 0; alimentNumero < nombreDAlimentDeLARecette; alimentNumero++)
		{
			Aliment alimentCourant = this.saisirUnAliment();
			alimentsNecessaires.put(alimentCourant.obtenirNom(), alimentCourant);
		}

		try
		{
			return new Recette(alimentsNecessaires, nom);
		}
		catch (RecetteDejaEnMemoireException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}
}
