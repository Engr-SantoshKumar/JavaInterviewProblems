/**
[73] [Friends of Friends]
--------------------------------------------------------------------------------------------------------------
 PROBLEM STATEMENT:
 Create a Person class with a collection of friends (also Person objects) and write a function
 that returns only the friends of friends of a given person (for example for a friend recommendation system).
 */
package PrepSetOne;
import java.util.*;
import java.util.LinkedList;



public class _Goo_73_Friends_Of_Friends{

    private static void friendsOfFriends(Person source) {
        Set<Person> visited = new HashSet<>();
        List<Person> result = new ArrayList<>();
        Queue<Person> queue = new LinkedList<>();

        // Step 1: load the immediate friends to que and visited as we
        //          need friends of friends not immediate friend.
        for (Person p : source.friendsList) {
            queue.add(p);
            visited.add(p);
        }

        //Step 2: now lets all the friends of person in queue.
        while (!queue.isEmpty()) {
            Person curPerson = queue.remove();
            for (Person p : curPerson.friendsList)
            {
                if (visited.contains(p)) continue;
                visited.add(p);
                result.add(p);
                queue.add(p);
            }
        }
        System.out.println(" friends of friends of "+source + " => "
                +Arrays.toString(result.toArray()));
    }

    public static void main(String[] args){
        Person p0 = new Person("P0");
        Person p1 = new Person("P1");
        Person p2 = new Person("P2");
        Person p3 = new Person("P3");
        Person p4 = new Person("P4");
        Person p5 = new Person("P5");

        p0.setFriends(p1);
        p0.setFriends(p2);
        p0.setFriends(p3);
        p1.setFriends(p3);
        p1.setFriends(p5);
        p2.setFriends(p1);
        p3.setFriends(p4);
        p4.setFriends(p3);
        p4.setFriends(p5);

        friendsOfFriends(p0);

    }
}
// person class
class Person{

    private final String name;
    Set<Person> friendsList = new HashSet<>();
    // set name
    Person(String name) {
        this.name = name;
    }
    // set friendsList
    void setFriends(Person p){
        friendsList.add(p);
    }
    // created a return to print name
    public String toString(){
        return this.name;
    }
}


