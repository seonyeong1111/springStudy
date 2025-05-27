package me.shinsunyoung.springbootdeveloper.todoList.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import me.shinsunyoung.springbootdeveloper.apiPayload.code.status.ErrorStatus;
import me.shinsunyoung.springbootdeveloper.apiPayload.exception.GeneralException;
import me.shinsunyoung.springbootdeveloper.todoList.domain.TodoList;
import me.shinsunyoung.springbootdeveloper.todoList.repository.TodoListRespository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TodoListService {

    private final TodoListRespository todoListRespository;

    public List<TodoList> findAll(){
        return todoListRespository.findAll();
    }

    public TodoList findById(long id) {
        return todoListRespository.findById(id).orElseThrow(() -> new GeneralException(ErrorStatus._TODO_NOT_FOUND));
    }

    public TodoList save(TodoList todoList){
        return todoListRespository.save(todoList);
    }

    public void deleteById(long id){
        todoListRespository.deleteById(id);
    }

    public boolean existsById(long id){
        return todoListRespository.existsById(id);
    }

    @Transactional
    public TodoList update(long id, String title, String content,Boolean checked){
        TodoList todoList = todoListRespository.findById(id).orElseThrow(() -> new GeneralException(ErrorStatus._TODO_NOT_FOUND));
        if (title == null) {
            title=todoList.getTitle();
        }

        if (content == null) {
            content=todoList.getContent();
        }

        if (checked == null) {
            checked=todoList.isChecked();
        }
        todoList.update(title, content, checked);
        return todoList;
    }
}
