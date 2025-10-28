package edu.sc.csce747.MeetingPlanner;

import static org.junit.Assert.*;
import org.junit.Test;

public class OrganizationTest {
	
	@Test
	public void testGetEmployee_exists() {
		Organization org = new Organization();
		try {
			Person person = org.getEmployee("Greg Gay");
			assertNotNull("Employee should be found", person);
			assertEquals("Greg Gay", person.getName());
		} catch (Exception e) {
			fail("Should not throw exception");
		}
	}
	
	@Test
	public void testGetEmployee_notExists() {
		Organization org = new Organization();
		assertThrows(Exception.class, () -> org.getEmployee("Jane Doe"));
	}
	
	@Test
	public void testGetRoom_exists() {
		Organization org = new Organization();
		try {
			Room room = org.getRoom("2A01");
			assertNotNull("Room should be found", room);
			assertEquals("2A01", room.getID());
		} catch (Exception e) {
			fail("Should not throw exception");
		}
	}
	
	@Test
	public void testGetRoom_notExists() {
		Organization org = new Organization();
		assertThrows(Exception.class, () -> org.getRoom("999"));
	}
}
