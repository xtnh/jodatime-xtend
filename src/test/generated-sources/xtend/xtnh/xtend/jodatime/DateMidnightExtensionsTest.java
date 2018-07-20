package xtnh.xtend.jodatime;

import java.util.Iterator;
import java.util.NoSuchElementException;
import junit.framework.Assert;
import org.joda.time.DateMidnight;
import org.joda.time.Days;
import org.joda.time.Months;
import org.joda.time.Period;
import org.joda.time.Years;
import org.junit.Before;
import org.junit.Test;
import xtnh.xtend.jodatime.DateMidnightExtensions;
import xtnh.xtend.jodatime.DateMidnightRange;

@SuppressWarnings("all")
public class DateMidnightExtensionsTest {
  private DateMidnight defaultDate;
  
  private DateMidnight compareDate;
  
  @Before
  public void beforeTest() {
    DateMidnight _dateMidnight = new DateMidnight("2012-12-01");
    this.defaultDate = _dateMidnight;
    DateMidnight _dateMidnight_1 = new DateMidnight("2011-12-01");
    this.compareDate = _dateMidnight_1;
  }
  
  @Test
  public void testDays() {
    Days _days = DateMidnightExtensions.days(1);
    Assert.assertEquals(Days.ONE, _days);
  }
  
  @Test
  public void testWeeks() {
    Days _weeks = DateMidnightExtensions.weeks(1);
    Assert.assertEquals(Days.SEVEN, _weeks);
  }
  
  @Test
  public void testMonths() {
    Months _months = DateMidnightExtensions.months(1);
    Assert.assertEquals(Months.ONE, _months);
  }
  
  @Test
  public void testYears() {
    Years _years = DateMidnightExtensions.years(1);
    Assert.assertEquals(Years.ONE, _years);
  }
  
  @Test
  public void testDateMidnightPlusPeriod() {
    DateMidnight _dateMidnight = new DateMidnight("2012-12-02");
    Days _days = DateMidnightExtensions.days(1);
    DateMidnight _plus = DateMidnightExtensions.operator_plus(this.defaultDate, _days);
    Assert.assertEquals(_dateMidnight, _plus);
    DateMidnight _dateMidnight_1 = new DateMidnight("2012-12-08");
    Days _weeks = DateMidnightExtensions.weeks(1);
    DateMidnight _plus_1 = DateMidnightExtensions.operator_plus(this.defaultDate, _weeks);
    Assert.assertEquals(_dateMidnight_1, _plus_1);
    DateMidnight _dateMidnight_2 = new DateMidnight("2013-01-01");
    Months _months = DateMidnightExtensions.months(1);
    DateMidnight _plus_2 = DateMidnightExtensions.operator_plus(this.defaultDate, _months);
    Assert.assertEquals(_dateMidnight_2, _plus_2);
    DateMidnight _dateMidnight_3 = new DateMidnight("2013-12-01");
    Years _years = DateMidnightExtensions.years(1);
    DateMidnight _plus_3 = DateMidnightExtensions.operator_plus(this.defaultDate, _years);
    Assert.assertEquals(_dateMidnight_3, _plus_3);
  }
  
  @Test
  public void testDateMidnightMinusPeriod() {
    DateMidnight _dateMidnight = new DateMidnight("2012-11-30");
    Days _days = DateMidnightExtensions.days(1);
    DateMidnight _minus = DateMidnightExtensions.operator_minus(this.defaultDate, _days);
    Assert.assertEquals(_dateMidnight, _minus);
    DateMidnight _dateMidnight_1 = new DateMidnight("2012-11-24");
    Days _weeks = DateMidnightExtensions.weeks(1);
    DateMidnight _minus_1 = DateMidnightExtensions.operator_minus(this.defaultDate, _weeks);
    Assert.assertEquals(_dateMidnight_1, _minus_1);
    DateMidnight _dateMidnight_2 = new DateMidnight("2012-11-01");
    Months _months = DateMidnightExtensions.months(1);
    DateMidnight _minus_2 = DateMidnightExtensions.operator_minus(this.defaultDate, _months);
    Assert.assertEquals(_dateMidnight_2, _minus_2);
    DateMidnight _dateMidnight_3 = new DateMidnight("2011-12-01");
    Years _years = DateMidnightExtensions.years(1);
    DateMidnight _minus_3 = DateMidnightExtensions.operator_minus(this.defaultDate, _years);
    Assert.assertEquals(_dateMidnight_3, _minus_3);
  }
  
  @Test
  public void testPeriodPlusPeriod() {
    Days _days = DateMidnightExtensions.days(3);
    int _days_1 = _days.getDays();
    Days _days_2 = DateMidnightExtensions.days(2);
    Days _days_3 = DateMidnightExtensions.days(1);
    Period _plus = DateMidnightExtensions.operator_plus(_days_2, _days_3);
    int _days_4 = _plus.getDays();
    Assert.assertEquals(_days_1, _days_4);
  }
  
  @Test
  public void testPeriodMinusPeriod() {
    Days _days = DateMidnightExtensions.days(1);
    int _days_1 = _days.getDays();
    Days _days_2 = DateMidnightExtensions.days(2);
    Days _days_3 = DateMidnightExtensions.days(1);
    Period _minus = DateMidnightExtensions.operator_minus(_days_2, _days_3);
    int _days_4 = _minus.getDays();
    Assert.assertEquals(_days_1, _days_4);
  }
  
  @Test
  public void testDateMidnightMinus() {
    final Period actual = DateMidnightExtensions.operator_minus(this.compareDate, this.defaultDate);
    Years _years = DateMidnightExtensions.years(1);
    Period _period = _years.toPeriod();
    Assert.assertEquals(_period, actual);
  }
  
  @Test
  public void testDateMidnightGreaterThan() {
    boolean _greaterThan = DateMidnightExtensions.operator_greaterThan(this.defaultDate, this.compareDate);
    Assert.assertTrue(_greaterThan);
  }
  
  @Test
  public void testDateMidnightLessThan() {
    boolean _lessThan = DateMidnightExtensions.operator_lessThan(this.compareDate, this.defaultDate);
    Assert.assertTrue(_lessThan);
  }
  
  @Test
  public void testDateMidnightGreaterEqualsThan() {
    boolean _greaterEqualsThan = DateMidnightExtensions.operator_greaterEqualsThan(this.defaultDate, this.compareDate);
    Assert.assertTrue(_greaterEqualsThan);
    boolean _greaterEqualsThan_1 = DateMidnightExtensions.operator_greaterEqualsThan(this.compareDate, this.compareDate);
    Assert.assertTrue(_greaterEqualsThan_1);
    DateMidnight _dateMidnight = new DateMidnight("2011-12-01");
    boolean _greaterEqualsThan_2 = DateMidnightExtensions.operator_greaterEqualsThan(_dateMidnight, this.compareDate);
    Assert.assertTrue(_greaterEqualsThan_2);
    DateMidnight _dateMidnight_1 = new DateMidnight("2011-11-30");
    boolean _greaterEqualsThan_3 = DateMidnightExtensions.operator_greaterEqualsThan(_dateMidnight_1, this.compareDate);
    Assert.assertFalse(_greaterEqualsThan_3);
  }
  
  @Test
  public void testDateMidnightLessEqualsThan() {
    boolean _lessEqualsThan = DateMidnightExtensions.operator_lessEqualsThan(this.compareDate, this.defaultDate);
    Assert.assertTrue(_lessEqualsThan);
    boolean _lessEqualsThan_1 = DateMidnightExtensions.operator_lessEqualsThan(this.compareDate, this.compareDate);
    Assert.assertTrue(_lessEqualsThan_1);
    DateMidnight _dateMidnight = new DateMidnight("2012-12-01");
    boolean _lessEqualsThan_2 = DateMidnightExtensions.operator_lessEqualsThan(_dateMidnight, this.defaultDate);
    Assert.assertTrue(_lessEqualsThan_2);
    DateMidnight _dateMidnight_1 = new DateMidnight("2012-12-02");
    boolean _lessEqualsThan_3 = DateMidnightExtensions.operator_lessEqualsThan(_dateMidnight_1, this.defaultDate);
    Assert.assertFalse(_lessEqualsThan_3);
  }
  
  @Test
  public void testDateMidnightEquals() {
    DateMidnight _dateMidnight = new DateMidnight("2012-12-01");
    boolean _equals = DateMidnightExtensions.operator_equals(this.defaultDate, _dateMidnight);
    Assert.assertTrue(_equals);
    boolean _equals_1 = DateMidnightExtensions.operator_equals(this.defaultDate, this.compareDate);
    Assert.assertFalse(_equals_1);
  }
  
  @Test
  public void testDateMidnightNotEquals() {
    boolean _notEquals = DateMidnightExtensions.operator_notEquals(this.defaultDate, this.compareDate);
    Assert.assertTrue(_notEquals);
    DateMidnight _dateMidnight = new DateMidnight("2012-12-01");
    boolean _notEquals_1 = DateMidnightExtensions.operator_notEquals(this.defaultDate, _dateMidnight);
    Assert.assertFalse(_notEquals_1);
  }
  
  @Test
  public void testDateMidnightRange() {
    DateMidnightRange _upTo = DateMidnightExtensions.operator_upTo(this.defaultDate, this.defaultDate);
    Iterator<DateMidnight> iterator = _upTo.iterator();
    boolean _hasNext = iterator.hasNext();
    Assert.assertTrue(_hasNext);
    DateMidnight _next = iterator.next();
    boolean _equals = DateMidnightExtensions.operator_equals(_next, this.defaultDate);
    Assert.assertTrue(_equals);
    boolean _hasNext_1 = iterator.hasNext();
    Assert.assertFalse(_hasNext_1);
    Years _years = DateMidnightExtensions.years(2);
    DateMidnight _plus = DateMidnightExtensions.operator_plus(this.defaultDate, _years);
    Months _months = DateMidnightExtensions.months(5);
    DateMidnight _plus_1 = DateMidnightExtensions.operator_plus(_plus, _months);
    Days _days = DateMidnightExtensions.days(1);
    DateMidnight compareDate = DateMidnightExtensions.operator_minus(_plus_1, _days);
    DateMidnightRange _upTo_1 = DateMidnightExtensions.operator_upTo(this.defaultDate, compareDate);
    Years _years_1 = DateMidnightExtensions.years(1);
    DateMidnightRange _withStep = _upTo_1.withStep(_years_1);
    Iterator<DateMidnight> _iterator = _withStep.iterator();
    iterator = _iterator;
    boolean _hasNext_2 = iterator.hasNext();
    Assert.assertTrue(_hasNext_2);
    DateMidnight _next_1 = iterator.next();
    boolean _equals_1 = DateMidnightExtensions.operator_equals(_next_1, this.defaultDate);
    Assert.assertTrue(_equals_1);
    boolean _hasNext_3 = iterator.hasNext();
    Assert.assertTrue(_hasNext_3);
    DateMidnight _next_2 = iterator.next();
    Years _years_2 = DateMidnightExtensions.years(1);
    DateMidnight _plus_2 = DateMidnightExtensions.operator_plus(this.defaultDate, _years_2);
    boolean _equals_2 = DateMidnightExtensions.operator_equals(_next_2, _plus_2);
    Assert.assertTrue(_equals_2);
    boolean _hasNext_4 = iterator.hasNext();
    Assert.assertTrue(_hasNext_4);
    DateMidnight _next_3 = iterator.next();
    Years _years_3 = DateMidnightExtensions.years(2);
    DateMidnight _plus_3 = DateMidnightExtensions.operator_plus(this.defaultDate, _years_3);
    boolean _equals_3 = DateMidnightExtensions.operator_equals(_next_3, _plus_3);
    Assert.assertTrue(_equals_3);
    boolean _hasNext_5 = iterator.hasNext();
    Assert.assertFalse(_hasNext_5);
    Months _months_1 = DateMidnightExtensions.months(2);
    DateMidnight _plus_4 = DateMidnightExtensions.operator_plus(this.defaultDate, _months_1);
    Days _days_1 = DateMidnightExtensions.days(1);
    DateMidnight _minus = DateMidnightExtensions.operator_minus(_plus_4, _days_1);
    compareDate = _minus;
    DateMidnightRange _upTo_2 = DateMidnightExtensions.operator_upTo(this.defaultDate, compareDate);
    Months _months_2 = DateMidnightExtensions.months(1);
    DateMidnightRange _withStep_1 = _upTo_2.withStep(_months_2);
    Iterator<DateMidnight> _iterator_1 = _withStep_1.iterator();
    iterator = _iterator_1;
    boolean _hasNext_6 = iterator.hasNext();
    Assert.assertTrue(_hasNext_6);
    DateMidnight _next_4 = iterator.next();
    boolean _equals_4 = DateMidnightExtensions.operator_equals(_next_4, this.defaultDate);
    Assert.assertTrue(_equals_4);
    boolean _hasNext_7 = iterator.hasNext();
    Assert.assertTrue(_hasNext_7);
    DateMidnight _next_5 = iterator.next();
    Months _months_3 = DateMidnightExtensions.months(1);
    DateMidnight _plus_5 = DateMidnightExtensions.operator_plus(this.defaultDate, _months_3);
    boolean _equals_5 = DateMidnightExtensions.operator_equals(_next_5, _plus_5);
    Assert.assertTrue(_equals_5);
    boolean _hasNext_8 = iterator.hasNext();
    Assert.assertFalse(_hasNext_8);
    Days _days_2 = DateMidnightExtensions.days(20);
    DateMidnight _plus_6 = DateMidnightExtensions.operator_plus(this.defaultDate, _days_2);
    compareDate = _plus_6;
    DateMidnightRange _upTo_3 = DateMidnightExtensions.operator_upTo(this.defaultDate, compareDate);
    Days _weeks = DateMidnightExtensions.weeks(1);
    DateMidnightRange _withStep_2 = _upTo_3.withStep(_weeks);
    Iterator<DateMidnight> _iterator_2 = _withStep_2.iterator();
    iterator = _iterator_2;
    boolean _hasNext_9 = iterator.hasNext();
    Assert.assertTrue(_hasNext_9);
    DateMidnight _next_6 = iterator.next();
    boolean _equals_6 = DateMidnightExtensions.operator_equals(_next_6, this.defaultDate);
    Assert.assertTrue(_equals_6);
    boolean _hasNext_10 = iterator.hasNext();
    Assert.assertTrue(_hasNext_10);
    DateMidnight _next_7 = iterator.next();
    Days _weeks_1 = DateMidnightExtensions.weeks(1);
    DateMidnight _plus_7 = DateMidnightExtensions.operator_plus(this.defaultDate, _weeks_1);
    boolean _equals_7 = DateMidnightExtensions.operator_equals(_next_7, _plus_7);
    Assert.assertTrue(_equals_7);
    boolean _hasNext_11 = iterator.hasNext();
    Assert.assertTrue(_hasNext_11);
    DateMidnight _next_8 = iterator.next();
    Days _weeks_2 = DateMidnightExtensions.weeks(2);
    DateMidnight _plus_8 = DateMidnightExtensions.operator_plus(this.defaultDate, _weeks_2);
    boolean _equals_8 = DateMidnightExtensions.operator_equals(_next_8, _plus_8);
    Assert.assertTrue(_equals_8);
    boolean _hasNext_12 = iterator.hasNext();
    Assert.assertFalse(_hasNext_12);
  }
  
  @Test(expected = NoSuchElementException.class)
  public void testNoSuchElementInIterator() {
    DateMidnightRange _upTo = DateMidnightExtensions.operator_upTo(this.defaultDate, this.defaultDate);
    Iterator<DateMidnight> iterator = _upTo.iterator();
    boolean _hasNext = iterator.hasNext();
    Assert.assertTrue(_hasNext);
    DateMidnight _next = iterator.next();
    boolean _equals = DateMidnightExtensions.operator_equals(_next, this.defaultDate);
    Assert.assertTrue(_equals);
    boolean _hasNext_1 = iterator.hasNext();
    Assert.assertFalse(_hasNext_1);
    iterator.next();
  }
  
  @Test(expected = UnsupportedOperationException.class)
  public void testDateMidnightRangeIteratorRemove() {
    DateMidnightRange _upTo = DateMidnightExtensions.operator_upTo(this.defaultDate, this.defaultDate);
    Iterator<DateMidnight> iterator = _upTo.iterator();
    iterator.remove();
  }
  
  @Test
  public void testConstructor() {
    new DateMidnightExtensions();
  }
}
