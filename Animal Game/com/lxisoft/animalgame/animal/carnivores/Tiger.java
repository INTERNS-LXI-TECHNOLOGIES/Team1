package com.lxisoft.animalgame.animal.carnivores;
import com.lxisoft.animalgame.animal.*;
public class Tiger extends Animal implements Carnivore{
	public String kills(String animalOne ,String animalTwo){
		return animalOne+" Kills "+animalTwo;
	}
	public String eat(String animalOne,String animalTwo){
		return animalOne+" Eats "+animalTwo;
	}
	public String sound(){
		return "geerrrrw...";
	}
}