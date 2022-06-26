package com.dsm.spotemo.entity.value;

import lombok.*;
import org.springframework.data.annotation.Id;

import java.util.*;

@AllArgsConstructor
@Builder
@Getter
@NoArgsConstructor
public class WriteDate {
    @Id
    private int id;

    private Set<Integer> years = new HashSet<>();
    private Set<Integer> months = new HashSet<>();
    private Set<Date> dates = new HashSet<>();
    private List<DayPostInfo> dayPostInfos = new ArrayList<>();

    public void addDay(int year, int month, Date date) {
        years.add(year);
        months.add(month);
        dates.add(date);
    }

}
