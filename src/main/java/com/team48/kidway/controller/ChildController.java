package com.team48.kidway.controller;

import com.team48.kidway.dto.ChildDTO;
import com.team48.kidway.service.ChildService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/children")
public class ChildController {
    @Autowired
    private ChildService childService;

    @PostMapping
    public ResponseEntity<ChildDTO> createChild(@RequestBody ChildDTO childDTO) {
        ChildDTO newChild = childService.createChild(childDTO);
        return ResponseEntity.ok(newChild);
    }

}