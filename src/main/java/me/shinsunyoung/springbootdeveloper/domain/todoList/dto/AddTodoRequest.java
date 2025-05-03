package me.shinsunyoung.springbootdeveloper.domain.todoList.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AddTodoRequest {

    private String title;

    private String content;

}
