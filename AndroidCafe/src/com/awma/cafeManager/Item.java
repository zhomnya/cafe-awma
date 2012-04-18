package com.awma.cafeManager;

public class Item {
	private int id;
	private String name;
	private String price;
	private Integer pict;
	
	public Item(int ids, String nama, String Hrga, Integer gmbr){
		id = ids;
		name = nama;
		price = Hrga;
		pict = gmbr;
	}
	
	public int getId(){
		return id;
	}
	
	public void setId(int ids){
		id = ids;
	}
	public String getName(){
		return name;
	}
	
	public void setName(String Nma){
		name = Nma;
	}
	public String getPrice(){
		return price;
	}
	
	public void setPrice(String ids){
		price = ids;
	}
	public Integer getPict(){
		return pict;
	}
	
	public void setPict(Integer ids){
		pict = ids;
	}
}
