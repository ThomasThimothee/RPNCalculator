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
public interface Stack<T> {
  void push(T element);
  T pop();
  boolean isEmpty();
  }
