package me.shinsunyoung.springbootdeveloper.domain.todoList.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateTodoRequest {

    private String title;

    private String content;

    private Boolean checked; //Boolean null값 허용
    

}
