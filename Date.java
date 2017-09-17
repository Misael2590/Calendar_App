
public class Date implements Comparable<Date> {

	// Data fields to hold the month, year, and date 
	private int pYear;
	private int pMonth;
	private int pDay;
	
	// Default constructor
	public Date () {
		pYear = 0;
		pMonth = 0;
		pDay = 0;
	}// end default constructor
	
	 // Constructor that initializes data fields
	public Date(int year, int month, int day) throws IllegalArgumentException {
		// Checks to see if year is in valid range
		if (year >= 2014 && year <= 2020) 
			pYear = year;
		else {
			IllegalArgumentException ae = new IllegalArgumentException("Out of range");
			throw ae;
		}
		// Checks to see if month is valid range and initialize the month
		if (month >= 1 && month <= 12) 
			pMonth = month;
		else {
			IllegalArgumentException ae = new IllegalArgumentException("Out of range");
			throw ae;
		}
		
		// Checks to see if day is in valid range and initialize the day
		if (day >= 1 && day <=31) 
			pDay = day;
		else {
			IllegalArgumentException ae = new IllegalArgumentException("Out of range");
			throw ae;
		}
	}// Ends constructor
	
	public int getYear() {
		return pYear;
	}// End getYear
	
	public int getMonth() {
		return pMonth;
	}// End getMonth
	
	public int getDay() {
		return pDay;
	}// End getDay
	
	public String toString() {
		return pMonth + "/" + pDay + "/" + pYear;
	}
	
	@Override
	public boolean equals(Object obj) {

		//Check to see if passed object is null
		if(obj == null) {
			return false;
		}
		
		// Check to see if the passed object is a Date object
		if(!(obj instanceof Date)) {
			return false;
		}
		
		// create a new Date object that is filled with the object that is passed by the method
		Date otherDate = (Date) obj;
		
		//check to see if the month, day, and year are the same between both objects)
		if(this.pDay == otherDate.pDay && this.pMonth == otherDate.pMonth && this.pYear == otherDate.pYear) {
			return true;
		}
		else {
			// if they do not match return false
			return false;
		}
		
	}
	@Override
	public int compareTo(Date otherDate) {
		
		//Check to see if this.pYear object is smaller than otherDate.pYear and return -1 if it is
		if(this.pYear < otherDate.pYear) {
			return -1;
		}
		//Check to see if this.pYear is larger than otherDate.pYear and return 1 if it is
		else if(this.pYear > otherDate.pYear) {
			return 1;
		}
		// If both years are the same then proceed to check the month
		else if(this.pYear == otherDate.pYear) {
			//If this.pMonth is smaller than otherDate.pMonth then return -1
			if(this.pMonth < otherDate.pMonth) {
				return -1;
			}
			//Check to see if this.pMonth is larger than otherDate.pMonth and return 1
			else if(this.pMonth > otherDate.pMonth) {
				return 1;
			}
			//If this.pMonth and otherDate.pMonth is the same than proceed to compare the day
			else if(this.pMonth == otherDate.pMonth) {
				//Check to see if this.pDay is larger than otherDate.pDay and return 1
				if(this.pDay < otherDate.pDay) {
					return -1;
				}
				//Check to see if this.pDay is larger than otherDate.pDay and return 1
				else if(this.pDay > otherDate.pDay) {
					return 1;
				}
				//If both days are the same then return 0
				else if(this.pDay == otherDate.pDay) {
					return 0;
				}
			}
		}
		return 0;
	}

}
