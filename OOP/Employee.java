package src;
//
// Cody McAntire
// Assignment 1
// Due: 01/24/2020
//

public class Employee
{
	private String firstName; //insance variable for first name
	private String lastName; //instance variable for last name
	private double monthlySalary; //instance variable for monthly salary

	public Employee(String first, String last, double msalary) //default constructor
	{
		this.firstName = first;
		this.lastName = last;
		this.monthlySalary = msalary;
	
		if (msalary < 0.0)
			monthlySalary = 0.0;
	}
	//method to set first name
        public void setFirstName(String first)
        {
                this.firstName = first;
        }
	//method to get first name
	public String getFirstName()
	{
		return firstName;
	}

	//method to set last name
        public void setLastName(String last)
        {
                this.lastName = last;
        }
	//method to get last name
	public String getLastName()
	{
		return lastName;
	}
	
	//method to set monthly salary
	public void setMonthlySalary (double msalary)
	{
		this.monthlySalary = msalary; //set monthly sal
	}
	//method to get monthly salary
	public double getMonthlySalary()
	{
		return monthlySalary;
	}
	//method to get yearly salary
	public double getYearlySalary()
	{
		double yearlySalary = monthlySalary * 12;
		return yearlySalary;
	}
	//method to get salary with raise
	public double getRaiseSalary()
	{
		double raise =  monthlySalary * 0.1;
		double raiseSalary = ( monthlySalary + raise ) * 12;
		return raiseSalary;
	}
}
