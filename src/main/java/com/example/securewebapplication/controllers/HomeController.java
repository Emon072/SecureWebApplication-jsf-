package com.example.securewebapplication.controllers;

import com.example.securewebapplication.entities.Quality;
import com.example.securewebapplication.entities.User;
import com.example.securewebapplication.services.DataService;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.util.List;
import java.util.Optional;

@RequestScoped
@Named
public class HomeController {

    @Inject
    DataService dataService;

    private Optional<User> currentUser;
    private List<Quality> currentQualities;

    @PostConstruct
    public void initialize() {
        String username = "Emon72";
        this.currentUser = dataService.getUser(username);

        this.currentUser.ifPresent(user -> {
            this.currentQualities = dataService.getQualities(user);
        });
    }

    public User getCurrentuser() {
        return this.currentUser.orElse(null);
    }

    public List<Quality> getCurrentQualities() {
        return currentQualities;
    }
}
