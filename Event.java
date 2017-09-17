
public class Event {
// Required data fields
// The date of the event
	private Date pDate;
// The start time or hour of the event
	private int pStart;
// The end time or hour of the event
	private int pEnd;
// A description of the event
	private String pDescription;
	
	// Default constructor
	public Event () {
		pDate = null;
		pStart = 0;
		pEnd = 0;
		pDescription = "";
	}// End of default constructor
	
	// constructor called with passed variables
	public Event (Date date, int start, int end, String description) throws IllegalArgumentException {
		// Create a new IllegalArgumentException object ae
		IllegalArgumentException ae = new IllegalArgumentException("Out of range");
		
		//Check to see if start time is within range
		if (start >= 0 && start <= 24) {
			//Check to make sure start time is before end time
			if(start <= end) 
				pStart = start;
			// If start time is after end time then throw an exception
			else
				throw ae;
		}
		// If not within range then throw exception
		else
			throw ae;
		
		//Check to see if end time is within range
		if(end >= 0 && end <= 24)
			pEnd = end;
		// If not throw an exception
		else
			throw ae;
		
		// initialize the object pDate to passed date
		pDate = date;
		
		//initialize the String description with passed String
		pDescription = description;
	}// End of constructor
	
	// Method to return date
	public Date getDate() {
		return pDate;
	}// End of getDate method
	
	// Method to return start time
	public int getStart() {
		return pStart;
	}// End of getStart method
	
	// Method to return end time
	public int getEnd() {
		return pEnd;
	}// End of getEnd method
	
	// Method to return description
	public String getDescription() {
		return pDescription;
	}// End of getDescription method
	
	// Mutator for the pDescription 
	public void setDescription(String newDescription) {
		pDescription = newDescription;
	}// End Mutator
	
	// Method to retrieve string version of event
	public String toString() {
		return pDate.toString() + " " + pStart + " " + "--" + " " + pEnd + ":" + " " + pDescription;
	}// end toString
	
	// equals method 
	public boolean equals(Object obj) {
		// Check to see if passed object is null
		if(obj == null)
			return false;
		
		// Check to see if passed object is an Event object
		if(!(obj instanceof Event))
			return false;
		
		// create and initialize a new Event object and initialize it with the passed obj
		Event otherEvent = (Event) obj;
		
		// Check to see if both event object is the same event and return true if it is otherwise return false
		if(this.pDate == otherEvent.pDate && this.pStart == otherEvent.pStart && this.pEnd == otherEvent.pEnd && this.pDescription == otherEvent.pDescription)
			return true;
		else 
			return false;
	}
}
