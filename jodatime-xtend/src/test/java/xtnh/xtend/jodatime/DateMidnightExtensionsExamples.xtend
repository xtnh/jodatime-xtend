package xtnh.xtend.jodatime

import junit.framework.Assert
import org.joda.time.DateMidnight
import org.junit.Test

import static extension xtnh.xtend.jodatime.DateMidnightExtensions.*

class DateMidnightExtensionsExamples {
	
	@Test
	def example() {
		val date1 = new DateMidnight("2013-01-01")
		val date2 = new DateMidnight("2015-05-31")
		Assert::assertTrue( date2 == date1 + 2.years + 5.months - 1.days )
		Assert::assertEquals( (date2 - date1).millis, (29.months + 1.days).millis )
	}
	
}