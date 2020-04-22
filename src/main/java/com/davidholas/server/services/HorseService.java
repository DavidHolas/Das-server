package com.davidholas.server.services;

import com.davidholas.server.model.Horse;
import com.davidholas.server.repositories.HorseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class HorseService {

    @Autowired
    HorseRepository horseRepository;

    public void addHorse(String name, int price, int check) {
        Horse horse = new Horse(name, price, check);
        horseRepository.save(horse);
    }

    public List<Horse> findAllHorses() {
        List<Horse> horseList = new ArrayList<>();
        horseRepository.findAll().forEach(horseList::add);
        return horseList;
    }

    public Set<Horse> findHorsesByOwner(Long id) {
        Set<Horse> horseList = new HashSet<>();
        horseRepository.findHorsesByOwnerId(id).forEach(horseList::add);
        return horseList;
    }

    public void updateHorseOwner(Long ownerId, Long id) {
        horseRepository.updateHorseOwner(ownerId, id);
    }
}
