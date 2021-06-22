package vtmc.sandeliosistema.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.validator.constraints.Range;

@Entity
@Table(name = "inventory")
public class Inventory {
	
	@Id
	private String name;
	private float weight;
	
	@Range(min=1,max=40)
	private int sector;
	
	@Temporal(TemporalType.DATE)
	private Date date;
	
	 @ManyToOne
	 private Client client;
	
	public Inventory() {}

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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	public void addClient(Client client) {
		this.client = client;
		client.getInventoryList().add(this);
	}
	
	
	
	

}
