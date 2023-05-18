//java package
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class ArrayListVsLinkedList {
    public static void main(String[] args) {
        int numElements = 100000; // Кількість ел-тів в списках
        int numInsertions = 1000; // Кількість ел-тів для вставки

        //Створення списків
        List<Integer> arrayList = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();

        //Заповнення списків
        fill(arrayList, numElements, "ArrayList");
        fill(linkedList, numElements, "LinkedList");

        //Виведення
        System.out.println("Кількість елементів у списку: " + numElements);
        System.out.println("Кількість елементів для вставки: " + numInsertions);

        // Операція і замір часу для доступу за індексом
        int randomAccessIndex = numElements / 2;
        randomAccess(arrayList, randomAccessIndex, "ArrayList");
        randomAccess(linkedList, randomAccessIndex, "LinkedList");

        // Операція і замір часу для доступу за ітератором
        sequentialAccess(arrayList, "ArrayList");
        sequentialAccess(linkedList, "LinkedList");

        // Операція і замір часу для вставки на початку
        int element = 999;
        insertAtStart(arrayList, element, numInsertions, "ArrayList");
        insertAtStart(linkedList, element, numInsertions, "LinkedList");

        // Операція і замір часу для вставки у кінці
        insertAtEnd(arrayList, element, numInsertions, "ArrayList");
        insertAtEnd(linkedList, element, numInsertions, "LinkedList");

        // Операція і замір часу для вставки у середину

        //Змінна для вставки у середину
        int insertIndex = numElements / 2;

        insertAtMiddle(arrayList, element, insertIndex, numInsertions, "ArrayList");
        insertAtMiddle(linkedList, element, insertIndex, numInsertions, "LinkedList");
    }

    // Метод для заповнення списка випадковими значеннями
    private static void fill(List<Integer> list, int count, String listType) {
        long startTime = System.nanoTime();
        Random random = new Random();
        for (int i = 0; i < count; i++) {
            int randomNumber = random.nextInt(count + 1);
            list.add(randomNumber);
        }
        long endTime = System.nanoTime();
        long duration = endTime - startTime;
        System.out.printf("Fill %s: %d ns%n", listType, duration);
    }

    // Метод для доступу за індексом
    private static void randomAccess(List<Integer> list, int index, String listType) {
        long startTime = System.nanoTime();
        int element = list.get(index);
        long endTime = System.nanoTime();
        long duration = endTime - startTime;
        System.out.printf("Random access in %s: %d ns%n", listType, duration);
    }

    // Метод для доступу за ітератором
    private static void sequentialAccess(List<Integer> list, String listType) {
        long startTime = System.nanoTime();
        for (Integer element : list) {
        }
        long endTime = System.nanoTime();
        long duration = endTime - startTime;
        System.out.printf("Sequential access in %s: %d ns%n", listType, duration);
    }

    // Метод для вставки на початку
    private static void insertAtStart(List<Integer> list, int element, int numInsertions, String listType) {
        long startTime = System.nanoTime();
        for (int i = 0; i < numInsertions; i++) {
            list.add(0, element);
        }
        long endTime = System.nanoTime();
        long duration = endTime - startTime;
        System.out.printf("Insert at the start of %s: %d ns%n", listType, duration);
    }

    // Метод для вставки у кінець
    private static void insertAtEnd(List<Integer> list, int element, int numInsertions, String listType) {
        long startTime = System.nanoTime();
        for (int i = 0; i < numInsertions; i++) {
            list.add(element);
        }
        long endTime = System.nanoTime();
        long duration = endTime - startTime;
        System.out.printf("Insert at the end of %s: %d ns%n", listType, duration);
    }

    // Метод для вставки у середину
    private static void insertAtMiddle(List<Integer> list, int element, int index, int numInsertions, String listType) {
        long startTime = System.nanoTime();
        for (int i = 0; i < numInsertions; i++) {
            list.add(index, element);
        }
        long endTime = System.nanoTime();
        long duration = endTime - startTime;
        System.out.printf("Insert in the middle of %s: %d ns%n", listType, duration);
    }
}
