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
public class Vocabulary {
    @Id // primary key
    @GeneratedValue(strategy = GenerationType.SEQUENCE) // auto-increment
    private long id;
    @Column
    private String word; // từ
    @Column
    private String mean; // nghĩa
    @Column
    private LocalDate createdDate; // thời gian tạo
    @Column
    private LocalDate updatedDate; // thời gian cập nhật


    // Quan hệ N-1 : Vocabulary - VocabularyTopic
    @ManyToOne
    // Many to One Có nhiều từ trong 1 topic.
    @JoinColumn(name = "fk_topic_id") // thông qua khóa ngoại topic_id
    private VocabularyTopic vocaTopic;


}
