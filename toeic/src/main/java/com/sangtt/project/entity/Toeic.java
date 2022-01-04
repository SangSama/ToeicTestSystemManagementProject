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
public class Toeic {

    @Id // primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto-increment
    private long id; // index
    @Column
    private String nameTopic; // tên đề : ETS 2020, ETS 2019
    @Column
    private int testNumber; // đề số bao nhiều : 01, ... , 10
    @Column
    private String description; // mô tả đề
    @Column
    private long view; // lượt xem
    @Column
    private long test; // lượt đã test
    @Column
    private String linkDetail; // link giải đề
    @Column
    private String linkTest; // link đề
    @Column
    private LocalDate createdDate; // thời gian tạo
    @Column
    private LocalDate updatedDate; // thời gian cập nhật


    // Quan hệ 1-N : Toeic - ToeicUser
    @OneToMany(mappedBy = "toeicU", cascade = CascadeType.ALL)
    // MapopedBy trỏ tới tên biến toeicU ở trong ToeicUser.
    private Collection<ToeicUser> toeicUser;


    // Quan hệ 1-N : Toeic - Part
    @OneToMany(mappedBy = "toeicP", cascade = CascadeType.ALL)
    private Collection<Part> parts;
}
