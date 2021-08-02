package com.cdi.domain.util;

import org.apache.commons.lang3.time.DateUtils;
import org.springframework.util.CollectionUtils;

import java.sql.Timestamp;
import java.time.OffsetDateTime;
import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class AppUtils {

    /**
     * Method to convert string to time stamp.
     *
     * @param inputDate
     * @return TimeStamp
     * @throws Exception
     */
    public static Timestamp convertToTimeStamp(String inputDate) throws Exception {
        String[] datePatterns = new String[]{"yyyy-MM-dd'T'HH:mm:ss.SSS'Z'"};
        Date date = DateUtils.parseDate(inputDate, datePatterns);
        Timestamp timeStampDate = new Timestamp(date.getTime());
        return timeStampDate;
    }

    /**
     * Method to convert list values to single value.
     *
     * @param inputValues
     * @return TimeStamp
     * @throws Exception
     */
    public static String convertArrayToValue(String[] inputValues) {
        String convertedValue = String.join(",", Arrays.asList(inputValues));
        return convertedValue;
    }

    /**
     * Method to convert array to value.
     *
     * @param values
     * @return String
     */
    public static String convertArrayToValue(List<String> values) {
        String convertedValue = CollectionUtils.isEmpty(values) ? "" : String.join(",", values);
        return convertedValue;
    }

    /**
     * Method convert list of numbers to comma separated value.
     *
     * @param ids
     * @return String
     */
    public static String convertNumbersToValue(Integer[] ids){
        String convertedValues = Arrays.stream(ids).map(String::valueOf).collect(Collectors.joining(","));
        return convertedValues;
    }

    /**
     * Method convert list of numbers to comma separated value.
     *
     * @param ids
     * @return String
     */
    public static String convertNumbersToValue(List<Integer> ids){
        String convertedValues = ids.stream().map(String::valueOf).collect(Collectors.joining(","));
        return convertedValues;
    }


    /**
     * Method to convert string to OffSetDateTime value.
     *
     * @param dateValue
     * @return OffsetDateTime
     */
    public static OffsetDateTime convertToOffSetDateTime(String dateValue) {
        OffsetDateTime offsetDateTime = ZonedDateTime.parse(dateValue).toOffsetDateTime();
        return offsetDateTime;
    }

}
