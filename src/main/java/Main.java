import classes.EnumSex;
import classes.PeopleLinkedListCollection;
import classes.Student;
import classes.Teacher;
import configuration.Conf;
import frame.MainJFrame;

import java.util.Date;

/**
 * Created by CHester on 15/10/19.
 */
public class Main {

    public static void main(String[] args) {
        PeopleLinkedListCollection peopleLinkedListCollection = new PeopleLinkedListCollection();
        /*
         * 乱序添加几个教师和学生
         */
        peopleLinkedListCollection.peopleLinkedList.add(new Student("001", EnumSex.male, new Date(1991 - 1900, 4 - 1, 5),
                "370600199104051122", "201321010001", "Computer Software and Theory", "2013"));
        peopleLinkedListCollection.peopleLinkedList.add(new Student("002", EnumSex.female, new Date(1993 - 1900, 1 - 1, 1),
                "333444199301015566", "201321010002", "Educational Technology", "2014"));
        peopleLinkedListCollection.peopleLinkedList.add(new Teacher("101", EnumSex.male, new Date(1976 - 1900, 5 - 1, 21),
                "222111197604212211", "SET", "08032", "副教授", "18"));
        peopleLinkedListCollection.peopleLinkedList.add(new Teacher("102", EnumSex.female, new Date(1981 - 1900, 10 - 1, 18),
                "222111198110182211", "LAW", "08014", "讲师", "15"));
        peopleLinkedListCollection.peopleLinkedList.add(new Student("003", EnumSex.female, new Date(1995 - 1900, 11 - 1, 12),
                "333444199351112556", "201321010022", "Distance Education", "2013"));
        peopleLinkedListCollection.peopleLinkedList.add(new Teacher("103", EnumSex.male, new Date(1966 - 1900, 4 - 1, 22),
                "222111196604222211", "CIST", "08048", "教授", "27"));

        /*
         * 将人员信息存入peopleInfo.dat
         */

        String path = Conf.getPath();
        peopleLinkedListCollection.toStoreAsString(peopleLinkedListCollection.peopleLinkedList, path);
        new MainJFrame().setVisible(true);
        PeopleLinkedListCollection peopleLinkedListCollection1 = new PeopleLinkedListCollection();
        peopleLinkedListCollection1.peopleLinkedList = PeopleLinkedListCollection.readFromStorage(path);

    }
}
