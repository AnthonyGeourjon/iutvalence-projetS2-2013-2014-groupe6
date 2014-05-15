import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Scanner;

public class InteractionClavier extends InteractionAbstraite
{
	@Override
	public int choixNumerique()
	{
		Scanner sc = new Scanner(System.in);
		
		int choix = sc.nextInt();
		
		//sc.close(); Leve l'exception "java.util.NoSuchElementException". Car fermer un scanner ferme Systeme.in.
		// http://stackoverflow.com/questions/20739587/scanner-java-util-nosuchelementexception
		
		return choix;

	}
	
	@Override
	public Aliment saisirUnAliment()
	{
		Scanner sc = new Scanner(System.in);
		
		String nom = sc.next();
		
		DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
		Date date=null;
		try
		{
		date= df.parse(sc.next());
		} 
		catch (ParseException e)
		{
		e.printStackTrace();
		} 
		
		int quantite = sc.nextInt();
		int prix = sc.nextInt();
		
		return new Aliment(nom, date, quantite, prix);
	}
	
	@Override
	public Recette demanderUneRecette()
	{
		Scanner sc = new Scanner(System.in);
		
		String nom = sc.next();
		
		HashSet<Aliment> alimentsNecessaires = new HashSet<>();
		
		for(int alimentNuméro=0; alimentNuméro<sc.nextInt(); alimentNuméro++)
		{
			alimentsNecessaires.add(this.saisirUnAliment());
		}
		
		return new Recette(alimentsNecessaires, nom);
	}
}
