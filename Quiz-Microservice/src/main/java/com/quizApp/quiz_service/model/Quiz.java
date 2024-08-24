package com.quizApp.quiz_service.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Quiz {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Integer id;
    private String title;

    @ElementCollection // when there is specific element type the use it else use @ManyToMany
    private List<Integer> questionIds;
}
