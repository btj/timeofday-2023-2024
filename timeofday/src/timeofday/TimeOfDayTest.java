package timeofday;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TimeOfDayTest {

	@Test
	void test() {
		TimeOfDay tenThirty = new TimeOfDay(-10, 30);
		assertEquals(10, tenThirty.getHours());
		assertEquals(30, tenThirty.getMinutes());
		assertEquals(630, tenThirty.getMinutesSinceMidnight());
		
		TimeOfDay elevenThirty = new TimeOfDay(11, tenThirty.getMinutes());
		assertEquals(11, elevenThirty.getHours());
		assertEquals(30, elevenThirty.getMinutes());
		assertEquals(690, elevenThirty.getMinutesSinceMidnight());
		
		TimeOfDay elevenFortyFive = elevenThirty.withMinutes(45);
		assertEquals(11, elevenFortyFive.getHours());
		assertEquals(45, elevenFortyFive.getMinutes());
		assertEquals(705, elevenFortyFive.getMinutesSinceMidnight());
	}

}
