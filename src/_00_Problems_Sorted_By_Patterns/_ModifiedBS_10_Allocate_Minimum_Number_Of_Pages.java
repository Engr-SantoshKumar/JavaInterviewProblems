/* [ _ModifiedBS_09_ ] [ Allocate Minimum Number Of Pages ]
_______________________________________________________________________________
    Given number of pages in n different books and m students. The books are arranged in ascending order of number of pages.
    Every student is assigned to read some consecutive books.
    The task is to assign books in such a way that the maximum number of pages assigned to a student is minimum.

    Input : pages[] = {12, 34, 67, 90}
            m = 2
    Output : 113
        suppose noOfStud = 2 then what are possibilities:   12|34+67+90 , 12+34|67+90, 12+34+67|90
                                                            12|191          46/157         113|90
                                                    max ->    191             157            113

    Of the 3 cases, Option 3 has the minimum pages = 113.
*/
package _00_Problems_Sorted_By_Patterns;
public class _ModifiedBS_10_Allocate_Minimum_Number_Of_Pages {
    /*
        What we learned from given explanation:
        A student have to read minimum Max pages by ready just one book of minimum page i.e 90 (when noOfStud = noOfBooks)
        Or a student have to ready all the books alone = sumOfAllBooksPages = 12+34+67+90 = 203page (when noOfStud = 1)
        The answer is between these min and max.
        Use binary search to approach the correct answer.
        As previous problem, will take midValue of (lo and hi) and see ifPossible to finish all
        book with given number of students by reading max midValue and accordingly move midValue
        
              ● Time complexity: O(n * log(sum of array))
                    The binary search costs O(log(sum of array)) *
                    the time complexity is O(n) since we only need to go through the whole array.
    */
    
    public static int findPage(int[] books, int students){
        int totalNoOfPages =0;
        int maxPagesBook = 0;
        for(int pages:books){
            totalNoOfPages += pages;
            maxPagesBook = Math.max(maxPagesBook, pages);
        }
        if(students==1) return totalNoOfPages;
        if(students == books.length) return maxPagesBook;
        
        int lo = maxPagesBook;
        int hi = totalNoOfPages;
        int result =0;
        
        while(lo <= hi){
            int mid = lo + (hi-lo)/2;
            
            if(isPossible(books, students, mid)){
                result = mid;
                hi = mid-1;
            }else{
                lo = mid +1;
            }
        }
        return result;
    }
    
    private static boolean isPossible(int[] books, int students, int mid) {
        int curStud = 1;
        int curPageSum =0;
        //lets find how many students we need to read all given books
        // when a student allowed only to read maximum number of page is mid
        for (int book : books) {
            curPageSum += book;
            if (curPageSum > mid) {
                curStud++;
                curPageSum = book; // reset currentPageSum to current book page count as now its assign to new guy
            }
        }
        return curStud <= students;
    }
    public static void main(String[] args) {
        int[] arr = new int[]{12, 34, 67, 90};
        int givenTime = 2;
        System.out.println(findPage(arr, givenTime));
    }
}
