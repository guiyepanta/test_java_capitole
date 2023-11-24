package com.capitole.testjava.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DateUtil {

    public static LocalDateTime getDateFromString(String dateInString) throws ParseException {
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	LocalDateTime dateTime = LocalDateTime.parse(dateInString, formatter);

	return dateTime;
    }

    public static String parseDateToDate(Date date) throws ParseException {

	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	String resultado = formatter.format(date);

	return resultado;
    }
}