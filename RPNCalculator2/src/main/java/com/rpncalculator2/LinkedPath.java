/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rpncalculator2;

/**
 *
 * @author thomasthimothee
 */
public class LinkedPath<T> implements Path<T> {

    private T first;
    private Path<T> rest;

    public LinkedPath(T first, Path<T> rest) {
        this.first = first;
        this.rest = rest;
    }
    
    private static <T> Path<T> create(T[] elements, int index){ //used to create a path, between elements in an array
        if (elements.length == index) return null;
        Path<T> path = new LinkedPath<>(elements[index], create(elements, index + 1));
        return path;
    }
    
    public static<T> Path<T> create(T... elements){
        return create(elements,0);
    }

    @Override
    public T getFirst() {
        return first;
    }

    @Override
    public Path<T> getRest() {
        return rest;
    }

}
