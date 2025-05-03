package me.shinsunyoung.springbootdeveloper.domain.todoList.converter;

import me.shinsunyoung.springbootdeveloper.domain.todoList.domain.TodoList;
import me.shinsunyoung.springbootdeveloper.domain.todoList.dto.AddTodoRequest;
import me.shinsunyoung.springbootdeveloper.domain.todoList.dto.TodoResponse;

public class TodoConverter {
    public static TodoResponse toDto(TodoList todoList){
        return TodoResponse.builder()
                .todoList(todoList)
                .build();
    }

    public static TodoList toEntity(AddTodoRequest addTodoRequest){
        return TodoList.builder()
                .title(addTodoRequest.getTitle())
                .content(addTodoRequest.getContent())
                .build();
    }
}
