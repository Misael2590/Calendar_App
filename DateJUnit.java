import org.junit.Test;


public class DateJUnit {

	private static Date d1;
	private static Date d2;

	@Test
	public void test_get_year() {
		d1 = new Date(2017, 8, 23);
		assert (d1.getYear() == 2017);
	}
	
	@Test
	public void test_get_year_random() {
		for(int i = 0; i < 1000; i++) {
			int year = (int)(Math.random() * 7) + 2014;
			d1 = new Date(year, 8, 28);
			assert(d1.getYear() == year);
		}
	}

	@Test
	public void test_get_month() {
		d1 = new Date(2017, 8, 23);
		assert (d1.getMonth() == 8);
	}
	
	@Test
	public void test_get_month_random() {
		for(int i = 0; i < 1000; i++) {
			int month = (int)(Math.random() * 12) + 1;
			d1 = new Date(2014, month, 28);
			assert(d1.getMonth() == month);
		}
	}

	@Test
	public void test_get_day() {
		d1 = new Date(2017, 8, 23);
		assert (d1.getDay() == 23);
	}
	
	@Test
	public void test_get_day_random() {
		for(int i = 0; i < 1000; i++) {
			int day = (int)(Math.random() * 31) + 1;
			d1 = new Date(2014, 8, day);
			assert(d1.getDay() == day);
		}
	}

	@Test
	public void test_to_string() {
		d1 = new Date(2017, 8, 23);
		System.out.println("Testing Date toString Method");
		System.out.println("Date should be 8/23/2017");
		System.out.println("Your date: " + d1);
	}

	/**
	 * This test creates an invalid date object with an invalid year that should
	 * throw an IllegalArgumentException.
	 * 
	 * If no exception is thrown then the test fails.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void test_invalid_year_2012() {
		d1 = new Date(2012, 8, 28);
	}

	/**
	 * This test creates an invalid date object with an invalid year that should
	 * throw an IllegalArgumentException.
	 * 
	 * If no exception is thrown then the test fails.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void test_invalid_year_2021() {
		d1 = new Date(2021, 8, 28);
	}

	/**
	 * This test creates an invalid date object with an invalid month that should
	 * throw an IllegalArgumentException.
	 * 
	 * If no exception is thrown then the test fails.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void test_invalid_month_0() {
		d1 = new Date(2014, 0, 28);
	}

	/**
	 * This test creates an invalid date object with an invalid month that should
	 * throw an IllegalArgumentException.
	 * 
	 * If no exception is thrown then the test fails.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void test_invalid_month_13() {
		d1 = new Date(2014, 13, 28);
	}

	/**
	 * This test creates an invalid date object with an invalid day that should
	 * throw an IllegalArgumentException.
	 * 
	 * If no exception is thrown then the test fails.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void test_invalid_day_0() {
		d1 = new Date(2014, 12, 0);
	}

	/**
	 * This test creates an invalid date object with an invalid day that should
	 * throw an IllegalArgumentException.
	 * 
	 * If no exception is thrown then the test fails.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void test_invalid_day_33() {
		d1 = new Date(2014, 12, 33);
	}

	/**
	 * This test creates a valid date object.
	 * 
	 * If an exception is thrown the test fails.
	 */
	@Test
	public void test_valid_date() {
		d1 = new Date(2015, 8, 28);
	}

	/**
	 * This tests the equals method two non equal Date objects in which their years
	 * are different.
	 * 
	 * If true is returned by the equals method the test fails.
	 */
	@Test
	public void test_non_equal_dates_year() {
		d1 = new Date(2014, 8, 28);
		d2 = new Date(2015, 8, 28);
		assert (!d1.equals(d2));
	}
	
	@Test
	public void test_non_equal_random_years() {
		for(int i = 0; i < 1000; i++) {
			//random between 2014 and 2017 inclusive
			int year1 = (int)(Math.random() * 4) + 2014;
			//random between 2018 and 2020 inclusive
			int year2 = (int)(Math.random() * 3) + 2018;
			d1 = new Date(year1, 8, 28);
			d2 = new Date(year2, 8, 28);
			assert(!d1.equals(d2));
		}
	}

	/**
	 * This tests the equals method two non equal Date objects in which their months
	 * are different.
	 * 
	 * If true is returned by the equals method the test fails.
	 */
	@Test
	public void test_non_equal_dates_months() {
		d1 = new Date(2014, 9, 28);
		d2 = new Date(2014, 8, 28);
		assert (!d1.equals(d2));
	}
	
	@Test
	public void test_non_equal_random_months() {
		for(int i = 0; i < 1000; i++) {
			//random between 1 and 6 inclusive
			int month1 = (int)(Math.random() * 6) + 1;
			//random between 7 and 12 inclusive
			int month2 = (int)(Math.random() * 6) + 7;
			d1 = new Date(2014, month1, 28);
			d2 = new Date(2014, month2, 28);
			assert(!d1.equals(d2));
		}
	}

	/**
	 * This tests the equals method two non equal Date objects in which their days
	 * are different.
	 * 
	 * If true is returned by the equals method the test fails.
	 */
	@Test
	public void test_non_equal_dates_days() {
		d1 = new Date(2014, 9, 28);
		d2 = new Date(2014, 9, 15);
		assert (!d1.equals(d2));
	}
	
	@Test
	public void test_non_equal_random_days() {
		for(int i = 0; i < 1000; i++) {
			//random between 1 and 15 inclusive
			int day1 = (int)(Math.random() * 15) + 1;
			//random between 16 and 31 inclusive
			int day2 = (int)(Math.random() * 16) + 16;
			d1 = new Date(2014, 8, day1);
			d2 = new Date(2014, 8, day2);
			assert(!d1.equals(d2));
		}
	}

	/**
	 * This test tests the equals method of two equal Date objects.
	 * 
	 * If false is returned by the equals method the test fails.
	 */
	@Test
	public void test_equal_dates() {
		d1 = new Date(2014, 8, 28);
		d2 = new Date(2014, 8, 28);
		assert (d1.equals(d2));
	}

	/**
	 * This tests the compareTo method for Date objects in which a year is greater
	 * than another year.
	 * 
	 * If anything less than or equal to zero is returned the test fails.
	 */
	
	@Test
	public void test_compareto_years_greater_than_zero() {
		d1 = new Date(2015, 8, 28);
		d2 = new Date(2014, 8, 16);
		assert (d1.compareTo(d2) > 0);
	}
	
	@Test
	public void test_compareto_random_years_greater_than_zero() {
		for(int i = 0; i < 1000; i++) {
			//random between 2014 and 2017 inclusive
			int year1 = (int)(Math.random() * 4) + 2014;
			//random between 2018 and 2020 inclusive
			int year2 = (int)(Math.random() * 3) + 2018;
			d1 = new Date(year1, 8, 28);
			d2 = new Date(year2, 8, 28);
			assert(d2.compareTo(d1) > 0);
		}
	}

	/**
	 * This tests the compareTo method for Date objects in which a year is less than
	 * another year.
	 * 
	 * If anything greater than or equal to zero is returned the test fails.
	 */
	@Test
	public void test_compareto_years_less_than_zero() {
		d1 = new Date(2015, 8, 28);
		d2 = new Date(2014, 8, 16);
		assert (d2.compareTo(d1) < 0);
	}
	@Test
	public void test_compareto_random_years_less_than_zero() {
		for(int i = 0; i < 1000; i++) {
			//random between 2014 and 2017 inclusive
			int year1 = (int)(Math.random() * 4) + 2014;
			//random between 2018 and 2020 inclusive
			int year2 = (int)(Math.random() * 3) + 2018;
			d1 = new Date(year1, 8, 28);
			d2 = new Date(year2, 8, 28);
			assert(d1.compareTo(d2) < 0);
		}
	}

	/**
	 * This tests the compareTo method for Date objects in which a month is greater
	 * than another month.
	 * 
	 * If anything less than or equal to zero is returned the test fails.
	 */
	
	@Test
	public void test_compareto_months_greater_than_zero() {
		d1 = new Date(2014, 9, 28);
		d2 = new Date(2014, 8, 16);
		assert (d1.compareTo(d2) > 0);
	}

	@Test
	public void test_compareto_random_months_greater_than_zero() {
		for(int i = 0; i < 1000; i++) {
			//random between 1 and 6 inclusive
			int month1 = (int)(Math.random() * 6) + 1;
			//random between 7 and 12 inclusive
			int month2 = (int)(Math.random() * 6) + 7;
			d1 = new Date(2014, month1, 28);
			d2 = new Date(2014, month2, 28);
			assert(d2.compareTo(d1) > 0);
		}
	}

	/**
	 * This tests the compareTo method for Date objects in which a month is less
	 * than another month.
	 * 
	 * If anything greater than or equal to zero is returned the test fails.
	 */
	@Test
	public void test_compareto_months_less_than_zero() {
		d1 = new Date(2014, 9, 28);
		d2 = new Date(2014, 8, 16);
		assert (d2.compareTo(d1) < 0);
	}
	
	@Test
	public void test_compareto_random_months_less_than_zero() {
		for(int i = 0; i < 1000; i++) {
			//random between 1 and 6 inclusive
			int month1 = (int)(Math.random() * 6) + 1;
			//random between 7 and 12 inclusive
			int month2 = (int)(Math.random() * 6) + 7;
			d1 = new Date(2014, month1, 28);
			d2 = new Date(2014, month2, 28);
			assert(d1.compareTo(d2) < 0);
		}
	}

	/**
	 * This tests the compareTo method for Date objects in which a day is greater
	 * than another day.
	 * 
	 * If anything less than or equal to zero is returned the test fails.
	 */
	
	@Test
	public void test_compareto_days_greater_than_zero() {
		d1 = new Date(2014, 8, 28);
		d2 = new Date(2014, 8, 16);
		assert (d1.compareTo(d2) > 0);
	}

	@Test
	public void test_compareto_random_days_greater_than_zero() {
		for(int i = 0; i < 1000; i++) {
			//random between 1 and 15 inclusive
			int day1 = (int)(Math.random() * 15) + 1;
			//random between 16 and 31 inclusive
			int day2 = (int)(Math.random() * 16) + 16;
			d1 = new Date(2014, 8, day1);
			d2 = new Date(2014, 8, day2);
			assert(d2.compareTo(d1) > 0);
		}
	}

	/**
	 * This tests the compareTo method for Date objects in which a day is less than
	 * another day.
	 * 
	 * If anything greater than or equal to zero is returned the test fails.
	 */
	
	@Test
	public void test_compareto_days_less_than_zero() {
		d1 = new Date(2014, 8, 28);
		d2 = new Date(2014, 8, 16);
		assert (d2.compareTo(d1) < 0);
	}
	
	@Test
	public void test_compareto_random_days_less_than_zero() {
		for(int i = 0; i < 1000; i++) {
			//random between 1 and 15 inclusive
			int day1 = (int)(Math.random() * 15) + 1;
			//random between 16 and 31 inclusive
			int day2 = (int)(Math.random() * 16) + 16;
			d1 = new Date(2014, 8, day1);
			d2 = new Date(2014, 8, day2);
			assert(d1.compareTo(d2) < 0);
		}
	}

	/**
	 * This tests the compareTo method for two Dates that are the same.
	 * 
	 * If anything but 0 is returned the test fails.
	 */
	
	@Test
	public void test_compareto_equal_zero() {
		d1 = new Date(2014, 8, 28);
		d2 = new Date(2014, 8, 28);
		assert (d1.compareTo(d2) == 0);
	}

}