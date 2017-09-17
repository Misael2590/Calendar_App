
import org.junit.Test;


public class EventJUnit {

	private static Event e1;
	private static Event e2;
	private static Date d1;

	@Test
	public void test_get_date() {
		d1 = new Date(2014, 8, 28);
		e1 = new Event(d1, 10, 12, "event 1");
		assert (e1.getDate().equals(d1));
	}

	@Test
	public void test_get_start() {
		d1 = new Date(2014, 8, 28);
		e1 = new Event(d1, 10, 12, "event 1");
		assert (e1.getStart() == 10);
	}
	
	@Test
	public void test_get_start_random() {
		for(int i = 0; i < 1000; i ++) {
			int start = (int)(Math.random() * 22);
			d1 = new Date(2014, 8, 28);
			e1 = new Event(d1, start, 23, "event 1");
			assert (e1.getStart() == start);
		}
	}

	@Test
	public void test_get_end() {
		d1 = new Date(2014, 8, 28);
		e1 = new Event(d1, 10, 12, "event 1");
		assert (e1.getEnd() == 12);
	}
	
	@Test
	public void test_get_end_random() {
		for(int i = 0; i < 1000; i ++) {
			int end = (int)(Math.random() * 23) + 1;
			d1 = new Date(2014, 8, 28);
			e1 = new Event(d1, 0, end, "event 1");
			assert (e1.getEnd() == end);
		}
	}

	@Test
	public void test_get_description() {
		d1 = new Date(2014, 8, 28);
		e1 = new Event(d1, 10, 12, "event 1");
		assert (e1.getDescription().equals("event 1"));
	}

	@Test
	public void test_set_description() {
		d1 = new Date(2014, 8, 28);
		e1 = new Event(d1, 10, 12, "event 1");
		e1.setDescription("New event update");
		assert (e1.getDescription().equals("New event update"));
	}

	@Test(expected = IllegalArgumentException.class)
	public void test_invalid_event_start_less_than_0() {
		d1 = new Date(2014, 8, 28);
		e1 = new Event(d1, -5, 12, "some events");
	}

	@Test(expected = IllegalArgumentException.class)
	public void test_invalid_event_start_greater_than_23() {
		d1 = new Date(2014, 8, 28);
		e1 = new Event(d1, 26, 30, "some events");
	}

	@Test(expected = IllegalArgumentException.class)
	public void test_invalid_event_end_less_than_0() {
		d1 = new Date(2014, 8, 28);
		e1 = new Event(d1, 1, -8, "some events");
	}

	@Test(expected = IllegalArgumentException.class)
	public void test_invalid_event_end_greater_than_23() {
		d1 = new Date(2014, 8, 28);
		e1 = new Event(d1, 1, 26, "some events");
	}

	@Test(expected = IllegalArgumentException.class)
	public void test_invalid_event_start_greater_than_end() {
		d1 = new Date(2014, 8, 28);
		e1 = new Event(d1, 14, 12, "some events");
	}

	@Test
	public void test_unequal_events_different_starts() {
		d1 = new Date(2014, 8, 28);
		e1 = new Event(d1, 10, 12, "event 1");
		e2 = new Event(d1, 12, 12, "event 1");
		assert (!e1.equals(e2));
	}

	@Test
	public void test_unequal_events_different_random_starts() {
		for(int i = 0; i < 1000; i ++) {
			int start1 = (int)(Math.random() * 12);
			int start2 = (int)(Math.random() * 12) + 12;
			d1 = new Date(2014, 8, 28);
			e1 = new Event(d1, start1, 23, "event 1");
			e2 = new Event(d1, start2, 23, "event 1");
			assert (!e1.equals(e2));
		}
	}
	
	@Test
	public void test_unequal_events_different_ends() {
		d1 = new Date(2014, 8, 28);
		e1 = new Event(d1, 9, 10, "event 1");
		e2 = new Event(d1, 9, 12, "event 1");
		assert (!e1.equals(e2));
	}
	
	@Test
	public void test_unequal_events_different_random_ends() {
		for(int i = 0; i < 1000; i ++) {
			int end1 = (int)(Math.random() * 11) + 1;
			int end2 = (int)(Math.random() * 12) + 12;
			d1 = new Date(2014, 8, 28);
			e1 = new Event(d1, 0, end1, "event 1");
			e2 = new Event(d1, 0, end2, "event 1");
			assert (!e1.equals(e2));
		}
	}

	@Test
	public void test_unequal_events_different_dates() {
		d1 = new Date(2014, 8, 28);
		Date d2 = new Date(2016, 3, 15);
		e1 = new Event(d1, 12, 12, "event 1");
		e2 = new Event(d2, 12, 12, "event 1");
		assert (!e1.equals(e2));
	}

	@Test
	public void test_unequal_events_different_descriptions() {
		d1 = new Date(2014, 8, 28);
		e1 = new Event(d1, 12, 12, "event 1");
		e2 = new Event(d1, 12, 12, "event 2");
		assert (!e1.equals(e2));
	}

	@Test
	public void test_equal_events() {
		d1 = new Date(2014, 8, 28);
		e1 = new Event(d1, 10, 12, "some events");
		e2 = new Event(d1, 10, 12, "some events");
		assert (e1.equals(e2));
	}

	@Test
	public void test_to_string() {
		d1 = new Date(2014, 8, 28);
		e1 = new Event(d1, 10, 12, "some events");
		System.out.println("Testing To String");
		System.out.println("Expected values: 8/28/2014 10 -- 12: some events");
		System.out.println("Your output: " + e1);
	}
}