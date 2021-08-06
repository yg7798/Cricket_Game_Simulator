package com.example.gamecricket.entities;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@Data
@MappedSuperclass
public class Base {
    private Long createdTime;
    private Long modifiedTime;
    private boolean isDeleted;
}
