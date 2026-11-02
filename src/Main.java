public class Main {

    public static void main(String[] args) {

        MiListaDoble numbers = new MiListaDoble();

        numbers.add(8);
        numbers.add(3);
        numbers.add(12);
        numbers.add(5);
        numbers.insertHead(1);
        numbers.insertTail(9);

        System.out.println("Original list:");
        printList(numbers);

        System.out.println("Size: " + numbers.getSize());
        System.out.println("Head: " + numbers.getHead());
        System.out.println("Tail: " + numbers.getTail());
        System.out.println("Contains 12: " + numbers.contains(12));

        MiListaDoble sortedNumbers = numbers.sortList();

        System.out.println("\nSorted list:");
        printList(sortedNumbers);
    }

    public static void printList(MiListaDoble list) {

        Object[] elements = list.toArray();

        for (int i = 0; i < elements.length; i++) {
            System.out.print(elements[i] + " ");
        }

        System.out.println();
    }
}