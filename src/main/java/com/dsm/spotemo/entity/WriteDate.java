package com.dsm.spotemo.entity;

import com.dsm.spotemo.entity.value.DayPostInfo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

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

    private int[] years;
    private int[] months;
    private Date[] dates;
    private DayPostInfo[] all;
}
