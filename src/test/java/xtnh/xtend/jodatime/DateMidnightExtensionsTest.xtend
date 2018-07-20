package xtnh.xtend.jodatime

import junit.framework.Assert
import org.joda.time.DateMidnight
import org.joda.time.Days
import org.joda.time.Months
import org.joda.time.Years
import org.junit.Before
import org.junit.Test

import static extension xtnh.xtend.jodatime.DateMidnightExtensions.*
import java.util.NoSuchElementException

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
	def testWeeks() {
		Assert::assertEquals(Days::SEVEN, 1.weeks)
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
		Assert::assertEquals(new DateMidnight("2012-12-08"), defaultDate + 1.weeks)
		Assert::assertEquals(new DateMidnight("2013-01-01"), defaultDate + 1.months)
		Assert::assertEquals(new DateMidnight("2013-12-01"), defaultDate + 1.years)
	}

	@Test
	def testDateMidnightMinusPeriod() {
		Assert::assertEquals(new DateMidnight("2012-11-30"), defaultDate - 1.days)
		Assert::assertEquals(new DateMidnight("2012-11-24"), defaultDate - 1.weeks)
		Assert::assertEquals(new DateMidnight("2012-11-01"), defaultDate - 1.months)
		Assert::assertEquals(new DateMidnight("2011-12-01"), defaultDate - 1.years)
	}
	
	@Test
	def void testPeriodPlusPeriod() {
		Assert::assertEquals(3.days.days, (2.days + 1.days).days)
	}
	
	@Test
	def void testPeriodMinusPeriod() {
		Assert::assertEquals(1.days.days, (2.days - 1.days).days)
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
		Assert::assertTrue(compareDate >= compareDate)
		Assert::assertTrue(new DateMidnight("2011-12-01") >= compareDate)
		Assert::assertFalse(new DateMidnight("2011-11-30") >= compareDate)
	}
	
	@Test
	def testDateMidnightLessEqualsThan() {
		Assert::assertTrue(compareDate <= defaultDate)
		Assert::assertTrue(compareDate <= compareDate)
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
	
	@Test
	def testDateMidnightRange() {
		// step = 1 day
		var iterator = (defaultDate..defaultDate).iterator
		Assert::assertTrue(iterator.hasNext)
		Assert::assertTrue(iterator.next == defaultDate)
		Assert::assertFalse(iterator.hasNext)

		// step = 1 year
		var compareDate = defaultDate + 2.years + 5.months - 1.days 		
		iterator = (defaultDate..compareDate).withStep(1.years).iterator
		Assert::assertTrue(iterator.hasNext)
		Assert::assertTrue(iterator.next == defaultDate)
		Assert::assertTrue(iterator.hasNext)
		Assert::assertTrue(iterator.next == defaultDate + 1.years)
		Assert::assertTrue(iterator.hasNext)
		Assert::assertTrue(iterator.next == defaultDate + 2.years)
		Assert::assertFalse(iterator.hasNext)
		
		// step = 1 month
		compareDate = defaultDate + 2.months - 1.days 		
		iterator = (defaultDate..compareDate).withStep(1.months).iterator
		Assert::assertTrue(iterator.hasNext)
		Assert::assertTrue(iterator.next == defaultDate)
		Assert::assertTrue(iterator.hasNext)
		Assert::assertTrue(iterator.next == defaultDate + 1.months)
		Assert::assertFalse(iterator.hasNext)
		
		// step = 1 week
		compareDate = defaultDate + 20.days 		
		iterator = (defaultDate..compareDate).withStep(1.weeks).iterator
		Assert::assertTrue(iterator.hasNext)
		Assert::assertTrue(iterator.next == defaultDate)
		Assert::assertTrue(iterator.hasNext)
		Assert::assertTrue(iterator.next == defaultDate + 1.weeks)
		Assert::assertTrue(iterator.hasNext)
		Assert::assertTrue(iterator.next == defaultDate + 2.weeks)
		Assert::assertFalse(iterator.hasNext)
	}
	
	@Test(expected = typeof(NoSuchElementException))
	def void testNoSuchElementInIterator() {
		var iterator = (defaultDate..defaultDate).iterator
		Assert::assertTrue(iterator.hasNext)
		Assert::assertTrue(iterator.next == defaultDate)
		Assert::assertFalse(iterator.hasNext)
		iterator.next
	}
	
	@Test(expected = typeof(UnsupportedOperationException))
	def void testDateMidnightRangeIteratorRemove() {
		var iterator = (defaultDate..defaultDate).iterator
		iterator.remove
	}
	
	@Test
	def void testConstructor() {
		new DateMidnightExtensions
	}
}