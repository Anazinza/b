package com.dsm.spotemo.dto.response;

import com.dsm.spotemo.entity.value.DayPostInfo;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Builder
@Getter
public class WriteDateResponse {
    Set<Integer> years;
    Set<Integer> months;
    Set<LocalDate> dates;
    List<DayPostInfo> postInfos;
}
