package xtnh.xtend.jodatime;

import junit.framework.Assert;
import org.joda.time.DateMidnight;
import org.joda.time.Days;
import org.joda.time.Months;
import org.joda.time.Years;
import org.junit.Test;
import xtnh.xtend.jodatime.DateMidnightExtensions;

@SuppressWarnings("all")
public class DateMidnightExtensionsExamples {
  @Test
  public void example() {
    DateMidnight _dateMidnight = new DateMidnight("2013-01-01");
    final DateMidnight date1 = _dateMidnight;
    DateMidnight _dateMidnight_1 = new DateMidnight("2015-05-31");
    final DateMidnight date2 = _dateMidnight_1;
    DateMidnight _plusYears = date1.plusYears(2);
    DateMidnight _plusMonths = _plusYears.plusMonths(5);
    final DateMidnight newDate1 = _plusMonths.minusDays(1);
    boolean _isEqual = date2.isEqual(newDate1);
    Assert.assertTrue(_isEqual);
    Years _years = Years.years(2);
    DateMidnight _plus = date1.plus(_years);
    Months _months = Months.months(5);
    DateMidnight _plus_1 = _plus.plus(_months);
    Days _days = Days.days(1);
    final DateMidnight newDate2 = _plus_1.minus(_days);
    boolean _isEqual_1 = date2.isEqual(newDate2);
    Assert.assertTrue(_isEqual_1);
    Years _years_1 = DateMidnightExtensions.years(2);
    DateMidnight _plus_2 = DateMidnightExtensions.operator_plus(date1, _years_1);
    Months _months_1 = DateMidnightExtensions.months(5);
    DateMidnight _plus_3 = DateMidnightExtensions.operator_plus(_plus_2, _months_1);
    Days _days_1 = DateMidnightExtensions.days(1);
    final DateMidnight newDate3 = DateMidnightExtensions.operator_minus(_plus_3, _days_1);
    boolean _isEqual_2 = date2.isEqual(newDate3);
    Assert.assertTrue(_isEqual_2);
  }
}
