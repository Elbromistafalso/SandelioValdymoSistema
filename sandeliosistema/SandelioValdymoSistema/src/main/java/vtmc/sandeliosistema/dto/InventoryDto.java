package vtmc.sandeliosistema.dto;

import java.util.Date;


public class InventoryDto {
	
	private String name;
	private float weight;
	private int sector;
	
	public InventoryDto() {}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getWeight() {
		return weight;
	}

	public void setWeight(float weight) {
		this.weight = weight;
	}

	public int getSector() {
		return sector;
	}

	public void setSector(int sector) {
		this.sector = sector;
	}
	
	


}
