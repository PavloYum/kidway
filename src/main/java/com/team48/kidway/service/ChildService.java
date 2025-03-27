package com.team48.kidway.service;

import com.team48.kidway.dto.ChildDTO;
import com.team48.kidway.model.Child;
import com.team48.kidway.repository.ChildRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChildService {
    @Autowired
    private ChildRepository childRepository;

    public ChildDTO createChild(ChildDTO childDTO) {
        Child child = new Child();
        child.setName(childDTO.getName());
        child.setAge(childDTO.getAge());
        child.setWeight(childDTO.getWeight());
        child.setHeight(childDTO.getHeight());
        child.setHobbies(childDTO.getHobbies());

        Child savedChild = childRepository.save(child);
        return mapToDTO(savedChild);
    }

    private ChildDTO mapToDTO(Child child) {
        ChildDTO childDTO = new ChildDTO();
        childDTO.setId(child.getId());
        childDTO.setName(child.getName());
        childDTO.setAge(child.getAge());
        childDTO.setWeight(child.getWeight());
        childDTO.setHeight(child.getHeight());
        childDTO.setHobbies(child.getHobbies());
        return childDTO;
    }
}