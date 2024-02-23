package timeofday;

// Hoe ontwikkel ik een data-abstractie?
// 1. De API definiëren: hoe kunnen & moeten klanten de abstractie gebruiken?
//    a. Korte informele documentatie bij klasse zelf: wat slaat een instantie op (mutable abstraction) of stelt een instantie voor (immutable abstraction)?
//    b. De rauwe abstractetoestandsruimte definiëren: de inspectoren (= getters) declareren
//    c. De geldige abstractetoestandsruimte definiëren: de abstractetoestandsinvarianten definiëren
//    d. De constructoren en mutatoren declareren
// 2. De abstractie implementeren in termen van Java-constructies: velden en method/constructor bodies toevoegen.

/**
 * Elke instantie van deze klasse stelt een tijdstip voor, gegeven door een aantal uren sinds middernacht en een aantal minuten binnen het uur.
 * 
 * @invar | getMinutesSinceMidnight() == getHours() * 60 + getMinutes()
 * @invar | 0 <= getHours() && getHours() <= 23
 * @invar | 0 <= getMinutes() && getMinutes() <= 59
 * 
 * @immutable
 */
public class TimeOfDay {
	
	/**
	 * @invar | 0 <= minutesSinceMidnight && minutesSinceMidnight < 24 * 60
	 */
	private int minutesSinceMidnight;
	
	public int getHours() { return minutesSinceMidnight / 60; }
	
	public int getMinutes() { return minutesSinceMidnight % 60; }
	
	public int getMinutesSinceMidnight() { return minutesSinceMidnight; }

	/**
	 * Initialiseert het nieuwe object met de gegeven uren en minuten.
	 * 
	 * @throws IllegalArgumentException | !(0 <= initialHours && initialHours <= 23)
	 * @throws IllegalArgumentException | !(0 <= initialMinutes && initialMinutes <= 59)
	 * 
	 * @post | getHours() == initialHours
	 * @post | getMinutes() == initialMinutes
	 */
	public TimeOfDay(int initialHours, int initialMinutes) {
		if (initialHours < 0)
			throw new IllegalArgumentException("`initialHours` is less than zero");
		if (initialHours > 23)
			throw new IllegalArgumentException("`initialHours` is greater than 59");
		if (initialMinutes < 0 || 59 < initialMinutes)
			throw new IllegalArgumentException("`initialMinutes` is out of range");
		
		minutesSinceMidnight = initialHours * 60 + initialMinutes;
	}
	
	/**
	 * Returns a new TimeOfDay object whose minutes are the given minutes and whose hours are this object's hours.
	 * 
	 * @pre | 0 <= newMinutes && newMinutes < 60
	 * @post | result != null
	 * @post | result.getHours() == getHours()
	 * @post | result.getMinutes() == newMinutes 
	 */
	public TimeOfDay withMinutes(int newMinutes) {
		throw new RuntimeException("Not yet implemented");
	}
	
}
