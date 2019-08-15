package edu.tallerjava.exceptions;

public class EntityNotFoundException {
    public EntityNotFoundException(){
        throw new Error("Not found");
    }
}
