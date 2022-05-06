package edu.montana.csci.csci366.strweb.ops;

import java.util.Arrays;
import java.util.Collections;

/**
 * This class is a simple sorter that implements sorting a strings rows in different ways
 */
public class Sorter {
    private final String _strings;

    public Sorter(String strings) {
        _strings = strings;
    }

    public String sort() {

        //we have to split with an or because we need to split amongst new line and carridge return line feed
        String[] split = _strings.split("\n|\r\n");
        //then we are using the arrays.sort to sort the array of strings
        Arrays.sort(split);
        //this .join method. joins strings together with the given delimeter /n
        return String.join("\n", split);
    }

    public String reverseSort() {
        //we have to split with an or because we need to split amongst new line and carridge return line feed
        String[] split = _strings.split("\n|\r\n");
        //then we are using the arrays.sort to sort the array of strings, and tag on reverse order to sort in reverse
        Arrays.sort(split, Collections.reverseOrder());
        //this .join method. joins strings together with the given delimeter /n
        return String.join("\n", split);

    }

    public String parallelSort() {
        //we have to split with an or because we need to split amongst new line and carridge return line feed
        String[] split = _strings.split("\n|\r\n");
        //then we are using the arrays.parallelSort to sort the array of strings, and tag on reverse order to sort in reverse
        Arrays.parallelSort(split);
        //this .join method. joins strings together with the given delimeter /n
        return String.join("\n", split);
    }
}
