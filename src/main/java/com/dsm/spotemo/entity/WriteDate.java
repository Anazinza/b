package com.dsm.spotemo.entity;

import com.dsm.spotemo.entity.value.DayPostInfo;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@Builder
@Getter
@NoArgsConstructor
@Entity
@Table(name = "write_date")
public class WriteDate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @JoinColumn(name ="account_email", referencedColumnName = "email")
    @OneToOne
    private Account account;

    private Set<Integer> years;
    private Set<Integer> months;
    private Set<Date> dates;
    private List<DayPostInfo> all;
}
