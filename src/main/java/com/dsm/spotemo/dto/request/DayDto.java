package com.dsm.spotemo.dto.request;

import com.dsm.spotemo.entity.value.DayPostInfo;
import lombok.Builder;

import java.time.LocalDate;

@Builder
public class DayDto {
    public int year;
    public int month;
    public LocalDate date;
    public DayPostInfo info;
}
