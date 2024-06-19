package com.example.travelAgency.controller;


import com.example.travelAgency.model.City;
import com.example.travelAgency.model.Flight;
import com.example.travelAgency.service.AirplaneService;
import com.example.travelAgency.service.CityService;
import com.example.travelAgency.service.FlightService;
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
@RequestMapping("flight")
public class FlightController {

    @Autowired
    private FlightService flightService;
    @Autowired
    private CityService cityService;
    @Autowired
    private AirplaneService airplaneService;

    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("flight",flightService.getAll());
        return "flight/list";
    }


    @GetMapping("/add")
    public String displayAddForm(Flight flight, Model model) {
        model.addAttribute("flights",flightService.getAll());
        model.addAttribute("airplanes",airplaneService.getAll());
        model.addAttribute("cities",cityService.getAll());
        return "flight/add";
    }

    @PostMapping("/add")
    public String processAdd(@Valid Flight flight, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "flight/add";
        }
        flightService.add(flight);
        return "redirect:/flight/list";
    }

    @GetMapping("/update/{id}")
    public String displayUpdateForm(@PathVariable("id") String id, Model model) {
        model.addAttribute("airplane",flightService.getAll());
        Flight flight = flightService.findById(id);
        model.addAttribute("airplane",flight);
        return "city/update";
    }

    @PostMapping("/update")
    public String processUpdate(Flight flight) {
        flightService.update(flight);
        return "redirect:/city/list";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") String id, Model model) {
        flightService.delete(id);
        return "redirect:/flight/list";
    }

}
