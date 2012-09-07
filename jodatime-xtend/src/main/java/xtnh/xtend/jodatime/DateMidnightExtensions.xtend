package xtnh.xtend.jodatime

import org.joda.time.DateMidnight
import org.joda.time.Days
import org.joda.time.Months
import org.joda.time.ReadablePeriod
import org.joda.time.Years
import org.joda.time.Period

class DateMidnightExtensions {
	
	def static Days days(int days) {
		Days::days(days) 
	}

	def static Months months(int months) {
		Months::months(months)
	}
	
	def static Years years(int years) {
		Years::years(years)
	}
	
	def static Period operator_plus(ReadablePeriod p1, ReadablePeriod p2) {
		p1.toPeriod.plus(p2).toPeriod
	}
	
	def static Period operator_minus(ReadablePeriod p1, ReadablePeriod p2) {
		p1.toPeriod.minus(p2).toPeriod
	}
	
	def static DateMidnight operator_plus(DateMidnight date, ReadablePeriod period) {
		date.plus(period)
	}
	
	def static DateMidnight operator_minus(DateMidnight date, ReadablePeriod period) {
		date.minus(period)
	}
	
	def static Period operator_minus(DateMidnight date1, DateMidnight date2) {
		new Period(date1, date2)
	}
	
	def static boolean operator_greaterThan(DateMidnight date1, DateMidnight date2) {
		date1.isAfter(date2)
	}
	
	def static boolean operator_lessThan(DateMidnight date1, DateMidnight date2) {
		date1.isBefore(date2)
	}
	
	def static boolean operator_greaterEqualsThan(DateMidnight date1, DateMidnight date2) {
		date1.isAfter(date2) || date1.isEqual(date2)  
	}
	
	def static boolean operator_lessEqualsThan(DateMidnight date1, DateMidnight date2) {
		date1.isBefore(date2) || date1.isEqual(date2)
	}
	
	def static boolean operator_equals(DateMidnight date1, DateMidnight date2) {
		date1.isEqual(date2)
	}
	
	def static boolean operator_notEquals(DateMidnight date1, DateMidnight date2) {
		!date1.isEqual(date2)
	}
	
}