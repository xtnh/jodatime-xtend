package xtnh.xtend.jodatime

import junit.framework.Assert
import org.joda.time.DateMidnight
import org.joda.time.Days
import org.joda.time.Months
import org.joda.time.Years
import org.junit.Before
import org.junit.Test

import static extension xtnh.xtend.jodatime.DateMidnightExtensions.*

class DateMidnightExtensionsTest {
	
	DateMidnight defaultDate
	DateMidnight compareDate
	
	@Before
	def void beforeTest() {
		defaultDate = new DateMidnight("2012-12-01")
		compareDate = new DateMidnight("2011-12-01")
	}
	
	@Test
	def testDays() {
		Assert::assertEquals(Days::ONE, 1.days)
	}
	
	@Test
	def testMonths() {
		Assert::assertEquals(Months::ONE, 1.months)
	}
	
	@Test
	def testYears() {
		Assert::assertEquals(Years::ONE, 1.years)
	}
	
	@Test
	def testDateMidnightPlusPeriod() {
		Assert::assertEquals(new DateMidnight("2012-12-02"), defaultDate + 1.days)
		Assert::assertEquals(new DateMidnight("2013-01-01"), defaultDate + 1.months)
		Assert::assertEquals(new DateMidnight("2013-12-01"), defaultDate + 1.years)
	}

	@Test
	def testDateMidnightMinusPeriod() {
		Assert::assertEquals(new DateMidnight("2012-11-30"), defaultDate - 1.days)
		Assert::assertEquals(new DateMidnight("2012-11-01"), defaultDate - 1.months)
		Assert::assertEquals(new DateMidnight("2011-12-01"), defaultDate - 1.years)
	}
	
	@Test
	def testDateMidnightMinus() {
		val actual = compareDate - defaultDate
		Assert::assertEquals(1.years.toPeriod, actual)
	}
	
	@Test
	def testDateMidnightGreaterThan() {
		Assert::assertTrue(defaultDate > compareDate)
	}
	
	@Test
	def testDateMidnightLessThan() {
		Assert::assertTrue(compareDate < defaultDate)
	}
	
	@Test
	def testDateMidnightGreaterEqualsThan() {
		Assert::assertTrue(defaultDate >= compareDate)
		Assert::assertTrue(new DateMidnight("2011-12-01") >= compareDate)
		Assert::assertFalse(new DateMidnight("2011-11-30") >= compareDate)
	}
	
	@Test
	def testDateMidnightLessEqualsThan() {
		Assert::assertTrue(compareDate < defaultDate)
		Assert::assertTrue(new DateMidnight("2012-12-01") <= defaultDate)
		Assert::assertFalse(new DateMidnight("2012-12-02") <= defaultDate)
	}
	
	@Test
	def testDateMidnightEquals() {
		Assert::assertTrue(defaultDate == new DateMidnight("2012-12-01"))
		Assert::assertFalse(defaultDate == compareDate)
	}
	
	@Test
	def testDateMidnightNotEquals() {
		Assert::assertTrue(defaultDate != compareDate)
		Assert::assertFalse(defaultDate != new DateMidnight("2012-12-01"))
	}
	
}