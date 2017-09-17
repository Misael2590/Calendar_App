
public class Calendar {
// Required data fields for the calendar class
	private static final int maxEvents = 4;
	// Create a new array to hold Events object
	private Event [] events;
	// Create a counter to keep track of how many events scheduled
	private int numEvents;
	
	// Create a default constructor
	public Calendar() {
		//  Initialize the events array to the size maxEvents 
		events = new Event [maxEvents];
		// Initialize the numEvents to zero
		numEvents = 0;
	}// End of the default constructor
	
	// Call a method to add an event to the events array
	public boolean addEvent(Event e) {
		if(numEvents <= maxEvents) {
			for(int x = 0; x < events.length; ++x) {
				if(events[x] == null) {
					events[x] = e;
					numEvents += 1;
					return true;
				}
			}
		}
		// I am not sure about this statement
		return false;
	}// End of the addEvent method
	
	// Call a method that finds the place hold for the given event
	public int findEvent(Event e) {
		// For loop to traverse the events array
		for(int x = 0; x < events.length; ++x) {
			// Check to see if array entry is null then continue 
			if(events[x] == null) 
				continue;
			// Check to see if event is equal to passed event then return the element number
			else if(events[x] == e)
				return x;
		}
		// After iterating through the loop and not finding an equal event return -1
		return -1;
	}// end the findEvent method
	
	// call a method that removes an event
	public boolean removeEvent(Event e) {
		// A variable to hold the index of event in array
		int holdInd = findEvent(e);
		// Check to see if the event was found
		if (holdInd == -1) {
			return false;
		}
		else {
			// Make element null
			events[holdInd] = null;
			// return true if successfully removed
			return true;
		}
	}
	
	//Call a method to show the events in the array
	public void dump() {
		// run a for loop to run through the events array
		for(int x = 0; x < events.length; ++x)
			// Check to see if the events element is null
			if(events[x] == null) {
				continue;
			}
		//If not null then print out the events
			else 
				System.out.println(events[x]);
	}
}

