package vtmc.sandeliosistema.dto;

import vtmc.sandeliosistema.domain.ClientType;

public class ClientDto {
	
	private Long id;
	private String name;
	private String surname;
	private String date;
	private String phone;
	private String type;
	private int inventorySize;
	
	public ClientDto(){}
	
	public ClientDto(Long id, String name, String surname, String date, String phone, String type, int inventorySize) {
		super();
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.date = date;
		this.phone = phone;
		this.type = type;
		this.inventorySize = inventorySize;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getInventorySize() {
		return inventorySize;
	}

	public void setInventorySize(int inventorySize) {
		this.inventorySize = inventorySize;
	}
	
	

}
