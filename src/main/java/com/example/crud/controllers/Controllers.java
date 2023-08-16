package com.example.crud.controllers;

import com.example.crud.model.Model;
import com.example.crud.repository.DataRepo;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
public class Controllers {

    @Autowired
    private DataRepo repo;

    private Map<String, String> response;

    @GetMapping("/getdata")
        public Map<String, String> get()
    {
        response = new HashMap<>();
        response.put("msg", "Data Listed successfully");
        Gson gson = new Gson();
        String jsonString = gson.toJson(repo.findAll());
        response.put("data", jsonString);

        return response;
    }

    @PostMapping("/postdata")
    public Map<String, String> post(@RequestBody Model data ){

        repo.save(data);
        response = new HashMap<>();
        response.put("msg", "Data inserted successfully");
        Gson gson = new Gson();
        String jsonString = gson.toJson(data);
        response.put("data", jsonString);
        return response;
    }

    @DeleteMapping("/deletedata/{id}")
    public Map<String, String> delete(@PathVariable Long id)
    {
        repo.deleteById(id);
        response = new HashMap<>();
        response.put("msg", "Data deleted successfully");
        response.put("id", String.valueOf(id));
        return response;
    }

    @PutMapping("/updatedata")
    public Map<String, String> updateName(@RequestBody Model updatedData) {
        Optional<Model> existingData = repo.findById(updatedData.getId());
            Model dataToUpdate = existingData.get();
            dataToUpdate.setName(updatedData.getName());
            repo.save(dataToUpdate);
            response = new HashMap<>();
            response.put("msg", "Data updated successfully");
            Gson gson = new Gson();
            String jsonString = gson.toJson(dataToUpdate);
            response.put("data", jsonString);
            return response;
    }
}
