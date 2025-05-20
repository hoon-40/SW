package student;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StudentManagerTest {
	
	StudentManager sm;
	
	@BeforeEach
	void setUp() throws Exception {
		sm = new StudentManager();
		
	}

	@Test
	void testAddStudent() {
		sm.addStudent("이");
		assertTrue(sm.hasStudent("이"));
	}

	@Test
	void testRemoveStudent() {
		sm.addStudent("이");
		sm.removeStudent("이");
		assertFalse(sm.hasStudent("이"));
	}

	@Test
	void testexception() {
		sm.addStudent("이");
		assertTrue(sm.hasStudent("이"));
		assertThrows(IllegalArgumentException.class, () -> sm.addStudent("이"));
		
	}
	

	@Test
	void testremove() {

		assertThrows(IllegalArgumentException.class, () -> sm.removeStudent("김"));}
	}
	


