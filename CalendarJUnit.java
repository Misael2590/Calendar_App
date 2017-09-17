import org.junit.Test;


public class CalendarJUnit {

	private static Calendar c;
	private static Event e;
	private static Date d;

	//Check Console for test
	@Test
	public void test_output_of_print() {
		d = new Date(2014, 8, 28);
		e = new Event(d, 10, 12, "event 1");
		System.out.println("******************Testing the Calendar Class********************");
		System.out.println("Testing the dump of a calendar.");
		c = new Calendar();
		c.addEvent(e);
		System.out.println("Your program should print:\n8/28/2014 10--12:event 1");

		System.out.println("This is what your program printed: ");
		c.dump();
	}

	/*
	 * Adds an event which should return true.
	 * 
	 * Fails if false or nothing is returned.
	 */
	@Test
	public void test_add_an_event() {
		c = new Calendar();
		e = new Event(d, 10, 12, "event 1");
		assert (c.addEvent(e) == true);
	}

	/*
	 * Adds an event after removing the middle event.
	 * Then checks to see if that event was added in the
	 * proper spot.
	 * 
	 * Fails if the findEvent method returns anything but 1.
	 */
	@Test
	public void test_add_event_in_middle() {
		c = new Calendar();
		Event e1 = new Event(d, 10, 12, "event 1");
		Event e2 = new Event(d, 12, 14, "event 2");
		Event e3 = new Event(d, 14, 15, "event 3");
		Event e4 = new Event(new Date(2014, 8, 15), 14, 15, "event 4");
		c.addEvent(e1);
		c.addEvent(e2);
		c.addEvent(e3);
		c.removeEvent(e2);
		c.addEvent(e4);
		assert (c.findEvent(e4) == 1);
	}

	@Test
	public void test_remove_existing_event() {
		c = new Calendar();
		Event e1 = new Event(d, 10, 12, "event 1");
		Event e2 = new Event(d, 12, 14, "event 2");
		Event e3 = new Event(d, 14, 15, "event 3");
		c.addEvent(e1);
		c.addEvent(e2);
		c.addEvent(e3);
		assert (c.removeEvent(e3) == true);
	}

	/*
	 * Tries to remove an event from an empty Calendar.
	 * 
	 * Fails if anything else but false is returned.
	 */
	@Test
	public void test_remove_event_empty() {
		c = new Calendar();
		Event e1 = new Event(d, 10, 12, "event 1");
		assert (c.removeEvent(e1) == false);
	}

	/*
	 * Tries to remove an event that isn't in the calendar.
	 * 
	 * Fails if anything else but false is returned.
	 */
	@Test
	public void test_remove_event_not_there() {
		c = new Calendar();
		Event e1 = new Event(d, 10, 12, "event 1");
		Event e2 = new Event(d, 12, 14, "event 2");
		c.addEvent(e1);
		assert (c.removeEvent(e2) == false);
	}

	@Test
	public void test_find_existing_event() {
		c = new Calendar();
		Event e1 = new Event(d, 10, 12, "event 1");
		Event e2 = new Event(d, 12, 14, "event 2");
		c.addEvent(e1);
		c.addEvent(e2);
		assert (c.findEvent(e2) == 1);
	}

	/*
	 * Tries to find an event in an empty Calendar.
	 * 
	 * Fails if anything else but -1 is returned.
	 */
	@Test
	public void test_find_event_empty() {
		c = new Calendar();
		Event e1 = new Event(d, 10, 12, "event 1");
		assert (c.findEvent(e1) == -1);
	}

	/*
	 * Tries to find an event that doesn't exist
	 * on a Calendar
	 * 
	 * Fails if anything but -1 is returned.
	 */
	@Test
	public void test_find_event_not_there() {
		c = new Calendar();
		Event e1 = new Event(d, 10, 12, "event 1");
		Event e2 = new Event(d, 12, 14, "event 2");
		c.addEvent(e1);
		assert (c.findEvent(e2) == -1);
	}

	/*
	 * Tries to add an event to a calendar that is full.
	 * 
	 * Fails if anything but false is returned.
	 */
	@Test
	public void test_add_to_full_calendar() {
		c = new Calendar();
		Event e1 = new Event(d, 10, 12, "event 1");
		Event e2 = new Event(d, 12, 14, "event 2");
		Event e3 = new Event(d, 14, 15, "event 3");
		Event e4 = new Event(new Date(2014, 8, 15), 14, 15, "event 4");
		c.addEvent(e1);
		c.addEvent(e2);
		c.addEvent(e3);
		c.addEvent(e4);
		assert (c.addEvent(e1) == false);
	}

}