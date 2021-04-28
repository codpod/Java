package src;

class Date
{
	private int month;
	private int day;
	private int year; //instance variables

	public Date(int m, int d, int y)
	{ //constructor
		month=m;
		day=d;
		year=y;
	}

	//set and get method for months
	public void setMonth(int currentMonth)
	{ //set month
		if(currentMonth>=0 && currentMonth<=12)
			month = currentMonth;
		else
		{
			month=0;
		}
	}
	public int getMonth() //get method for month
		{
			return month;
		}

	//set and get methods for day
	public void setDay(int currentDay)
	{ //set day
		if(currentDay>=0 && currentDay<=31)
		{
			day=currentDay;
		}
		else
		{
			day=0;
		}
	}

	public int getDay() //get day
		{
			return day;
		}

	//set and get methods for year
	public void setYear(int currentYear) //set year
		{
			year=currentYear;
		}
	public int getYear()
		{
			return year;
		}

	//display date method
	public void displayDate()
		{
			System.out.printf("%d/%d/%d\n",getMonth(),getDay(),getYear());
		}
}
