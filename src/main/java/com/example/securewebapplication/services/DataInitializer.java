package com.example.securewebapplication.services;

import com.example.securewebapplication.entities.User;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.Initialized;
import jakarta.enterprise.event.Observes;
import jakarta.inject.Inject;

@ApplicationScoped
public class DataInitializer {

    @Inject
    DataService dataService;

    public void execute(@Observes @Initialized(ApplicationScoped.class) Object event) {

        if (dataService.getAllUsers().isEmpty()){
            User emon = dataService.createUser("Mehedi Hasan Emon", "Emon72", "emon", "admin");
            User tom = dataService.createUser("Tom and Jerry" , "Tom" , "tom" , "user");
//
            dataService.createQuality("Wow" , emon);
            dataService.createQuality("Team Player" , emon);
            dataService.createQuality("Good Judgement" , emon);
            dataService.createQuality("Good Leader" , emon);

            dataService.createQuality("Very Good" , tom);
            dataService.createQuality("Responsible" , tom);
            dataService.createQuality("Cares for his team", tom);
        }


    }
}
