package timeofday;

// Hoe ontwikkel ik een data-abstractie?
// 1. De API definiëren: hoe kunnen & moeten klanten de abstractie gebruiken?
//    a. Korte informele documentatie bij klasse zelf: wat slaat een instantie op (mutable abstraction) of stelt een instantie voor (immutable abstraction)?
//    b. De rauwe abstractetoestandsruimte definiëren: de inspectoren (= getters) declareren
//    c. De geldige abstractetoestandsruimte definiëren: de abstractetoestandsinvarianten definiëren
//    d. De constructoren en mutatoren declareren
// 2. De abstractie implementeren in termen van Java-constructies: velden en method/constructor bodies toevoegen.

/**
 * Elke instantie van deze klasse slaat een tijdstip op, gegeven door een aantal uren sinds middernacht en een aantal minuten binnen het uur.
 * 
 * @invar | getMinutesSinceMidnight() == getHours() * 60 + getMinutes()
 * @invar | 0 <= getHours() && getHours() <= 23
 * @invar | 0 <= getMinutes() && getMinutes() <= 59
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
	 * Stelt de uren van dit object in op de gegeven uren.
	 * 
	 * @throws IllegalArgumentException | !(0 <= newHours && newHours <= 23)
	 * 
	 * @mutates | this
	 * 
	 * @post | getHours() == newHours
	 * @post | getMinutes() == old(getMinutes())
	 */
	public void setHours(int newHours) {
		if (newHours < 0)
			throw new IllegalArgumentException("`newHours` is less than 0");
		if (23 < newHours)
			throw new IllegalArgumentException("`newHours` is greater than 23");
		
		minutesSinceMidnight = newHours * 60 + getMinutes();
	}
	
	public void setMinutes(int newMinutes) {
		minutesSinceMidnight -= getMinutes();
		minutesSinceMidnight += newMinutes;
	}
	
	/**
	 * Stelt de minuten sinds middernacht in op de gegeven waarde.
	 * 
	 * @pre | 0 <= newMinutesSinceMidnight && newMinutesSinceMidnight < 24 * 60
	 * 
	 * @mutates | this
	 * 
	 * @post | getMinutesSinceMidnight() == newMinutesSinceMidnight
	 */
	public void setMinutesSinceMidnight(int newMinutesSinceMidnight) {
		minutesSinceMidnight = newMinutesSinceMidnight;
	}
	
}
