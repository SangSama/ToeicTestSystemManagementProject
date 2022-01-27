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
public class Paragraph {

    @Id // primary key
    @GeneratedValue(strategy = GenerationType.SEQUENCE) // auto-increment
    private long id;
    @Column
    private String paragraph; // đoạn văn
    @Column
    private String image; // ảnh
    @Column
    private LocalDate createdDate; // thời gian tạo
    @Column
    private LocalDate updatedDate; // thời gian cập nhật


    // Quan hệ 1-N : Paragraph - Question
    @OneToMany(mappedBy = "paragraph", cascade = CascadeType.ALL)
    private Collection<Question> questions;

}
