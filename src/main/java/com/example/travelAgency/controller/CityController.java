package com.example.travelAgency.controller;

import com.example.travelAgency.model.Airplane;
import com.example.travelAgency.model.City;
import com.example.travelAgency.service.AirplaneService;
import com.example.travelAgency.service.CityService;
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
@RequestMapping("city")
public class CityController {

    @Autowired
    private CityService cityService;

    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("cities",cityService.getAll());
        return "city/list";
    }


    @GetMapping("/add")
    public String displayAddForm(City city, Model model) {
        model.addAttribute("city",cityService.getAll());
        return "city/add";
    }

    @PostMapping("/add")
    public String processAdd(@Valid City city, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "city/add";
        }
        cityService.add(city);
        return "redirect:/city/list";
    }

    @GetMapping("/update/{id}")
    public String displayUpdateForm(@PathVariable("id") int id, Model model) {
        model.addAttribute("city",cityService.getAll());
        City city = cityService.findById(id);
        model.addAttribute("city",city);
        return "city/update";
    }

    @PostMapping("/update")
    public String processUpdate(City city) {
        cityService.update(city);
        return "redirect:/city/list";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id, Model model) {
        cityService.delete(id);
        return "redirect:/city/list";
    }

}
