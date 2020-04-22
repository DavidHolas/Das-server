package com.davidholas.server.controllers;

import com.davidholas.server.model.Horse;
import com.davidholas.server.services.HorseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/horses")
public class HorseController {

    @Autowired
    HorseService horseService;

    @GetMapping("/all")
    public List<Horse> showAllHorses() {
        return horseService.findAllHorses();
    }

    @GetMapping("/{ownerId}")
    public Set<Horse> showAllHorses(@PathVariable(name="ownerId") Long ownerId) {
        return horseService.findHorsesByOwner(ownerId);
    }
}
