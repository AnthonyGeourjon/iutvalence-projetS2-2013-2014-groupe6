package module_budget;
/**
 * 
 * @author Valentin
 *
 */

import java.util.Scanner;

public class GestionBudget {
	
	public void menuGestionBudget(){
		
		char reponseQuitter = ' ';
		char choixMenu = ' ';
		float sommeBudget;
		float sommeAModifier;
		Scanner scMenuGestionBudget = new Scanner(System.in);
		Budget budget = new Budget(0);
		
		do{
			
			do{
				
				System.out.println("Que voulez-vous faire? ");
				System.out.println("1 - Initialiser le budget");
				System.out.println("2 - Modifier votre solde (ajouter ou retirer de l'argent");
				
				choixMenu = scMenuGestionBudget.nextLine().charAt(0);
				
				if(choixMenu != '1' && choixMenu != '2')
					System.out.println("Choix incorrect, veuillez répéter votre choix");
				
			}while( choixMenu != '1' && choixMenu != '2' );
			
			if(choixMenu == '1'){
				
				System.out.println("Entrez votre budget");
				Scanner scIntialiserBudget = new Scanner(System.in);
				sommeBudget = scIntialiserBudget.nextFloat();
				
				budget.initialiserBudget(sommeBudget);
				
			}
			else{
				
				System.out.println("Entrez votre modification (precédé d'un \"-\" pour soustraire ou d'un \"+\" pour ajouter une somme");
				Scanner scModifierBudget = new Scanner(System.in);
				sommeAModifier = scModifierBudget.nextFloat();
				budget.ajouterOuSoustraireArgentAuSolde(sommeAModifier);
				
				
				
				
				
			}
			
		}while( reponseQuitter != 'O');
	}

}
