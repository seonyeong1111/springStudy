package me.shinsunyoung.springbootdeveloper.domain.todoList.repository;

import me.shinsunyoung.springbootdeveloper.domain.todoList.domain.TodoList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoListRespository extends JpaRepository<TodoList, Long> {
}
