package com.lxisoft.animalgame.animal;
public abstract class Animal{
	private int hunger;
	private int strength;
	private String name;
	private int locationX;
	private int locationY;
	public Animal(){
		setLocationX();
		setLocationY();
		setHunger();
		setStrength();
	}
	public void setName(String name){
		this.name = name;
	}
	public String getName(){
		return name;
	}
	public void setHunger(){
		this.hunger = (int)(Math.random()*100);
	}
	public int getHunger(){
		return hunger;
	}
	public void setLocationX(){
		this.locationX = (int)(Math.random()*50);
	}
	public int getLocationX(){
		return locationX;
	}
	public void setLocationY(){
		this.locationY = (int)(Math.random()*50);
	}
	public int getLocationY(){
		return locationY;
	}
	public void setStrength(){
		this.strength = (int)(Math.random()*100);
	}
	public int getStrength(){
		return strength;
	}
	public abstract String eat(String animalOne,String animalTwo);

}