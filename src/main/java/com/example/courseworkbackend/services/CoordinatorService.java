package com.example.courseworkbackend.services;

import com.example.courseworkbackend.entities.Awakener;
import com.example.courseworkbackend.entities.AwakenerInGroup;
import com.example.courseworkbackend.entities.AwakenerInGroupKey;
import com.example.courseworkbackend.entities.Group;
import com.example.courseworkbackend.entities.dao.responses.GroupR;
import com.example.courseworkbackend.repositories.AwakenerInGroupRepository;
import com.example.courseworkbackend.repositories.AwakenerRepository;
import com.example.courseworkbackend.repositories.GroupRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CoordinatorService {
    @Autowired
    private AwakenerInGroupRepository awakenerInGroupRepository;
    @Autowired
    private AwakenerRepository awakenerRepository;
    @Autowired
    private GroupRepository groupRepository;

    public void addGroup(String name, Integer accessLevel){
        Group newGroup = new Group();
        newGroup.setAccessLevel(accessLevel).setName(name);
        groupRepository.save(newGroup);
    }

    public List<GroupR> getGroupList(){
        List<Group> list = groupRepository.findAll();
        List<GroupR> listNew = new ArrayList<>();
        if (!list.isEmpty()) {
            for (Group group : list) {
                listNew.add(
                        new GroupR()
                                .setId(group.getId_group())
                                .setName(group.getName())
                                .setAccessLevel(group.getAccessLevel()));
            }
        }
        return listNew;
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
