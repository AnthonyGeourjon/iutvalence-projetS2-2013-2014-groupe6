package module_agenda;
/**
 * 
 * @author Valentin
 *
 */

public class Heure {
	
	private int minute ;
	
	private int heure ;

	public int getMinute() {
		return minute;
	}

	public void setMinute(int minute) {
		this.minute = minute;
	}

	public int getHeure() {
		return heure;
	}

	public void setHeure(int heure) {
		this.heure = heure;
	}
	
	public Heure (int heure, int minute){
		this.heure = heure ;
		this.minute = minute ;
	}
	
	
	
	

}
