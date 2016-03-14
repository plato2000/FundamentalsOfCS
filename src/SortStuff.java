import java.util.ArrayList;

/**
 * Created by plato2000 on 3/9/16.
 */
public class SortStuff {
    public static void merge(ArrayList<Integer> merged, ArrayList<Integer> left, ArrayList<Integer> right) {
        int leftIndex = 0;
        int rightIndex = 0;
        while(leftIndex < left.size() && rightIndex < right.size()) {
            if(left.get(0) <= right.get(0)) {
                merged.add(left.get(leftIndex));
                leftIndex++;
            } else {
                merged.add(right.get(0));
                rightIndex++;
            }
        }
        if(!right.isEmpty()) {
            for(int i = rightIndex; i < right.size(); i++) {
                merged.add(right.get(i));
            }
        } else if(!left.isEmpty()) {
            for(int i = leftIndex; i < left.size(); i++) {
                merged.add(left.get(i));
            }
        }
    }

    public static void partition(ArrayList<Integer> list, int start, int end) {
        int pivot = list.get(start);
        int leftPointer = start;
        int rightPointer = end;
        while(leftPointer <= rightPointer) {
            while(leftPointer < list.size() && list.get(leftPointer) <= pivot) {
                leftPointer++;
            }
            while(rightPointer > 0 && list.get(rightPointer) > pivot) {
                rightPointer--;
            }
            if(rightPointer < leftPointer) {
                int temp = list.get(rightPointer);
                list.set(rightPointer, pivot);
                list.set(start, temp);
                return;
            } else {
                int temp = list.get(rightPointer);
                list.set(rightPointer, list.get(leftPointer));
                list.set(leftPointer, temp);
            }
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>(10);
        for(int i = 10; i > 0; i--) {
            list.add(i);
        }
        System.out.println(list);
        partition(list, 0, 9);
        System.out.println(list);
    }

}
