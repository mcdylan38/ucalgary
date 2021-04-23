/* lab7Clock.cpp
 * ENSF337 - Lab 7 Exercise C
 */

#include "lab7Clock.h"

//Public functions
Clock::Clock(int s): second(s){	
	if(s<0){
		set_second(0);
	}
	
	sec_to_hms();
}

Clock::Clock(int h, int m, int s): hour(h), minute(m), second(s){
	if(h<0 || h>23 || m<0 || m>59 || s<0 || s>59){
		set_hour(0);
		set_minute(0);
		set_second(0);
	}
}

int Clock::get_hour() const{
	return hour;
}

void Clock::set_hour(int h){
	if(h>=0 && h<=23){
		hour=h;
	}
}

int Clock::get_minute() const{
	return minute;
}

void Clock::set_minute(int m){
	if(m>=0 && m<=59){
		minute=m;
	}
}

int Clock::get_second() const{
	return second;
}

void Clock::set_second(int s){
	if(s>=0 && s<=59){
		second=s;
	}
}

void Clock::increment(){
	hms_to_sec();
	second++;
	sec_to_hms();
}

void Clock::decrement(){
	hms_to_sec();
	second--;
	sec_to_hms();
}

void Clock::add_seconds(int s){
	if(s>=0){
		hms_to_sec();
		second+=s;
		sec_to_hms();
	}
}

//Private functions
void Clock::hms_to_sec(){
	second=hour*3600 + minute*60 + second;
}

void Clock::sec_to_hms(){	
	hour=second/3600;
	minute=(second - 3600*hour)/60;
	second=second - 3600*hour - 60*minute;
	
	while(hour>23){	  //Reducing hour to be less 23
		hour-=24;
	}
	while(minute>59){   //Reducing minute to be less than 59
		minute-=60;
		hour++;
	}
	while(second>59){   //Reducing second to be less than 59
		second-=60;
		minute++;
	}
	
	if(second==-1){   //If decrement makes second negative, rewinds CLOCK by a day
		hour=23;
		minute=59;
		second=59;
	}
}
