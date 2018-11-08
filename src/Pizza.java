

import java.util.Objects;

public class Pizza implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3824797380701484133L;
	// these are the pizza attributes
	private String Size;
	private int Cheese, Ham, Pepperoni;
	
	public Pizza(String size, int cheese, int ham, int pepperoni) throws IllegalPizza{
		setSize(size);
		setToppings(cheese, ham, pepperoni);
	}
	
	public Pizza(String size) throws IllegalPizza{
		setSize(size);
		setToppings(1, 0, 1);
	}
	
	// sets the pizza size
	public void setSize(String size) throws IllegalPizza{
		if(size == null)
			throw new IllegalPizza("Illegal, pizza size is not null!");
		String size1 = size.toLowerCase();
		if (Objects.equals(size1, "small"))
			Size = size1;
		else if (Objects.equals(size1, "medium"))
			Size = size1;
		else if (Objects.equals(size1, "large"))
			Size = size1;
		else 
			throw new IllegalPizza("Illegal pizza size");
	}
	
	//sets the pizza toppings
	public void setToppings(int cheese, int ham, int pepperoni) throws IllegalPizza{
		if (ham < 0 || pepperoni < 0 || cheese < 0)
			throw new IllegalPizza("Illegal pizza, negative input!");
		if (ham + pepperoni > 3)
			throw new IllegalPizza("Illegal pizza, too much meat!");
		else if (cheese == 0)
			throw new IllegalPizza("Illegal pizza, there's no cheese!");
		else if (cheese > 3)
			throw new IllegalPizza("Illegal pizza, too much cheese!");
		else
			Cheese = cheese;
			Ham = ham;
			Pepperoni = pepperoni;
	}
	
	//returns a double for the cost of a pizza
	public double getCost() {
		
		double cost = 0;
		
		if (Objects.equals(Size, "small"))
			cost = 7.00;
		else if (Objects.equals(Size, "medium"))
			cost = 9.00;
		else if (Objects.equals(Size, "large"))
			cost = 11.00;
		
		cost += (Cheese - 1)*1.50;
		cost += Ham*1.50;
		cost += Pepperoni*1.50;
		
		return cost;		
	}
	
	// turns a pizza object into a readable string
	public String toString(){
		String cheese, ham, pep;
		
		if (Cheese == 1)
			cheese ="";
		else if (Cheese == 2)
			cheese = "double ";
		else 
			cheese = "triple ";
		if (Ham == 1)
			ham ="";
		else if (Ham == 2)
			ham = "double ";
		else 
			ham = "triple ";
		if (Pepperoni == 1)
			pep ="";
		else if (Pepperoni == 2)
			pep = "double ";
		else 
			pep = "triple ";
			
		String output = new String();
		if (Ham >= 1 && Pepperoni >= 1){
			output = Size + " pizza, " + cheese + "cheese, " + ham + "ham, " + pep 
			+ "pepperoni. Cost: $" + String.format("%2.2f", getCost()) + " each.";}
		else if (Ham == 0 && Pepperoni == 0)
			output = Size + " pizza, " + cheese + "cheese only. Cost: $" + String.format("%2.2f", getCost()) + " each.";
		else if (Ham == 1 && Pepperoni == 0){
			output = Size + " pizza, " + cheese + "cheese, " + ham + "ham. Cost: $" + String.format("%2.2f", getCost()) + " each.";}
		else if (Ham == 0 && Pepperoni == 1){
			output = Size + " pizza, " + cheese + "cheese, " + pep
					+ "pepperoni. Cost: $" + String.format("%2.2f", getCost()) + " each.";}
		
		return output;
		}
	
	// clones a pizza object
	public Pizza clone(){
		Pizza otherP = null;
		try { 
			otherP = new Pizza(Size, Cheese, Ham, Pepperoni);
		} catch (IllegalPizza ite) {
			//shouldn't get here
		}
		return otherP;
	}
	
	// returns a true or false on whether  pizzas equal
	public boolean equals(Object otherPizza){
		Pizza p;
		if(otherPizza instanceof Pizza){
			p = (Pizza) otherPizza;
			if (Size==p.Size && Cheese==p.Cheese && Ham==p.Ham && Pepperoni==p.Pepperoni)
				return true;
			else
				return false;
		}
		else 
			return false;
	}
}
			
	

