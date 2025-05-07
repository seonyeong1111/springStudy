package me.shinsunyoung.springbootdeveloper.todoList.domain;

import jakarta.persistence.*;

import lombok.*;
import me.shinsunyoung.springbootdeveloper.global.common.BaseEntity;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class TodoList extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String content;

    private boolean checked;

    @Version
    private Integer version;

    @Builder
    public TodoList(String title, String content, boolean checked) {
        this.title=title;
        this.content=content;
        this.checked=checked;
    }

    public void update(String title, String content, boolean checked){
        this.title=title;
        this.content=content;
        this.checked=checked;
    }
}
