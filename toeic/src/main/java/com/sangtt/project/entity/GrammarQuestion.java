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
public class GrammarQuestion {
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


    // Quan hệ N-1 : GrammarQuestion - GrammarTopic
    @ManyToOne
    @JoinColumn(name = "fk_topic_id", nullable = false) // thông qua khóa ngoài topic_id
    private GrammarTopic gramTopicQuestion;


    // Quan hệ 1-1 : GrammarQuestion - GrammarAnswer
    @OneToOne
    @JoinColumn(name = "fk_answer_id") // Liên kết với nhau qua khóa ngoại answer_id
    private GrammarAnswer grammarAnswer;

}
