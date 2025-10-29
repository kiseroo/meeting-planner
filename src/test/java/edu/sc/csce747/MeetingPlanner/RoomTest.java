package edu.sc.csce747.MeetingPlanner;

import static org.junit.Assert.*;
import org.junit.Test;

public class RoomTest {
	
	@Test
	public void testRoomConstructor() {
		Room room = new Room("A101");
		assertEquals("A101", room.getID());
	}
	
	@Test
	public void testAddMeeting_successful() {
		Room room = new Room("B202");
		Meeting meeting = new Meeting(5, 15, 10, 12);
		
		try {
			room.addMeeting(meeting);
			assertTrue("Room should be busy", room.isBusy(5, 15, 10, 12));
		} catch (TimeConflictException e) {
			fail("Should not throw exception");
		}
	}
	
	@Test
	public void testAddMeeting_timeConflict() {
		Room room = new Room("C303");
		Meeting meeting1 = new Meeting(4, 10, 10, 12);
		meeting1.setDescription("Meeting 1");
		Meeting meeting2 = new Meeting(4, 10, 11, 13);
		meeting2.setDescription("Meeting 2");
		
		try {
			room.addMeeting(meeting1);
			assertThrows(TimeConflictException.class, () -> room.addMeeting(meeting2));
		} catch (TimeConflictException e) {
			fail("First meeting should not throw exception");
		}
	}
}
