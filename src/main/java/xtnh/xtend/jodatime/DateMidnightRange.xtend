package xtnh.xtend.jodatime

import java.util.Iterator
import java.util.NoSuchElementException
import org.joda.time.DateMidnight
import org.joda.time.ReadablePeriod

import static extension xtnh.xtend.jodatime.DateMidnightExtensions.*

class DateMidnightRange implements Iterable<DateMidnight> {
	
	DateMidnight start
	DateMidnight end
	ReadablePeriod step = 1.days
	
	new(DateMidnight start, DateMidnight end) {
		this.start = start
		this.end = end
	}
	
	new(DateMidnight start, DateMidnight end, ReadablePeriod step) {
		this.start = start
		this.end = end
		this.step = step
	}
	
	def withStep(ReadablePeriod step) {
		new DateMidnightRange(start, end, step)
	}
	
	override iterator() {
		new DateMidnightIterator(start, end, step)
	}

}

class DateMidnightIterator implements Iterator<DateMidnight> {
	
	DateMidnight start
	DateMidnight end
	ReadablePeriod step

	DateMidnight next
	
	new(DateMidnight start, DateMidnight end, ReadablePeriod step) {
		this.start = start
		this.end = end
		this.step = step
		this.next = start
	}
	
	override hasNext() {
		next <= end
	}
	
	override next() {
		if (!hasNext) {
			throw new NoSuchElementException
		}
		val value = next
		next = next + step
		return value
	}
	
	override remove() {
		throw new UnsupportedOperationException("Cannot remove elements from a DateMidnightRange.")
	}
	
}
	
