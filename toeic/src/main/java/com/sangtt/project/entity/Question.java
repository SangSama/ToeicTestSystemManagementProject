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
public class Question {

    @Id // primary key
    @GeneratedValue(strategy = GenerationType.SEQUENCE) // auto-increment
    private long id;
    @Column
    private String question; // câu hỏi
    @Column
    private String correct; // đáp án
    @Column
    private LocalDate createdDate; // thời gian tạo
    @Column
    private LocalDate updatedDate; // thời gian cập nhật


    // Quan hệ N-1 : Question - Part
    @ManyToOne
    @JoinColumn(name = "fk_part_id")
    private Part part;


    // Quan hệ N-1 : Question - Paragraph
    @ManyToOne
    @JoinColumn(name = "fk_paragraph_id")
    private Paragraph paragraph;

    // Quan hệ 1-1 : Question - Answer
    @OneToOne
    @JoinColumn(name = "answer_id")
    private Answer answer;


}
