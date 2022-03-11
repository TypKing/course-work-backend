package com.example.courseworkbackend.services;

import com.example.courseworkbackend.entities.Awakener;
import com.example.courseworkbackend.entities.AwakenerInGroup;
import com.example.courseworkbackend.entities.AwakenerInGroupKey;
import com.example.courseworkbackend.entities.Group;
import com.example.courseworkbackend.repositories.AwakenerInGroupRepository;
import com.example.courseworkbackend.repositories.AwakenerRepository;
import com.example.courseworkbackend.repositories.GroupRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service
@RequiredArgsConstructor
public class CoordinatorService {
    @Autowired
    private AwakenerInGroupRepository awakenerInGroupRepository;
    @Autowired
    private AwakenerRepository awakenerRepository;
    @Autowired
    private GroupRepository groupRepository;

    public void addGroup(Integer accessLevel){
        Group newGroup = new Group();
        newGroup.setAccessLevel(accessLevel);
        groupRepository.save(newGroup);
    }

    public void addAwakenerToGroup(Long id_human, Long id_group, Timestamp join_time) throws Exception {
        Group group = groupRepository.getById(id_group);
        Awakener awakener = awakenerRepository.getById(id_human);

        if(awakenerInGroupRepository.findById(new AwakenerInGroupKey().setGroup_id(group).setHuman_id(awakener.getHuman())).isPresent()){
            throw new Exception();
        }

        awakenerInGroupRepository.save(
                new AwakenerInGroup().setAwakenerInGroupKey(
                        new AwakenerInGroupKey().setGroup_id(group).setHuman_id(awakener.getHuman()))
                        .setJoinTime(join_time).setEndTime(null));
    }

    public void removeAwakenerFromGroup(Long id_human, Long id_group) throws Exception {
        Group group = groupRepository.getById(id_group);
        Awakener awakener = awakenerRepository.getById(id_human);

        AwakenerInGroup awakenerInGroup = awakenerInGroupRepository.getById(
                new  AwakenerInGroupKey().setGroup_id(group).setHuman_id(awakener.getHuman()));
        awakenerInGroup.setEndTime(new Timestamp(System.currentTimeMillis()));

        if(awakenerInGroup.getEndTime() != null){
            throw new Exception();
        }


        awakenerInGroupRepository.save(awakenerInGroup);
    }

    

}
