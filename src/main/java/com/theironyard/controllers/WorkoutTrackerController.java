package com.theironyard.controllers;

import com.theironyard.entities.User;
import com.theironyard.entities.Workout;
import com.theironyard.services.UserRepository;
import com.theironyard.services.WorkoutTrackerRepository;
import com.theironyard.utilities.PasswordStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

/**
 * Created by hoseasandstrom on 6/26/16.
 */
@Controller
public class WorkoutTrackerController {
    boolean edit;
    @Autowired
    WorkoutTrackerRepository workouts;
    @Autowired
    UserRepository users;


    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String home(HttpSession session, Model model, String movement, String workoutname) {
        String userName = (String) session.getAttribute("userName");
        User user = users.findByName(userName);
        if (user != null) {
            model.addAttribute("user", user);
        }
        model.addAttribute("now", LocalDateTime.now());

        Iterable<Workout> workoutList;
        workoutList = workouts.findAll();
        for (Workout workout : workoutList) {
            if (workout.getAuthor() == user) {
                edit = true;
            } else {
                edit = false;
            }
            model.addAttribute("edit", edit);
            model.addAttribute("workouts", workoutList);
        }
            return "home";
    }

    @RequestMapping(path = "/login", method = RequestMethod.POST)
    public String login(HttpSession session, String username, String password) throws Exception {
        User user = users.findByName(username);
        if(user == null) {
            user = new User(username, PasswordStorage.createHash(password));
        }
        else if (!PasswordStorage.verifyPassword(password, user.getPassword())) {
            throw new Exception("Wrong password");
        }
        session.setAttribute("username", username);
        return "redirect:/";

    }

    @RequestMapping(path = "/logout", method = RequestMethod.POST)
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";

    }


    @RequestMapping(path = "/add-workout", method = RequestMethod.POST)
    public String addWorkout(HttpSession session, String workoutname, String movement, String reps, String location, int rating, String note, String date ) {
        String username = (String) session.getAttribute("username");
        Workout workout = new Workout(workoutname, movement, reps, location, rating, note, LocalDateTime.parse(date));
        workouts.save(workout);
        return "redirect:/";
    }

    @RequestMapping(path = "/delete-workout", method = RequestMethod.POST)
    public String delete(int id, HttpSession session) {
        workouts.delete(id);

        return "redirect:/";
    }

    @RequestMapping(path = "edit", method = RequestMethod.POST)
    public String modifyWorkout() {
        edit = true;
        return"redirect:/edit-workout";
    }

    @RequestMapping(path="/edit-workout", method = RequestMethod.POST)
    public String editWorkout(int id, String workoutname, String movement, String reps, String location, int rating, String note, String date, String username) {
        Workout workout = new Workout(id, workoutname, movement, reps, location, rating, note, LocalDateTime.parse(date));
        workouts.save(workout);
        edit = false;
        return "redirect:/";
    }


}
