package com.httpclient.httpclient4poc.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {
    public static String getDataAtualAsString(){
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date dataAtual = Calendar.getInstance().getTime();
        return dateFormat.format(dataAtual);
    }
}
