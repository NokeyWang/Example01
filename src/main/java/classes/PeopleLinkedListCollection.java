package classes;

import classes.People;
import classes.Student;
import classes.Teacher;

import java.io.*;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by CHester on 15/10/15.
 */

public class PeopleLinkedListCollection {

    public LinkedList<People> peopleLinkedList = new LinkedList<People>();

    public PeopleLinkedListCollection() {
    }

    public PeopleLinkedListCollection(LinkedList<People> peopleLinkedList) {
        this.peopleLinkedList = peopleLinkedList;
    }

}
