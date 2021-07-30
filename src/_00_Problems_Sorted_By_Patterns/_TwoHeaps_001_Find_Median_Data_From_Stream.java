/* [ _001_ ] [ 2 Heaps: Find Median from Data Stream ]
_______________________________________________________________________________
The median is the middle value in an ordered integer list.
For example, for arr = [2,3,4], the median is 3.

MedianFinder() -- initializes the MedianFinder object.
void addNum(int num)  -- adds the integer num from the data stream to the data structure.
double findMedian() -- returns the median of all elements so far.

Logic: https://youtu.be/1LkOrc-Le-Y?t=933
The basic idea is to maintain two heaps: a max-heap and a min-heap.
The max heap stores the smaller half of all numbers while the min heap stores the larger half.
The sizes of two heaps need to be balanced each time when a new number is inserted so that
their size will not be different by more than 1. Therefore each time when findMedian() is called we check
if two heaps have the same size. If they do, we should return the average of the two top values of heaps.
Otherwise we return the top of the heap which has one more element.

                     3 4 5 6    |    7  8  9  10    [Main idea is to keep 1st & second Half balanced]
                           ^         ^
                        topOf PQ    TopOf
                        1stHalf    2ndHalfPQ

*/
package _00_Problems_Sorted_By_Patterns;

import java.util.PriorityQueue;

public class _TwoHeaps_001_Find_Median_Data_From_Stream {
    /** initialize your data structure here. */
    PriorityQueue<Integer> firstHalf;  //1st half (left half) this will be in reverse order (max heap)
    PriorityQueue<Integer> secondHalf; //2nd half (Right half) sorted in natural order

    public _TwoHeaps_001_Find_Median_Data_From_Stream() {
        firstHalf = new PriorityQueue<>((a, b) -> b - a);
        secondHalf= new PriorityQueue<>();
    }

    public void addNum(int num) {
        // 1st Part of problem: where incoming num will go? first part or second Part?
        // if its very first num or its smaller then the top of First Half, for sure its a firstHalf candidate
         if(firstHalf.isEmpty() || num <= firstHalf.peek()){
             firstHalf.offer(num);
         }else{
             secondHalf.offer(num);
         }
        // 2nd Part of Problem: balance the both part, max diff in size can be +1 only
        //Case one: if the 1st haft has more elements, move to 2nd half
        if(firstHalf.size() == secondHalf.size()+2){
            secondHalf.offer(firstHalf.poll());
        }
        //Case one: if the 2nd haft has more elements, move to 1st half
        else if(secondHalf.size()==firstHalf.size()+2){
            firstHalf.offer(secondHalf.poll());
        }
    }

    public double findMedian() {
        if (firstHalf.size() == secondHalf.size()) {
            if(firstHalf.isEmpty())return -1;
            return (double) (firstHalf.peek() + secondHalf.peek()) / 2;
        }

        return firstHalf.size() > secondHalf.size() ? firstHalf.peek() : secondHalf.peek();
    }

    public static void main(String[] args) {
        _TwoHeaps_001_Find_Median_Data_From_Stream findMedianOfStream = new _TwoHeaps_001_Find_Median_Data_From_Stream();
        findMedianOfStream.addNum(5);
        System.out.println(findMedianOfStream.findMedian());
        findMedianOfStream.addNum(3);
        findMedianOfStream.addNum(4);
        System.out.println(findMedianOfStream.findMedian());
        findMedianOfStream.addNum(2);
        System.out.println(findMedianOfStream.findMedian());
        findMedianOfStream.addNum(6);
        System.out.println(findMedianOfStream.findMedian());
    }
}
