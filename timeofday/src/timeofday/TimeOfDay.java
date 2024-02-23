package timeofday;

// Hoe ontwikkel ik een data-abstractie?
// 1. De API definiëren: hoe kunnen & moeten klanten de abstractie gebruiken?
//    a. Korte informele documentatie bij klasse zelf: wat slaat een instantie op (mutable abstraction) of stelt een instantie voor (immutable abstraction)?
//    b. De rauwe abstractetoestandsruimte definiëren: de inspectoren (= getters) declareren
//    c. De geldige abstractetoestandsruimte definiëren: de abstractetoestandsinvarianten definiëren
//    d. De constructoren en mutatoren declareren
//    e. De constructoren en mutatoren documenteren: precondities en postcondities (resultaat en neveneffecten (= nieuwe toestand gewijzigde objecten))
// 2. De abstractie implementeren in termen van Java-constructies: velden en method/constructor bodies toevoegen.
//    a. Een representatie kiezen
//       i. Rauwe concretetoestandsruimte definiëren = velden introduceren
//       ii. Geldige concretetoestandsruimte definiëren = concretetoestandsinvarianten noteren (= @invar-clausules bij de velden)
//       iii. Abstractierelatie definiëren = getters implementeren
//       Sanity checks:
//       1) De getters mogen voor geen enkele geldige concrete toestand crashen
//       2) De getters moeten elke geldige concrete toestand afbeelden op een geldige abstracte toestand
//    b. Implementeren van (= code schrijven voor) de constructoren en mutatoren

/**
 * Elke instantie van deze klasse slaat een tijdstip op, gegeven door een aantal uren sinds middernacht en een aantal minuten binnen het uur.
 * 
 * @invar | getMinutesSinceMidnight() == getHours() * 60 + getMinutes()
 * @invar | 0 <= getHours() && getHours() <= 23
 * @invar | 0 <= getMinutes() && getMinutes() <= 59
 */
public class TimeOfDay {
	
	/**
	 * @invar | 0 <= hours && hours <= 23
	 * @invar | 0 <= minutes && minutes <= 59
	 */
	private int hours;
	private int minutes;
	
	public int getHours() { return hours; }
	
	public int getMinutes() { return minutes; }
	
	public int getMinutesSinceMidnight() { return hours * 60 + minutes; }

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
		hours = initialHours;
		minutes = initialMinutes;
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
	public void setHours(int newHours) { hours = newHours; }
	
	public void setMinutes(int minutes) { this.minutes = minutes; }
	
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
		hours = newMinutesSinceMidnight / 60;
		minutes = newMinutesSinceMidnight % 60;
	}
	
}
