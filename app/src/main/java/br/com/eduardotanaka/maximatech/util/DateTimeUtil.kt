package br.com.eduardotanaka.maximatech.util

import org.threeten.bp.format.DateTimeFormatter

object DateTimeUtil {

    private const val DEFAULT_DATE_TIME_FORMAT = "dd/MM/yyyy"
    private const val DEFAULT_LOCAL_DATE_TIME_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'"
    private const val DATE_TIME_HH_MM_FORMAT = "dd/MM/yyyy HH:mm"

    val defaultFormatter: DateTimeFormatter = DateTimeFormatter.ofPattern(DEFAULT_DATE_TIME_FORMAT)
    val localDateTimeFormatter: DateTimeFormatter =
        DateTimeFormatter.ofPattern(DEFAULT_LOCAL_DATE_TIME_FORMAT)
    val snackDateTimeFormatter: DateTimeFormatter = DateTimeFormatter.ofPattern(DATE_TIME_HH_MM_FORMAT)


}