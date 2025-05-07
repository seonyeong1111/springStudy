package me.shinsunyoung.springbootdeveloper.todoList.dto;

import lombok.Builder;
import lombok.Getter;
import me.shinsunyoung.springbootdeveloper.todoList.domain.TodoList;

import java.time.LocalDateTime;

@Getter
public class TodoResponse {

    private long id;

    private String title;

    private String content;

    private boolean checked;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private Integer version;

    @Builder
    public TodoResponse(TodoList todoList) {
        this.id = todoList.getId();
        this.title = todoList.getTitle();
        this.content = todoList.getContent();
        this.checked = todoList.isChecked();
        this.createdAt = todoList.getCreatedAt();
        this.updatedAt = todoList.getUpdatedAt();
        this.version = todoList.getVersion();
    }
}
