import java.util.Arrays;
import java.util.List;

public class Main{
        /**
         * The starting point of the program, which calls the methods
         *  and initializes the right components to run the project.
         * @param args command line argument
         */
        public static void main(String[] args) {
                List<String> inputList1 = Arrays.asList("Elephant", "Horizon", "Lantern", "Serendipity", "Cascade");
                List<String> inputList2 = Arrays.asList("shoes", "ELEPHant", "Shirt", "GoGGles");
                System.out.println(SortUtil.functionalSort(inputList1));
                System.out.println(SortUtil.oopSort(inputList1));
                System.out.println(SortUtil.functionalSort(inputList2));
                System.out.println(SortUtil.oopSort(inputList2));
        }
}