import java.util.Scanner;

public class InteractionClavier extends InteractionAbstraite
{
	@Override
	public int choixNumerique()
	{
		Scanner sc = new Scanner(System.in);
		
		int choix = sc.nextInt();
		
		sc.close();
		
		return choix;

	}
}
