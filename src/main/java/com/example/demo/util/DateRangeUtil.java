package com.example.demo.util;

import com.example.demo.exception.BadRequestException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DateRangeUtil {

    public static List<LocalDate> daysBetween(LocalDate start, LocalDate end) {

        if (start.isAfter(end)) {
            throw new BadRequestException("Start date must be before end date");
        }

        List<LocalDate> dates = new ArrayList<>();
        LocalDate current = start;

        while (!current.isAfter(end)) {
            dates.add(current);
            current = current.plusDays(1);
        }

        return dates;
    }
}
