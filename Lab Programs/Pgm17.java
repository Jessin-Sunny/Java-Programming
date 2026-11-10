import java.util.Arrays;
public class Pgm17 
{
    public static void main(String[] args) 
    {
        String[] names = {"John", "Doe", "Jane", "Doe", "Mary", "Smith"};
        System.out.println("Unsorted Names: " + Arrays.toString(names));
        quickSort(names, 0, names.length - 1);
        System.out.println("Sorted Names: " + Arrays.toString(names));
    }

    public static void quickSort(String[] names, int low, int high) 
    {
        if (low < high) {
            int pi = partition(names, low, high);
            quickSort(names, low, pi - 1);
            quickSort(names, pi + 1, high);
        }
    }

    public static int partition(String[] names, int low, int high) {
        String pivot = names[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (names[j].compareToIgnoreCase(pivot) <= 0) {
                i++;
                String temp = names[i];
                names[i] = names[j];
                names[j] = temp;
            }
        }
        String temp = names[i + 1];
        names[i + 1] = names[high];
        names[high] = temp;
        return i + 1;
    }
}

