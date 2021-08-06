package com.example.gamecricket.controller;

import com.example.gamecricket.entities.Innings;
import com.example.gamecricket.entities.Match;
import com.example.gamecricket.services.InningsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class InningsController {

    @Autowired
    private InningsService inningsService;

    @GetMapping("/innings")
    public List<Innings> getAllInnings()
    {
        return inningsService.getAllInnings();
    }

    @RequestMapping(method = RequestMethod.POST,value = "/innings")
    public void createInnings(@RequestBody Innings innings)
    {
        inningsService.createInnings(innings);
    }

    @RequestMapping(method = RequestMethod.PUT,value = "/innings/{id}")
    public void updateInnings(@RequestBody Innings innings,@PathVariable int id)
    {
        inningsService.updateInnings(id,innings);
    }

    @RequestMapping("/innings/{id}")
    public Optional<Innings> getInnings(@PathVariable int id)
    {
        return inningsService.getInnings(id);
    }

    @RequestMapping(method=RequestMethod.DELETE,value="/innings/{id}")
    public void deleteInnings(@PathVariable int id)
    {
        inningsService.deleteInnings(id);
    }

}
