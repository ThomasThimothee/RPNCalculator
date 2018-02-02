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
public class PathStack<T> implements Stack<T>{

    private Path<T> elements = null;

  @Override
  public void push(T element) {
    elements = new LinkedPath<>(element, elements);
    }

  @Override
  public T pop() {
    T element = elements.getFirst();
    elements = elements.getRest();
    return element;
    }

  @Override
  public boolean isEmpty() {
    return elements == null;
    }
  

    public Long sum(LinkedPath path) {
        if (path == null) {
            return 0l; // empty path = null 
        }
        return (Long) path.getFirst() + sum((LinkedPath)path.getRest());
    }

    public Long max(LinkedPath path) {
        Long first = (Long) path.getFirst();
        if (path.getRest() == null) {
            return first;
        }
        Long maxOfRest = max((LinkedPath)path.getRest());
        return first > maxOfRest ? first : maxOfRest;
    }

    public Path<T> getData() {
        return elements;
    }

    public void setData(Path<T> data) {
        this.elements = data;
    }
    
}
