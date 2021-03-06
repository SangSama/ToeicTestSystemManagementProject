package com.sangtt.project.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * Created by sang.tt172785 on 01/01/2022
 * */

@Entity // đánh dấu đây là table trong database
@Data // lombok giúp generate các hàm constructor, getter, setter v.v...
@NoArgsConstructor
@AllArgsConstructor
public class ToeicUser {

    @Id // primary key
    @GeneratedValue(strategy = GenerationType.SEQUENCE) // auto-increment
    private long id;
    @Column
    private int score; // điểm
    @Column
    private LocalDate createdDate; // thời gian tạo
    @Column
    private LocalDate updatedDate; // thời gian cập nhật


    // Quan hệ N-1 : ToeicUser - User
    @ManyToOne
    @JoinColumn(name = "fk_user_id") // thông qua khóa ngoại user_id
    private User userT;


    // Quan hệ N-1 : ToeicUser - Toeic
    @ManyToOne
    @JoinColumn(name = "fk_toeic_id") // thông qua khóa ngoại toeic_id
    private Toeic toeicU;


}
