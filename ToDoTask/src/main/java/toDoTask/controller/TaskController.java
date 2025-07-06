package toDoTask.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;
import toDoTask.binding.Task;
import toDoTask.entity.TaskEntity;
import toDoTask.entity.UserEntity;
import toDoTask.repository.TaskRepository;

@Controller
@RequestMapping("/task")
public class TaskController {

    @GetMapping("/home")
    public String showHomePage() {
        return "home"; // this should match home.html
    }
    
    @Autowired
    private TaskRepository taskRepo;

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("task", new Task());
        return "createTask";
    }

    @PostMapping("/save")
    public String saveTask(Task task, HttpSession session) {
        UserEntity user = (UserEntity) session.getAttribute("loggedInUser");
        TaskEntity taskEntity = new TaskEntity();
        taskEntity.setTask(task.getTask());
        taskEntity.setEmail(user.getEmail()); // Link task to user
        taskRepo.save(taskEntity);
        return "redirect:/task/view";
    }
    
    @GetMapping("/view")
    public String viewTasks(Model model, HttpSession session) {
        UserEntity user = (UserEntity) session.getAttribute("loggedInUser");
        List<TaskEntity> tasks = taskRepo.findByEmail(user.getEmail());
        model.addAttribute("tasks", tasks);
        return "viewTasks";
    }
}