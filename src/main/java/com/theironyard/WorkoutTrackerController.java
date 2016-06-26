package com.theironyard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by hoseasandstrom on 6/26/16.
 */
@Controller
public class WorkoutTrackerController {
    @Autowired
    WorkoutTrackerRepository movements;


    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String home(Model model) {
        List<Movement> movementList = (List<Movement>) movements.findAll();
        model.addAttribute("movements", movementList);
        return "home";
    }

    @RequestMapping(path = "/add-movement", method = RequestMethod.POST)
    public String addMovement(String movementname, String reps, String movementlocation,  int movementrating) {
        Movement movement = new Movement(movementname, reps, movementlocation, movementrating);
        movements.save(movement);
        return "redirect:/";
    }


}
