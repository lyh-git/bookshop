package com.bookshop.test;

import java.util.Arrays;
import java.util.Comparator;

import javax.swing.Action;
import javax.swing.JTextField;
import javax.swing.text.JTextComponent;

public class Main {
    public static void main(String args[]) {
        JTextComponent component = new JTextField();

        // Process action list
        Action actions[] = component.getActions();
        // Define comparator to sort actions
        Comparator<Action> comparator = new Comparator<Action>() {
            public int compare(Action a1, Action a2) {
                String firstName = (String) a1.getValue(Action.NAME);
                String secondName = (String) a2.getValue(Action.NAME);
                return firstName.compareTo(secondName);
            }
        };
        Arrays.sort(actions, comparator);

        int count = actions.length;
        System.out.println("Count: " + count);
        for (int i = 0; i < count; i++) {
            System.out.printf("%28s : %s\n",actions[i].getValue(Action.NAME),actions[i].getClass().getName());
        }
    }
}
