package src;
//
// create two employee objects and display each objects yearly salary
// then give each employee a 10% raise and display each employees yearly sal again
//

class DriverTest
{
	// main method
	public static void main(String[] args)
	{
		Employee emp1 = new Employee( "Cody", "McAntire", 1000.00 ); //set employee 1
		Employee emp2 = new Employee( "Jim", "Neutron", 2000.00 ); //set employee 2

		// display yearly salary of employees
		System.out.printf( "Yearly salary of %s %s: %.2f\n", emp1.getFirstName(), emp1.getLastName(), emp1.getYearlySalary() );
		System.out.printf( "Yearly salary of %s %s: %.2f\n", emp2.getFirstName(), emp2.getLastName(), emp2.getYearlySalary() );

		System.out.println();

		// display salary after applying 10% raise
		System.out.println( "*** Salary of Employees after 10% raise ***" );
		System.out.printf( "Yearly salary of %s %s: %.2f\n", emp1.getFirstName(), emp1.getLastName(), emp1.getRaiseSalary() );
		System.out.printf( "Yearly salary of %s %s: %.2f\n", emp2.getFirstName(), emp2.getLastName(), emp2.getRaiseSalary() );

		//display date
		System.out.println();
		System.out.printf( "Date: " );
		Date date = new Date(01,24,21);
		date.displayDate();

	} // end method main
} // end DriverTest


