package com.mati.webrestaurant.webrestaurant.services;


import com.mati.webrestaurant.webrestaurant.entities.Status;
import com.mati.webrestaurant.webrestaurant.repositories.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StatusService {
    @Autowired
    private StatusRepository statusRepository;

    public List<Status> getAllStatuses() {
        List<Status> statuses = new ArrayList<>();

         statusRepository.findAll().forEach(statuses::add);

        return statuses;
    }

    public void addStatus(Status status) {
        statusRepository.save(status);
    }

    public void deleteStatusById(int statusId) {
        statusRepository.deleteById(statusId);
    }
}
