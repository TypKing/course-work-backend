package com.example.courseworkbackend.services;

import com.example.courseworkbackend.entities.Group;
import com.example.courseworkbackend.repositories.AwakenerInGroupRepository;
import com.example.courseworkbackend.repositories.AwakenerRepository;
import com.example.courseworkbackend.repositories.GroupRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CoordinatorService {

    private AwakenerInGroupRepository awakenerInGroupRepository;
    private AwakenerRepository awakenerRepository;
    private GroupRepository groupRepository;

    public void addGroup(Integer accessLevel){
        Group newGroup = new Group();
        newGroup.setAccessLevel(accessLevel);
        groupRepository.save(newGroup);
    }

    

}
