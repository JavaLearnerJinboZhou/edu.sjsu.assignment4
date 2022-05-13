package edu.sjsu.assignment4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class MyCollections {
    public static void printFiles(Queue<File> files) {
        while (!files.isEmpty()) {
            //remove file
            File r_file = files.poll();
            //scan file each line and print
            try {
                Scanner scanner = new Scanner(r_file);
                while (scanner.hasNextLine()) {
                    System.out.println(scanner.nextLine());
                }
                System.out.println("***");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    public static void downsize(LinkedList<String> employee, int i) {
        Iterator<String> iter = employee.listIterator();
        int index = 1;
        while (iter.hasNext()) {
            iter.next();
            if (index % i == 0) {
                iter.remove();
                index++;
            }
        }
    }
    public static boolean isBalanced(String str) {
        Stack<Character> stck = new Stack<>();
        if (str.length() == 0) {
            return false;
        }
        for (int i = 0; i < str.length(); i++) {
            //push '(' and '[' if these exist
            if (str.charAt(i) == '(' || str.charAt(i) == '[') {
                stck.push(str.charAt(i));
            }
            //
            else if (str.charAt(i) == ')') {
                if (!stck.isEmpty() && stck.peek() == '(') {
                    stck.pop();
                } else {
                    return false;
                }
            }
            //
            else if (str.charAt(i) == ']') {
                if (!stck.isEmpty() && stck.peek() == '[') {
                    stck.peek();
                } else {
                    return false;
                }
            }
        }
        //empty stack is balanced
        return stck.isEmpty();
    }

    public static void main(String[] args) {
        LinkedList<String> employee = new LinkedList<>(Arrays.asList("Tom","Cathy","Trudy","Denny"));
        System.out.println(employee);
        downsize(employee, 3);
        System.out.println(employee);

        System.out.println(isBalanced("System.out.println(list.get(0))"));  //true
        System.out.println(isBalanced("System.out.println(list.get(0)"));   //false
        System.out.println(isBalanced("[](3*5)^2"));    //true
        System.out.println(isBalanced("[(2+3]*5)^2"));  //false
        System.out.println(isBalanced("[(3*5)]^2]"));   //false
    }
}
