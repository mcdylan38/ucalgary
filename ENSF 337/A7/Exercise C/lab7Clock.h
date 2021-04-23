/* lab7Clock.h
 * ENSF337 - Lab 7 Exercise C
 */

#ifndef lab7Clock_h
#define lab7Clock_h

class Clock{
	private:
	int hour;
	int minute;
	int second;
	
	void hms_to_sec();
	/* PROMISES: Converts hours, minutes, seconds format to seconds */
	void sec_to_hms();
	/* PROMISES: Converst seconds into hours, minutes and seconds */
	
	// ----- //
	
	public:
	Clock(): hour(0), minute(0), second(0) {}	//Setting hour, minute and second to 0
	Clock(int s);
	/* REQUIRES: second are not negative
	   PROMISES: Sets second to s and converts seconds to hours, minutes and seconds */
	   
	Clock(int h, int m, int s);
	/* REQUIRES: second, minute and hour are not negative, second and minute are less than 60 and hour is less than 24
	   PROMISES: Sets hour to h, sets minute to m and sets second to s */
	
	int get_hour() const;
	/* PROMISES: retrieves hour value */
	 
	void set_hour(int h);
	/* REQUIRES: h does not exceed 23
	   PROMISES: sets hour to h */
	 
	int get_minute() const;
	/* PROMISES: retrieves minute value */
	 
	void set_minute(int m);
	/* REQUIRES: m does not exceed 59
	   PROMISES: sets minute to m */
	 
	int get_second() const;
	/* PROMISES: retrives second value */
	 
	void set_second(int s);
	/* REQUIRES: s does not exceed 59
	   PROMISES: sets second to s */
	 
	void increment();
	/* PROMISES: increases second by 1 */
	 
	void decrement();
	/* PROMISES: decreases second by 1 */
	 
	void add_seconds(int s);
	/* REQUIRES: s is positive
	   PROMISES: converts time to seconds and adds s */	 
};

#endif /* lab7Clock_h */