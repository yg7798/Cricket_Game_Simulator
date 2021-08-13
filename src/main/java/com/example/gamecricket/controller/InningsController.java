package com.example.gamecricket.controller;

import com.example.gamecricket.entities.Innings;
import com.example.gamecricket.exception.NotFoundException;
import com.example.gamecricket.response_dto.BaseResponse;
import com.example.gamecricket.services.InningsService;
import com.example.gamecricket.services.InningsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/innings")
public class InningsController {

    @Autowired
    private InningsService inningsService;

    @GetMapping
    public List<Innings> getAllInnings()
    {
        return inningsService.getAllInnings();
    }

    @RequestMapping(method = RequestMethod.POST)
    public BaseResponse createInnings(@RequestBody Innings innings)
    {
        return inningsService.createInnings(innings);
    }

    @RequestMapping(method = RequestMethod.PUT,value = "/{id}")
    public BaseResponse updateInnings(@RequestBody Innings innings,@PathVariable int id)
    {
        return inningsService.updateInnings(id,innings);
    }

    @RequestMapping("/{id}")
    public ResponseEntity<?> getInnings(@PathVariable int id)
    {
        Innings innings=inningsService.getInnings(id);
        if(innings.getInningsID()==0)
        {
            throw new NotFoundException("InningsID "+id+" NOT FOUND");
        }
        return new ResponseEntity<>(innings, HttpStatus.OK);
    }

    @RequestMapping(method=RequestMethod.DELETE,value="/{id}")
    public void deleteInnings(@PathVariable int id)
    {
        inningsService.deleteInnings(id);
    }
}
