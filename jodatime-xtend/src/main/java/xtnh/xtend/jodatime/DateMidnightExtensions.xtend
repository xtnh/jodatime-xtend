package xtnh.xtend.jodatime

import org.joda.time.DateMidnight
import org.joda.time.Days
import org.joda.time.Months
import org.joda.time.ReadablePeriod
import org.joda.time.Years
import org.joda.time.Period

class DateMidnightExtensions {
	
	def Days tage(int tage) {
		Days::days(tage)
	}

	def Months monate(int monate) {
		Months::months(monate)
	}
	
	def Years jahre(int jahre) {
		Years::years(jahre)
	}
	
	def static DateMidnight operator_plus(DateMidnight jetzt, ReadablePeriod monate) {
		jetzt.plus(monate)
	}
	
	def static DateMidnight operator_minus(DateMidnight jetzt, ReadablePeriod monate) {
		jetzt.minus(monate)
	}
	
	def static Period operator_minus(DateMidnight zeitpunkt1, DateMidnight zeitpunkt2) {
		new Period(zeitpunkt1, zeitpunkt2)
	}
	
	def static boolean operator_greaterThan(DateMidnight zeitpunkt1, DateMidnight zeitpunkt2) {
		zeitpunkt1.isAfter(zeitpunkt2)
	}
	
	def static boolean operator_lessThan(DateMidnight zeitpunkt1, DateMidnight zeitpunkt2) {
		zeitpunkt1.isBefore(zeitpunkt2)
	}
	
	def static boolean operator_greaterEqualsThan(DateMidnight zeitpunkt1, DateMidnight zeitpunkt2) {
		zeitpunkt1.isAfter(zeitpunkt2) || zeitpunkt1.isEqual(zeitpunkt2)  
	}
	
	def static boolean operator_lessEqualsThan(DateMidnight zeitpunkt1, DateMidnight zeitpunkt2) {
		zeitpunkt1.isBefore(zeitpunkt2) || zeitpunkt1.isEqual(zeitpunkt2)
	}
	
	def static boolean operator_equals(DateMidnight zeitpunkt1, DateMidnight zeitpunkt2) {
		zeitpunkt1.isEqual(zeitpunkt2)
	}
	
	def static boolean operator_notEquals(DateMidnight zeitpunkt1, DateMidnight zeitpunkt2) {
		!zeitpunkt1.isEqual(zeitpunkt2)
	}
	
}