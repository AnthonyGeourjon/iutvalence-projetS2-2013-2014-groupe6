import java.util.Date;


public class Note
{
	private Date date;
	
	private float valeur;
	
	private float coeff;
	
	private String commentaire;

	public Note(Date date, float valeur, float coeff, String commentaire)
	{
		super();
		this.date = date;
		this.valeur = valeur;
		this.coeff = coeff;
		this.commentaire = commentaire;
	}

	public Date obtenirDate()
	{
		return this.date;
	}

	public float obtenirCoeff()
	{
		return this.coeff;
	}

	public float obtenirValeur()
	{
		return this.valeur;
	}
	
	
	
	
	
	
}
