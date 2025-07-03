package oop.finalexam.t1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * ListProcessor implements a two-phase algorithm that processes two input lists:
 *
 * <p><strong>Phase 1 - Transformation:</strong></p>
 * <ul>
 * <li>For each number N in list1, access list2 at index (N+1)</li>
 * <li>If index is valid: append N to the string from list2[N+1]</li>
 * <li>If index is out of bounds: insert "ERROR"</li>
 * <li>Build list3 with these transformed values</li>
 * </ul>
 *
 * <p><strong>Phase 2 - Deletion:</strong></p>
 * <ul>
 * <li>Remove all entries from list3 whose indexes appear in list1</li>
 * <li>Keep only entries at indexes NOT mentioned in list1</li>
 * </ul>
 *
 * <p><strong>Error Handling:</strong></p>
 * When a value in list1 is larger than (list2.size() - 1), the corresponding
 * entry in list3 becomes "ERROR" instead of causing an IndexOutOfBoundsException.
 *
 * @author Zaali Injgia
 */
public class T1 {

    /**
     * Processes two input lists using the specified two-phase algorithm.
     *
     * <p>Example: if list1=[1,2] and list2=["a","b","c","d"], then:</p>
     * <ul>
     * <li>Phase 1: list3 = ["c1", "d2"] (1→list2[2]+"1", 2→list2[3]+"2")</li>
     * <li>Phase 2: Remove indexes 1,2 from list3 → result = ["c1"] (keeps index 0)</li>
     * </ul>
     *
     * @param list1 List of integers used as (index-1) values for accessing list2
     *              and later as deletion indices for list3
     * @param list2 List of strings to be accessed and transformed
     * @return A new list containing the filtered results after transformation and deletion
     * @throws IllegalArgumentException if either input list is null
     */
    public static List<String> processLists(List<Integer> list1, List<String> list2) {
        if (list1 == null || list2 == null) {
            throw new IllegalArgumentException("Input lists cannot be null");
        }

        List<String> list3 = new ArrayList<>();

        // Phase 1: Build list3 by transforming values from list1 and list2
        for (Integer number : list1) {
            int targetIndex = number + 1;

            // Error handling: check bounds before accessing list2
            if (targetIndex >= 0 && targetIndex < list2.size()) {
                // Valid index: concatenate string from list2 with the number
                list3.add(list2.get(targetIndex) + number);
            } else {
                // Invalid index: insert error marker
                list3.add("ERROR");
            }
        }

        // Phase 2: Remove entries from list3 using indices from list1
        Set<Integer> indicesToDelete = new HashSet<>(list1);
        List<String> filteredResult = new ArrayList<>();

        for (int i = 0; i < list3.size(); i++) {
            // Keep only entries whose index is NOT in list1
            if (!indicesToDelete.contains(i)) {
                filteredResult.add(list3.get(i));
            }
        }

        return filteredResult;
    }

    public static void main(String[] args) {
        // Predefined test data as specified in the animation
        List<Integer> list1 = Arrays.asList(10, 1, 9, 2, 5, 7, 6, 4, 8, 3);
        List<String> list2 = Arrays.asList("iih", "kwy", "xmg", "ytr", "dky", "huw",
                "sqw", "yci", "pup", "gbl", "qbp", "wms");

        System.out.println("Input list1: " + list1);
        System.out.println("Input list2: " + list2);
        System.out.println();

        List<String> result = processLists(list1, list2);

        System.out.println("Final result:");
        for (int i = 0; i < result.size(); i++) {
            System.out.println("Index " + i + ": " + result.get(i));
        }
    }
}