import java.util.Comparator;
import java.util.List;

public class SortUtil{

    /**
     * orders words in a list based on their weight with (A=1, Z=26)
     * 
     * @param A list of unordered words
     * @return A list of ordered words
     */
    public static List<String> functionalSort(List<String> list) {
        list.sort((str1, str2) -> {
            int sum1 = str1.toUpperCase() 
                            .chars()
                            .map(c -> {
                                if (!Character.isLetter(c)) {
                                    throw new IllegalArgumentException("Invalid character: " + (char) c + " is not a letter");
                                }
                                return c - 'A' + 1;
                                })
                            .sum();

            int sum2 = str2.toUpperCase()
                            .chars()
                            .map(c -> {
                                if (!Character.isLetter(c)) {
                                    throw new IllegalArgumentException("Invalid character: " + (char) c + " is not a letter");
                                }
                                return c - 'A' + 1;
                            })
                            .sum();

            return Integer.compare(sum1, sum2);
        });
        return list;
    }

    /**
     * orders words in a list based on their weight with (A=1, Z=26)
     * 
     * @param list the unordered list which will be ordered
     * @return A list of ordered words
     */
    public static List<String> oopSort (List<String> list){
        list.sort(new StringComparator());
        return list;
    }

    static class StringComparator implements Comparator<String> {
        /**
         * compares the sum of 2 words
         * 
         * @param str1 the first string which is to be compared to string 2
         * @param str2 the second string which is compared with string 1
         * @return returns a value to determine if str1 is greater less than or equal to string 2
         */
        @Override
        public int compare(String str1, String str2){
            int sum1 = getSum(str1);
            int sum2 = getSum(str2);
            
            return Integer.compare(sum1, sum2);
        }

        /**
         * gets the sum of a word using (A=1, Z=26)
         * @param str the string which will be used to calculate the total sum
         * @return returns the sum of the total word
         */
        private int getSum(String str) {
            int sum = 0;
            for (int i = 0; i < str.length(); i++){
                char c = str.charAt(i);

                if(!Character.isAlphabetic(c)){
                    throw new IllegalArgumentException("Invalid character:" + c + "is not a letter");      
                }

                sum += (int) Character.toUpperCase(c) - 'A' + 1;
            }
            return sum;
        }

    }
}