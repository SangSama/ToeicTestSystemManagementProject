package com.sangtt.project.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Collection;

/**
 * Created by sang.tt172785 on 01/01/2022
 * */

@Entity // đánh dấu đây là table trong database
@Data // lombok giúp generate các hàm constructor, getter, setter v.v...
@NoArgsConstructor
@AllArgsConstructor
public class Part {

    @Id // primary key
    @GeneratedValue(strategy = GenerationType.SEQUENCE) // auto-increment
    private long id;
    @Column
    private int part; // part số bao nhiều : 01, ... , 07
    @Column
    private String description; // mô tả part
    @Column
    private long view; // lượt xem
    @Column
    private long test; // lượt đã test
    @Column
    private String fileListening; // file nghe
    @Column
    private LocalDate createdDate; // thời gian tạo
    @Column
    private LocalDate updatedDate; // thời gian cập nhật


    // Quan hệ N-1 : Part - Toeic
    @ManyToOne
    @JoinColumn(name = "fk_toeic_id")
    private Toeic toeicP;


    // Quan hệ 1-N : Part - Question
    @OneToMany(mappedBy = "part", cascade = CascadeType.ALL)
    private Collection<Question> questions;
}
