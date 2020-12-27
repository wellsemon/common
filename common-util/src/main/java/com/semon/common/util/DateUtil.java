package com.semon.common.util;

import java.util.Comparator;
import java.util.Date;
import java.util.List;

@SuppressWarnings("unused")
public class DateUtil {
  /**
   * Returns the maximum of two dates. <br/>
   * A null date is treated as being less than any non-null date.
   *
   * @param d1 the d 1
   * @param d2 the d 2
   * @return the date
   */
  public static Date max(Date d1, Date d2) {
    if (d1 == null && d2 == null) {
      return null;
    }
    if (d1 == null) {
      return d2;
    }
    if (d2 == null) {
      return d1;
    }
    return (d1.after(d2)) ? d1 : d2;
  }

  /**
   * return max date in list, maybe null
   *
   * @param dates the dates
   * @return the date
   */
  public static Date max(List<Date> dates) {
    return dates.stream().max(new DateComparator()).get();
  }

  private static class DateComparator implements Comparator<Date> {
    public int compare(Date o1, Date o2) {
      if (null == o1) {
        return -1;
      }
      if (null == o2) {
        return 1;
      }

      return o1.compareTo(o2);
    }
  }
}
