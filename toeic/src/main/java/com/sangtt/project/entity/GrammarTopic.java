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
public class GrammarTopic {

    @Id // primary key
    @GeneratedValue(strategy = GenerationType.SEQUENCE) // auto-increment
    private long id;
    @Column
    private String nameTopic; // tên chủ đề
    @Column
    private String description; // mô tả chủ đề
    @Column
    private long view; // lượt xem
    @Column
    private long test; // lượt test
    @Column
    private long level; // cấp độ
    @Column
    private String filePractice; // file bài tập để tải về
    @Column
    private LocalDate createdDate; // thời gian tạo
    @Column
    private LocalDate updatedDate; // thời gian cập nhật


    // Quan hệ 1-N : GrammarTopic - GrammarUser
    @OneToMany(mappedBy = "gramTopicUser", cascade = CascadeType.ALL)
    private Collection<GrammarUser> grammarUsers;


    // Quan hệ 1-N : GrammarTopic - GrammarQuestion
    @OneToMany(mappedBy = "gramTopicQuestion", cascade = CascadeType.ALL)
    private Collection<GrammarQuestion> grammarQuestions;



}
