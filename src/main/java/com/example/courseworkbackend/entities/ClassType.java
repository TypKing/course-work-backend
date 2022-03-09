package com.example.courseworkbackend.entities;

public enum ClassType {
    ARTIFACT, MONSTER, RECYCLING;

    public static ClassType getClassType(String s){
        switch (s) {
            case "ARTIFACT":
                return ARTIFACT;
            case "MONSTER":
                return MONSTER;
            case "RECYCLING":
                return RECYCLING;
            default:
                return null;
        }
    }
}

