package com.capitole.testjava.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

    public static Date getDateFromString(String dateInString) throws ParseException {
	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	Date date = formatter.parse(dateInString);
	return date;
    }

    public static String parseDateToDate(Date date) throws ParseException {

	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	String resultado = formatter.format(date);

	return resultado;
    }
}