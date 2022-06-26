package com.dsm.spotemo.entity;

import com.dsm.spotemo.entity.value.DayPostInfo;
import lombok.*;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import org.hibernate.type.ListType;
import org.hibernate.type.SetType;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.*;

@AllArgsConstructor
@Builder
@Getter
@NoArgsConstructor
@Entity
@Table(name = "write_date")
//@TypeDefs(
//        {@TypeDef(name = "list", typeClass = ArrayList.class),
//        @TypeDef(name = "set", typeClass = HashSet.class)}
//)
public class WriteDate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

//    @JoinColumn(name ="account_email", referencedColumnName = "email")
////    @OneToOne(mappedBy = )
//    @OneToOne
//    private Account account; // 그냥 이메일만 저장할까..?
    private String accountEmail;

//    @Type(type = "list")
//    @Column(columnDefinition = "Int[]")
//    @Column(name = "years", columnDefinition = "int[]")

    @ElementCollection
    private List<Integer> years;
//    @Type(type = "list")
    @ElementCollection
    private List<Integer> months = new ArrayList<>();
//    @Type(type = "list")
    @ElementCollection
    private List<Date> dates = new ArrayList<>();
//    @Type(type = "list")
    @ElementCollection
    private List<DayPostInfo> dayPostInfos = new ArrayList<>();
}
