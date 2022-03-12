package com.example.courseworkbackend.entities;

import lombok.*;
import lombok.experimental.Accessors;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.Embeddable;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
@EqualsAndHashCode
@Accessors(chain = true)
@Getter
@Setter
public class AwakenerInGroupKey implements Serializable {


    private static final long serialVersionUID = -7821055594688334072L;
    @ManyToOne
    @JoinColumn(name = "id_human")
    private Human human_id;


    @ManyToOne
    @JoinColumn(name = "id_group")
    private Group group_id;
}
