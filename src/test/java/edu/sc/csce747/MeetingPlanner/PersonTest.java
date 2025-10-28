package edu.sc.csce747.MeetingPlanner;

import static org.junit.Assert.*;
import org.junit.Test;

public class PersonTest {
	
	@Test
	public void testPersonConstructor() {
		Person person = new Person("John Smith");
		assertEquals("John Smith", person.getName());
	}
	
	@Test
	public void testAddMeeting_successful() {
		Person person = new Person("Alice");
		Meeting meeting = new Meeting(5, 15, 10, 12);
		
		try {
			person.addMeeting(meeting);
			assertTrue("Person should be busy", person.isBusy(5, 15, 10, 12));
		} catch (TimeConflictException e) {
			fail("Should not throw exception");
		}
	}
	
	@Test
	public void testAddMeeting_timeConflict() {
		Person person = new Person("Bob");
		Meeting meeting1 = new Meeting(4, 10, 10, 12);
		Meeting meeting2 = new Meeting(4, 10, 11, 13);
		
		try {
			person.addMeeting(meeting1);
			assertThrows(TimeConflictException.class, () -> person.addMeeting(meeting2));
		} catch (TimeConflictException e) {
			fail("First meeting should not throw exception");
		}
	}
}
