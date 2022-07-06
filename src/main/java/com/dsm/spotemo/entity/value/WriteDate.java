package com.dsm.spotemo.entity.value;

import com.dsm.spotemo.dto.request.DayDto;
import lombok.*;

import java.time.LocalDate;
import java.util.*;

//@AllArgsConstructor
//@Builder
@Getter
@NoArgsConstructor
public class WriteDate {
    private List<Integer> years = new ArrayList<>();
    private List<Integer> months = new ArrayList<>();
    private List<LocalDate> dates = new ArrayList<>();
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
