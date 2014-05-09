import java.util.HashSet;
import java.util.Iterator;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Frigo
{

	private HashSet<Aliment> alimentsDuFrigo;
	
	private HashSet<Recette> recettesDisponibles;

	public Frigo()
	{
		this.alimentsDuFrigo = new HashSet<>();
	}

	public void insererAliment(Aliment alimentAAjouter)
	{
		this.alimentsDuFrigo.add(alimentAAjouter);
	}

	public void supprimerAliment(Aliment alimentASupprimer) throws alimentsInexistantException
	{
		if (!this.alimentsDuFrigo.remove(alimentASupprimer))
			throw new alimentsInexistantException();
	}

	public HashSet<Aliment> alimentsPerimes()
	{
		HashSet<Aliment> alimentsPerimes = new HashSet<>();

		Object[] lesAliments = this.alimentsDuFrigo.toArray();

		for (Object alimentCourant : lesAliments)
		{

			if (((Aliment) alimentCourant).obtenirDateDePeremption().before(new Date()))
			{
				alimentsPerimes.add((Aliment) alimentCourant);
			}
		}

		return alimentsPerimes;

	}

	private void mAJRecettePossible()
	{
	}

	public Aliment obtenirAlimenstDuFrigo()
	{
		return null;
	}

}