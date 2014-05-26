package interaction;

import java.util.Hashtable;
import java.util.Scanner;
import exception.RecetteDejaEnMemoireException;
import module_alimentation.Aliment;
import module_alimentation.Recette;

/**
 * @author geourjoa
 * 
 */
public class InteractionClavier  implements Interaction
{
	/**
	 * Moyen d'interargir avec l'utilisateur
	 */
	private Scanner sc;

	/**
	 * Constructeur
	 */
	public InteractionClavier()
	{
		this.sc=new Scanner(System.in);
	}
	
	@Override
	public int choixNumerique()
	{

		int choix = this.sc.nextInt();

		// sc.close(); Leve l'exception "java.util.NoSuchElementException". Car
		// fermer un scanner ferme Systeme.in.
		// http://stackoverflow.com/questions/20739587/scanner-java-util-nosuchelementexception

		return choix;

	}

	@Override
	public Aliment saisirUnAliment()
	{
		String nom = this.sc.next();

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

		int quantite = this.sc.nextInt();

		return new Aliment(nom, quantite);

	}

	@Override
	public Recette saisirUneRecette()
	{
		String nom = this.sc.next();

		int nombreDAlimentDeLARecette = this.sc.nextInt();

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

	@Override
	public String demanderUnNom()
	{
		return this.sc.next();
	}

}
