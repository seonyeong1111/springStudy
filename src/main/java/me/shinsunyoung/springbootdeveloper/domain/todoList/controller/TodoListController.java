package me.shinsunyoung.springbootdeveloper.domain.todoList.controller;

import lombok.RequiredArgsConstructor;
import me.shinsunyoung.springbootdeveloper.global.apiPayload.ApiResponse;
import me.shinsunyoung.springbootdeveloper.global.apiPayload.code.status.SuccessStatus;
import me.shinsunyoung.springbootdeveloper.domain.todoList.converter.TodoConverter;
import me.shinsunyoung.springbootdeveloper.domain.todoList.dto.AddTodoRequest;
import me.shinsunyoung.springbootdeveloper.domain.todoList.dto.TodoResponse;
import me.shinsunyoung.springbootdeveloper.domain.todoList.dto.UpdateTodoRequest;
import me.shinsunyoung.springbootdeveloper.domain.todoList.service.TodoListService;
import me.shinsunyoung.springbootdeveloper.domain.todoList.domain.TodoList;
import me.shinsunyoung.springbootdeveloper.domain.todoList.validation.annotation.ExistIds;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Validated
public class TodoListController {

    private final TodoListService todoListService;

    @GetMapping("/todo")
    @CrossOrigin(origins = "http://localhost:5173") // 해당 엔드포인트에만 CORS 허용
    public ResponseEntity<List<TodoResponse>> findAllTodos(){
        List<TodoResponse> todoLists = todoListService.findAll()
                .stream()
                .map(TodoConverter::toDto)
                .toList();
        return ResponseEntity.ok(todoLists);

    }

    @GetMapping("/todo/{id}")
    @CrossOrigin(origins = "http://localhost:5173")
    public ApiResponse<TodoResponse> findTodo(@ExistIds @PathVariable long id){
        TodoList todoList = todoListService.findById(id);
        return ApiResponse.onSuccess(TodoConverter.toDto(todoList));

    }

    @PostMapping("/todo")
    @CrossOrigin(origins = "http://localhost:5173")
    public ApiResponse<TodoList> addTodo(@RequestBody AddTodoRequest addTodoRequest){
        TodoList todoList = todoListService.save(TodoConverter.toEntity(addTodoRequest));
        return ApiResponse.of(todoList, SuccessStatus._CREATED);
    }

    @DeleteMapping("/todo/{id}")
    @CrossOrigin(origins = "http://localhost:5173")
    public ApiResponse<Void> deleteTodo(@PathVariable long id){
        todoListService.deleteById(id);
        return ApiResponse.onSuccess(null);
    }

    @PatchMapping("/todo/{id}")
    @CrossOrigin(origins = "http://localhost:5173")
    public ApiResponse<TodoList> updateTodo(@ExistIds @PathVariable long id, @RequestBody UpdateTodoRequest updateTodoRequest){
        TodoList todoList=todoListService.update(id, updateTodoRequest.getTitle(), updateTodoRequest.getContent(),updateTodoRequest.getChecked());
        return ApiResponse.onSuccess(todoList);
    }

}
