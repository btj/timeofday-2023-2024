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
	 * @pre | 0 <= initialHours && initialHours <= 23
	 * @pre | 0 <= initialMinutes && initialMinutes <= 59
	 * 
	 * @post | getHours() == initialHours
	 * @post | getMinutes() == initialMinutes
	 */
	public TimeOfDay(int initialHours, int initialMinutes) { 
		minutesSinceMidnight = initialHours * 60 + initialMinutes;
	}
	
	/**
	 * Stelt de uren van dit object in op de gegeven uren.
	 * 
	 * @pre | 0 <= newHours && newHours <= 23
	 * 
	 * @mutates | this
	 * 
	 * @post | getHours() == newHours
	 * @post | getMinutes() == old(getMinutes())
	 */
	public void setHours(int newHours) { minutesSinceMidnight = newHours * 60 + getMinutes(); }
	
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
