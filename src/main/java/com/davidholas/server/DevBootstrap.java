package com.davidholas.server;

import com.davidholas.server.model.Horse;
import com.davidholas.server.model.Player;
import com.davidholas.server.repositories.HorseRepository;
import com.davidholas.server.repositories.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private HorseRepository horseRepository;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData() {
        Player playerDavid = new Player("David");
        Player playerIvetka = new Player("Ivetka");

        Horse furioso = new Horse("Furioso", 5500, 650);
        Horse napoli = new Horse("Napoli", 8000, 1000);
        Horse japan = new Horse("Japan", 5000, 500);
        Horse ladyAnn = new Horse("LadyAnn", 4500, 400);
        Horse fantome = new Horse("Fantome", 2000, 250);
        Horse narcius = new Horse("Narcius", 7000, 850);

        playerRepository.save(playerDavid);
        playerRepository.save(playerIvetka);

        horseRepository.save(furioso);
        horseRepository.save(napoli);
        horseRepository.save(japan);
        horseRepository.save(ladyAnn);
        horseRepository.save(fantome);
        horseRepository.save(narcius);
    }
}

