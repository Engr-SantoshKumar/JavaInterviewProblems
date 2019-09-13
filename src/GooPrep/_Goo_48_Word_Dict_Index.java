/** 48 [Longest Substring Which Contains K Unique Characters]
 -----------------------------------------------------------------------------------------------------------------
Design an algorithm to fetch the index of a given word using the API function
        string getWordFromDict(int index)
        Which returns a word at a particular index from a list of alphabetical word list.
 */

package GooPrep;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class _Goo_48_Word_Dict_Index{

    public static void main(String args[]) {
        String simpsons[] = {"Bart", "Hugo", "Lisa", "Marge",
                "Homer", "Maggie", "Roy"};

        // Convert to list
        ArrayList list = new ArrayList(Arrays.asList(simpsons));

        // Ensure list sorted
        Collections.sort(list);
        System.out.println("\nSorted list: [length: " + list.size() + "]");
        System.out.println(list);

        // Search for element in list
        int index = Collections.binarySearch(list, "Maggie");
        System.out.println("\nFound Maggie @ " + index);

        // element at given index
        System.out.println("\nFourth element of the ArrayList: "+list.get(3));

        // Search for element not in list
        index = Collections.binarySearch(list, "Jimbo Jones");
        System.out.println("\nDidn't find Jimbo Jones @ " + index);

        // Insert
        int newIndex = -index - 1;
        list.add(newIndex, "Jimbo Jones");
        System.out.println("\nWith Jimbo Jones added: [length: " + list.size() + "]");
        System.out.println(list);
    }

}
