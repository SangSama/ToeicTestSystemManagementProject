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
public class GrammarUser {

    @Id // primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto-increment
    private long id;
    @Column
    private LocalDate createdDate; // thời gian tạo
    @Column
    private LocalDate updatedDate; // thời gian cập nhật


    // Quan hệ N-1 : GrammarUser - User
    @ManyToOne
    @JoinColumn(name = "user_id") // thông qua khóa ngoại user_id
    private User userG;


    // Quan hệ N-1 : GrammarUser - GrammarTopic
    @ManyToOne
    @JoinColumn(name = "topic_id") // thông qua khóa ngoại topic_id
    private GrammarTopic gramTopicUser;


}
