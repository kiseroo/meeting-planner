package edu.sc.csce747.MeetingPlanner;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class CalendarTest {
	private Calendar calendar;
	
	@Before
	public void setUp() {
		calendar = new Calendar();
	}
	
	// ========== VALID TEST CASES ==========
	
	@Test
	public void testAddMeeting_holiday() {
		try {
			Meeting midsommar = new Meeting(6, 26, "Midsommar");
			calendar.addMeeting(midsommar);
			assertTrue("Midsommar should be marked as busy", calendar.isBusy(6, 26, 0, 23));
		} catch(TimeConflictException e) {
			fail("Should not throw exception: " + e.getMessage());
		}
	}
	
	@Test
	public void testAddMeeting_validMeeting() {
		try {
			Meeting meeting = new Meeting(3, 15, 9, 10);
			calendar.addMeeting(meeting);
			assertTrue("Meeting should be added", calendar.isBusy(3, 15, 9, 10));
		} catch(TimeConflictException e) {
			fail("Should not throw exception: " + e.getMessage());
		}
	}
	
	// ========== INVALID TEST CASES ==========
	
	@Test
	public void testAddMeeting_february35() {
		Meeting meeting = new Meeting(2, 35, 10, 12);
		assertThrows(TimeConflictException.class, () -> calendar.addMeeting(meeting));
	}
	
	@Test
	public void testAddMeeting_invalidMonth13() {
		Meeting meeting = new Meeting(13, 15, 10, 12);
		assertThrows(TimeConflictException.class, () -> calendar.addMeeting(meeting));
	}
	
	@Test
	public void testAddMeeting_negativeHour() {
		Meeting meeting = new Meeting(5, 15, -1, 12);
		assertThrows(TimeConflictException.class, () -> calendar.addMeeting(meeting));
	}
	
	@Test
	public void testAddMeeting_hour24() {
		Meeting meeting = new Meeting(5, 15, 10, 24);
		assertThrows(TimeConflictException.class, () -> calendar.addMeeting(meeting));
	}
	
	@Test
	public void testAddMeeting_startAfterEnd() {
		Meeting meeting = new Meeting(5, 15, 15, 10);
		assertThrows(TimeConflictException.class, () -> calendar.addMeeting(meeting));
	}
	
	@Test
	public void testAddMeeting_timeConflict() {
		try {
			Meeting meeting1 = new Meeting(6, 20, 10, 12);
			calendar.addMeeting(meeting1);
			
			Meeting meeting2 = new Meeting(6, 20, 10, 12);
			assertThrows(TimeConflictException.class, () -> calendar.addMeeting(meeting2));
		} catch(TimeConflictException e) {
			fail("First meeting should not throw exception");
		}
	}
}
