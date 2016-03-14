/**
 * Created by plato2000 on 3/14/16.
 */
public class XOSort {

    public static int findLastX(String thingToSort, int startIndex, int endIndex) {
        System.out.println("Start index: " + startIndex + " End index: " + endIndex);
        if(startIndex == endIndex && isLastX(thingToSort, startIndex)) return startIndex;
        if(endIndex - startIndex >= 1) {
            if(isLastX(thingToSort, startIndex)) {
                return startIndex;
            } else if(isLastX(thingToSort, endIndex)){
                return endIndex;
            } else {
                return -1;
            }
        }
        if(thingToSort.charAt((int) ((endIndex + startIndex) / 2)) == 'O') {
            return findLastX(thingToSort, startIndex, (int) ((endIndex + startIndex) / 2));
        } else {
            return findLastX(thingToSort, (int) ((endIndex + startIndex) / 2), endIndex);
        }
    }

    public static boolean isLastX(String thingToSort, int index) {
        if(index == thingToSort.length() - 1) return thingToSort.charAt(index) == 'X';
        return thingToSort.charAt(index + 1) == 'O' && thingToSort.charAt(index) == 'X';
    }

    public static void main(String[] args) {
        String thingToSort = "OOOOOOOO";
        System.out.println(findLastX(thingToSort, 0, thingToSort.length() - 1));
    }
}
