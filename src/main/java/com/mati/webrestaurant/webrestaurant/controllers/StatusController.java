package com.mati.webrestaurant.webrestaurant.controllers;

import com.mati.webrestaurant.webrestaurant.entities.Status;
import com.mati.webrestaurant.webrestaurant.services.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class StatusController {

    @Autowired
    private StatusService statusService;
    @GetMapping("/statuses")
    public List<Status> getStatuses(){
        List<Status> statuses;

        statuses = statusService.getAllStatuses();

        return statuses;
    }

    @PostMapping("/statuses")
    public void addStatus(@RequestBody Status status){
        statusService.addStatus(status);
    }

    @DeleteMapping("/statuses/{statusId}")
    public void deleteStatusById(@PathVariable int statusId){
        statusService.deleteStatusById(statusId);

    }

}
