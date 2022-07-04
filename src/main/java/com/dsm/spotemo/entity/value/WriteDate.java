package com.dsm.spotemo.entity.value;

import lombok.*;
import org.springframework.data.annotation.Id;

import java.time.LocalDate;
import java.util.*;

//@AllArgsConstructor
//@Builder
@Getter
@NoArgsConstructor
public class WriteDate {
    private Set<Integer> years = new HashSet<>();
    private Set<Integer> months = new HashSet<>();
    private Set<LocalDate> dates = new HashSet<>();
    private List<DayPostInfo> dayPostInfos = new ArrayList<>();

    public void addDay(int year, int month, LocalDate date) {
        years.add(year);
        months.add(month);
        dates.add(date);
    }

    public void saveDayPostInfo(DayPostInfo info) {
        dayPostInfos.add(info);
    }

    public void deleteDay(DayDto day) {
        years.remove(Integer.valueOf(day.year));
        months.remove(Integer.valueOf(day.month));
        dates.remove(day.date);
        dayPostInfos.remove(day.info);
    }
}
