package com.sangtt.project.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by sang.tt172785 on 01/01/2022
 * */

@Entity // đánh dấu đây là table trong database
@Data // lombok giúp generate các hàm constructor, getter, setter v.v...
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id // đánh dấu trường này là primary key
    @GeneratedValue(strategy = GenerationType.SEQUENCE) // tự động tăng giá trị id
    private long id;
    @Column
    private String fullName; // tên user
    @Column
    private String email; // địa chỉ email
    @Column
    private String avatar; // link ảnh : có thể tự fix ảnh user
    @Column
    private String password; // mật khẩu
    @Column
    private LocalDate createdDate; // thời gian tạo
    @Column
    private LocalDate updatedDate; // thời gian cập nhật


    // Quan hệ N-N : User - Role => bảng phụ : permission
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    // Quan hệ n-n với đối tượng ở dưới (Role) (1 quyền có nhiều user)
    // LAZY để tránh việc truy xuất dữ liệu không cần thiết. Lúc nào cần thì mới query
    @JoinTable(
            name = "permission", //Tạo ra một join Table tên là "permission"

            // Trong đó, khóa ngoại chính là user_id trỏ tới class hiện tại (User)
            joinColumns = @JoinColumn(name = "user_id", nullable = false),

            //Khóa ngoại thứ 2 trỏ tới thuộc tính ở dưới (Role)
            inverseJoinColumns = @JoinColumn(name = "role_id", nullable = false)
    )
    // (Collection) Set: cấu trúc dữ liệu lưu trữ không cho phép trùng phần tử và không quan tâm thứ tự của các element
    // VD: 1 1 1 2 2 1 3 2 => 1 2 3 => size = 3
    private Set<Role> roles = new HashSet<>();


    // Quan hệ 1-N : User - VocabularyUser
    @OneToMany(mappedBy = "userV", cascade = CascadeType.ALL)
    // MapopedBy trỏ tới tên biến userV ở trong VocabularyUser.
    private Collection<VocabularyUser> vocabularyUsers;


    // Quan hệ 1-N : User - GrammarUser
    @OneToMany(mappedBy = "userG", cascade = CascadeType.ALL)
    // MapopedBy trỏ tới tên biến userG ở trong GrammarUser.
    private Collection<GrammarUser> grammarUsers;


    // Quan hệ 1-N : User - ToeicUser
    @OneToMany(mappedBy = "userT", cascade = CascadeType.ALL)
    // MapopedBy trỏ tới tên biến userT ở trong ToeicUser.
    private Collection<ToeicUser> toeicUsers;

}
