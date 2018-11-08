

public class LineItem implements java.io.Serializable, Comparable{


/**
	 * 
	 */
	private static final long serialVersionUID = -4790098379494246660L;
	//pizza attributes
private Pizza Pizza;
private int numberOpizzas = 0;
	
	public LineItem(int numPizza, Pizza pizza) throws IllegalPizza {
		setNumber(numPizza);
		setPizza(pizza);
	}
	
	public LineItem(Pizza pizza) throws IllegalPizza{
		setNumber(1);
		setPizza(pizza);
	}
	
	public void setNumber(int numPizza) throws IllegalPizza{
		if (numPizza < 1 || numPizza > 100)
			throw new IllegalPizza("Illegal amount of pizzas!");
		else 
			numberOpizzas = numPizza;
	}
	
	public void setPizza(Pizza pizza) throws IllegalPizza {
		if (pizza == null)
			throw new IllegalPizza("Pizza can't be null!");
		else
			Pizza = pizza.clone();
	}
	
	//accessor to get pizza
	public Pizza getPizza(){
		return Pizza.clone();
	}
	
	//accessor to get number of pizzas
	public int getNumber(){
		return numberOpizzas;
	}
	
	//accessor to get the total cost of the pizzas
	public double getCost(){
		return getPizza().getCost()*getNumber();
	}
	
	//Turns the line of pizzas into a string
	public String toString(){
		String output = new String();
		if(getNumber() == 1)
			output = " " + getNumber() + " " + getPizza().toString();
		else
			output = getNumber() + " " + getPizza().toString();
		return output;
	}
	
	//uses comparable to compare LineItems
	@Override
	public int compareTo(Object line) {
		double d1 = this.getCost();
		double d2 = ((LineItem)line).getCost();
		int d3 = (int) d1;
		int d4 = (int) d2;
			
		if (d3 < d4)
			return d4 - d3;
		else if (d3 > d4)
			return d4 - d3;
		else 
			return 0;
		}	
}
