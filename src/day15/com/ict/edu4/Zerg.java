package day15.com.ict.edu4;

public class Zerg implements Unit {
	private String name;
	private int energy ;
	private boolean fiy ;
	
	public Zerg() {
		
	}

	public Zerg(String name, int energy, boolean fiy) {
		super();
		this.name = name;
		this.energy = energy;
		this.fiy = fiy;
	}
	
	// 공격 받으면 에너지가 떨어짐 (15씩 떨어짐)
	@Override
	public void decEnergy() {
		energy = energy -15;
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getEnergy() {
		return energy;
	}

	public void setEnergy(int energy) {
		this.energy = energy;
	}

	public boolean isFiy() {
		return fiy;
	}

	public void setFiy(boolean fiy) {
		this.fiy = fiy;
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
