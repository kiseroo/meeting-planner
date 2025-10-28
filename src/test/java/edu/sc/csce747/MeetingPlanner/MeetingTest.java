package edu.sc.csce747.MeetingPlanner;

import static org.junit.Assert.*;
import org.junit.Test;

public class MeetingTest {
	
	@Test
	public void testMeetingConstructor() {
		Meeting meeting = new Meeting(6, 15, 9, 17);
		assertEquals(6, meeting.getMonth());
		assertEquals(15, meeting.getDay());
		assertEquals(9, meeting.getStartTime());
		assertEquals(17, meeting.getEndTime());
	}
	
	@Test
	public void testSetGetDescription() {
		Meeting meeting = new Meeting();
		meeting.setDescription("Team Meeting");
		assertEquals("Team Meeting", meeting.getDescription());
	}
}
