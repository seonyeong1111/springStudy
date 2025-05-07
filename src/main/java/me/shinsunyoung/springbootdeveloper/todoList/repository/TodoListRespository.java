package me.shinsunyoung.springbootdeveloper.todoList.repository;

import me.shinsunyoung.springbootdeveloper.todoList.domain.TodoList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoListRespository extends JpaRepository<TodoList, Long> {
}
