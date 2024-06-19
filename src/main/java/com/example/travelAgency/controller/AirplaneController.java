package com.example.travelAgency.controller;


import com.example.travelAgency.model.Airplane;
import com.example.travelAgency.repository.AirplaneRepository;
import com.example.travelAgency.service.AirplaneService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("airplane")
public class AirplaneController {

    @Autowired
    private AirplaneService airplaneService;

    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("airplanes",airplaneService.getAll());
        return "airplane/list";
    }


    @GetMapping("/add")
    public String displayAddForm(Airplane airplane,Model model) {
        model.addAttribute("airplane",airplaneService.getAll());
        return "airplane/add";
    }

    @PostMapping("/add")
    public String processAdd(@Valid Airplane airplane, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "airplane/add";
        }
        airplaneService.add(airplane);
        return "redirect:/airplane/list";
    }

    @GetMapping("/update/{id}")
    public String displayUpdateForm(@PathVariable("id") int id, Model model) {
        model.addAttribute("airplane",airplaneService.getAll());
        Airplane airplane = airplaneService.findById(id);
        model.addAttribute("airplane",airplane);
        return "airplane/update";
    }

    @PostMapping("/update")
    public String processUpdate(Airplane airplane) {
        airplaneService.update(airplane);
        return "redirect:/airplane/list";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id, Model model) {
        airplaneService.delete(id);
        return "redirect:/airplane/list";
    }


}
