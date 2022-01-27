package com.sangtt.project.repository;

import com.sangtt.project.entity.Paragraph;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by sang.tt172785 on 04/01/2022
 * */

public interface ParagraphRepository extends JpaRepository<Paragraph, Long> {
}
