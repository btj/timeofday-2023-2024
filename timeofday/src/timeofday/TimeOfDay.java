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
	
	public int getHours() { throw new RuntimeException("Not yet implemented"); }
	
	public int getMinutes() { throw new RuntimeException("Not yet implemented"); }
	
	public int getMinutesSinceMidnight() { throw new RuntimeException("Not yet implemented"); }

	/**
	 * Initialiseert het nieuwe object met de gegeven uren en minuten.
	 * 
	 * @pre | 0 <= initialHours && initialHours <= 23
	 * @pre | 0 <= initialMinutes && initialMinutes <= 59
	 * 
	 * @post | getHours() == initialHours
	 * @post | getMinutes() == initialMinutes
	 */
	public TimeOfDay(int initialHours, int initialMinutes) { throw new RuntimeException("Not yet implemented"); }
	
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
	public void setHours(int newHours) { throw new RuntimeException("Not yet implemented"); }
	
	public void setMinutes(int newMinutes) { throw new RuntimeException("Not yet implemented"); }
	
	/**
	 * Stelt de minuten sinds middernacht in op de gegeven waarde.
	 * 
	 * @pre | 0 <= newMinutesSinceMidnight && newMinutesSinceMidnight < 24 * 60
	 * 
	 * @mutates | this
	 * 
	 * @post | getMinutesSinceMidnight() == newMinutesSinceMidnight
	 */
	public void setMinutesSinceMidnight(int newMinutesSinceMidnight) { throw new RuntimeException("Not yet implemented"); }
	
}
