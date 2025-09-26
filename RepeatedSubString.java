
import java.util.*;

public class RepeatedSubString {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Input the String : ");
        String input = sc.nextLine().toLowerCase();
        int i, j;
        int count = 0;
        // Count distinct characters
        for (i = 0; i < input.length(); i++) {
            for (j = 0; j < i; j++) {
                if (input.charAt(i) == input.charAt(j)) {
                    break;
                }
            }
            if (j == i) {
                count++;
            }
        }
        System.out.println("\nRepeated Substring : " + count);
        Set<Character> distinctSet = new HashSet<>();
        for (char c : input.toCharArray()) {
            distinctSet.add(c);
        }
        // the distinct characters in the string
        List<Character> charList = new ArrayList<>(distinctSet);
        Collections.sort(charList);
        System.out.println("\nAll characters present in the string: " + charList);

        // the shortest substring that contains all letters
        StringBuilder sb = new StringBuilder();
        for (char c : charList) {
            sb.append(c);
        }

        String result = sb.toString();
        System.out.print("The shortest substring that contains all letters : \"" + result + "\"");
    }
}
