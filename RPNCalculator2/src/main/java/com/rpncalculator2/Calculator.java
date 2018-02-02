/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rpncalculator2;

import java.util.Scanner;

/**
 *
 * @author thomasthimothee
 */
public class Calculator {

    private PathStack stack = new PathStack();
    private Scanner scan = new Scanner(System.in);

    public void run() {
        String input = "";

        while (true) {
            System.out.println("");
            input = scan.next();
            try {
                int numberInput = Integer.parseInt(input);
                stack.push(numberInput);
            } catch (NumberFormatException e) {
                System.out.println("1");
                if (input.equals("+")) {
                    System.out.println("2");
                    stack.push((int) stack.pop() + (int) stack.pop());
                } else if (input.equals("-")) {
                    stack.push((int) stack.pop() - (int) stack.pop());
                } else if (input.equals("*")) {
                    stack.push((int) stack.pop() * (int) stack.pop());
                } else if (input.equals("/")) {
                    stack.push((int) stack.pop() / (int) stack.pop());
                } else if (input.equals("stop")) {
                    return;
                }
            }
            printReverseStack(stack.getData());
        }
    }

    public void printStack(Path path) {
        if (path.getRest() == null) {
            return;
        }
        System.out.println(path.getFirst());
        printStack((LinkedPath) path.getRest());
    }

    public void printReverseStack(Path path) {
        if (path == null) {
            return;
        }
        printReverseStack((LinkedPath) path.getRest());
        if (path.getFirst() != null) {
            System.out.println("> " + path.getFirst());
        }
    }
}
