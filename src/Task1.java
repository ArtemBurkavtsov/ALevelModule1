import java.util.Arrays;

public class Task1 {
    public static void main(String[] args) {
        int[] array = {1, 4, 5, 1, 1, 3};
        int result = countMassElem(array);
        System.out.println("Количество различных элементов: " + result);
    }

    public static int countMassElem(int[] array) {
        if (array.length == 0){
            return 0;
        }

        Arrays.sort(array);
        int countMass = 1;

        for (int i = 1; i < array.length; i++) {
            if (array[i] != array[i - 1]) {
                countMass++;
            }
        }
        return countMass;
    }
}
