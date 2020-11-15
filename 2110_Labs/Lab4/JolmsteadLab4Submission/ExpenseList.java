

//import Labs.Lab4Fall2020.List; - package to be commented out

/**
 * Expense list provided by Srini
 */
public class ExpenseList
{
	private List<Expense> expenses;


	public ExpenseList()
	{
		expenses = new List<Expense>();
	}
	public void add(Expense exp)
	{
		expenses.add(exp);
	}

	public boolean isEmpty()
	{
		return expenses.isEmpty();
	}
	public boolean contains(Expense exp)
	{
		return expenses.contains(exp);
	}
	public Expense first()
	{
		return expenses.first();
	}
	public Expense next()
	{
		return expenses.next();
	}
	public void enumerate()
	{
		expenses.enumerate();
	}

    /**
     * returns the highest expense object in the expenses list
	 * @return
     */
	public double maxExpense()
	{
		double max =0.0, amt;
		Expense exp = expenses.first();
		while (exp!=null)
		{
			amt = exp.getAmount();
			if (amt>max)
				max = amt;
			exp = expenses.next();
		}
		return max;
	}

    /**
     * returns the lowest expense object in the expenses list
	 * @return
     */
	public double minExpense()
	{
		double min =Double.MAX_VALUE, amt;
		Expense exp = expenses.first();
		if (exp==null) return 0.0;
		else
		{

			while (exp!=null)
			{
				amt = exp.getAmount();
				if (amt<min)
					min = amt;
				exp = expenses.next();
			}
		}
		return min;
	}

    /**
     * returns the average expense value from the expenses list
	 * @return
     */
	public double avgExpense()
	{
		double sum = 0;
		Expense exp = expenses.first();
		if(exp == null) {//make sure there is something in the list
			return 0.0;
		} else{
			while(exp!=null){//until the end of the list
				double amt = exp.getAmount();
				sum += amt;
				exp = expenses.next();
		}
	}
		double average = sum/expenses.size();
		return average;
	}

    /**
     * returns the total expenses from the expense list
	 * @return
     */
	public double totalExpense()
	{
		double sum = 0; //instantiate the sum variable
		Expense exp = expenses.first();
		if(exp == null) { //make sure there is something in the list
			return 0.0;
		} else { //not null
			while(exp!=null){ //until the end of the list
				double amt = exp.getAmount();
				sum += amt;
				exp = expenses.next();
			}
		}
		return sum;
	}

    /**
     * returns the total amount spent on a given item from the expenses lists
	 * @param expItem
     * @return
     */
	public double amountSpentOn(String expItem)
	{
		double sum = 0;
		Expense exp = expenses.first();
		while(exp!=null){ //as long as exp isnt null
			if(exp == null) { //is the expense empty?
				return 0.0; //if it is empty
			} else if (exp.getItem().equals(expItem)){ //is it the item we are checking for?
				//yes, get the amount for that item and add it to the sum
				double amt = exp.getAmount();
				sum += amt;
			}
			exp = expenses.next();
		}
		return sum;

	}


}
