public class ArrayOps {
    public static void main(String[] args) {
        int [] array1 = {0};
        int [] array2 = {-202, 48, 13, 7, 8};
        System.out.println(findMissingInt(array1));
        System.out.println(counterMax(array2));
        System.out.println(secondMaxValue(array2));
        System.out.println(containsTheSameElements(new int[] {3, -4, 1, 2, 5}, new int[] {1, 3, -4, 5}));
        System.out.println(isSorted(new int[] {1, -2, 3}));
    }
    
    public static int findMissingInt (int [] array) {
        int missingNum = 0;
        for (int i = 0; i <= array.length; i++){
            if ( !contains(array, i)){
                missingNum = i;
                return missingNum;    
            }
            
        }
        return missingNum;
    }

    public static boolean contains (int [] array, int number) {
        for (int num : array){
            if (num == number) {
                return true;
            }
        }
        return false;

    }

    public static boolean contains (int [] array, int number, int index) {
        for (int i = 0; i < index; i++){
            if (array[i] == number) {
                return true;
            }
        }
        return false;
    }

    public static int maxValue(int [] array){
        int max = 0;
        for (int num : array) {
            if (num >= max) {
                max = num;
            }
        }
        return max;
    }

    public static int counterMax(int [] array) {
        int counterMax =0;
        int max = maxValue(array);
        for (int num : array) {
            if (num == max) {
                counterMax++;
            }
        }
        return counterMax;
    }

    public static int secondMaxValue(int [] array) {
        int [] arrayWithoutMax = new int [array.length - counterMax(array)];
        int index = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] != maxValue(array)) {
                arrayWithoutMax[index] = array[i];
                index++;
            }
        }

        int secondMaxValue = maxValue(arrayWithoutMax);
        return secondMaxValue;    
    }

    public static int countUnique(int [] array) {
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (!contains(array, array[i], i)){
                count++;
            }
        }
        return count;
    }    


    public static boolean containsTheSameElements(int [] array1,int [] array2) {
        if (countUnique(array1) != countUnique(array2)) {
            return false;
        }

        int [] smallSet = array1.length < array2.length ? array1 : array2;
        int [] bigSet = array1.length < array2.length ? array2 : array1;



        for (int i = 0; i < smallSet.length; i++) {
            if (!contains(bigSet, smallSet[i])) {
                return false;
            }
        }

        return true;
    }

    public static boolean isSorted(int [] array) {
        
        if (array[0] < array[array.length - 1]){
            for (int i = 0; i < array.length - 1 ; i++) {
                if (!(array[i] < array[i+1])) {
                    return false;
                }
           } 
           return true;
        }

        if (array[0] > array[array.length - 1]){
            for (int i = 0; i < array.length - 1 ; i++) {
                if (!(array[i] > array[i+1])) {
                    return false;
                }
           } 
           return true;
        }


        return false;
    }

}
