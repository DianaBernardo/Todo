package com.connectionwithmysql.connection.Controller;

import com.connectionwithmysql.connection.Models.Assignee;
import com.connectionwithmysql.connection.Models.Todo;
import com.connectionwithmysql.connection.Services.AssigneeService;
import com.connectionwithmysql.connection.Services.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MainController {

  private TodoService todoService;
  private AssigneeService assigneeService;

  @Autowired
  public MainController(TodoService todoService, AssigneeService assigneeService) {
    this.todoService = todoService;
    this.assigneeService = assigneeService;
  }

  @RequestMapping("/")
  public String list(Model model) {
    model.addAttribute("todos", todoService.listAll());
    return "todolist";
  }

  @GetMapping("/add")
  public String addTodo(Model model, @ModelAttribute("todo") Todo todo) {
    model.addAttribute("todo", todo);
    model.addAttribute("assignees", assigneeService.allAssignees());
    return "addtodo";
  }

  @PostMapping("/add")
  public String addTask(@ModelAttribute("todo") Todo todo) {
    todoService.addTodo(todo);
    return "redirect:/";
  }

  @GetMapping("/{id}/delete")
  public String delete(@PathVariable Long id) {
    todoService.deleteTodo(id);
    return "redirect:/";
  }

  @GetMapping("/{id}/edit")
  public String edit(@PathVariable Long id, Model model) {
    model.addAttribute("todo", todoService.findTodo(id));
    model.addAttribute("assignees", assigneeService.allAssignees());
    return "edit";
  }

  @PostMapping("/{id}/edit")
  public String editTodo(@ModelAttribute("todo") Todo todo) {
    todoService.addTodo(todo);
    return "redirect:/";
  }

  @PostMapping("/search")
  public String search(Model model, @RequestParam("search") String query) {
    model.addAttribute("todos", todoService.search(query));
    return "todolist";
  }

  @GetMapping("/assignees")
  public String showAssignees(Model model) {
    model.addAttribute("assignees",assigneeService.allAssignees());
    return "assignees";
  }

  @GetMapping("/{id}/deleteassignee")
  public String deleteAssignee(@PathVariable Long id) {
    assigneeService.deleteAssignee(id);
    return "redirect:/assignees";
  }

  @GetMapping("/addassignee")
  public String addAssignee(Model model, @ModelAttribute Assignee assignee) {
    model.addAttribute("assignee", assignee);
    return "addassignee";
  }

  @PostMapping("/addassignee")
  public String addAssignee2(@ModelAttribute("assignee") Assignee assignee) {
    assigneeService.addAssignee(assignee);
    return "redirect:/assignees";
  }

  @GetMapping("/{id}/editassignee")
  public String editassignee(@PathVariable Long id, Model model) {
    model.addAttribute("assignee", assigneeService.findAssignee(id));
    return "editassignee";
  }

  @PostMapping("/{id}/editassignee")
  public String editassignee2(@ModelAttribute("assignee") Assignee assignee) {
    assigneeService.addAssignee(assignee);
    return "redirect:/assignees";
  }

  @GetMapping("/{id}/assignee-todos")
  public String showtodos(Model model, Assignee assignee) {
    model.addAttribute("todos", todoService.findByAssignee(assignee));
    return "todos";
  }
}