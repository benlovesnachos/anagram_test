import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;

public class Solution
{

    private static List<Character> makeListOfCharacters(String baseString){
      // The conversion from a string to a List<Character> required the for
      // loop.  Attempts were made to make this a simple one-liner to no avail.
      List<Character> charList = new ArrayList<>();
      for (char s :baseString.toCharArray()){
        charList.add(s);
      }
      return charList;
    }

    private static boolean isAnagram(String first, String second)
    {
      if (first.length() != second.length()){
        return false;
      }

      var firstCharArray = makeListOfCharacters(first);
      var secondCharArray = makeListOfCharacters(second);

      for(int i = 0; i < firstCharArray.size(); i++){
        var firstChar = firstCharArray.get(i);
        for(int j = 0; j < secondCharArray.size(); j++) {
          var secondChar = secondCharArray.get(j);
          if(firstChar == secondChar) {
            secondCharArray.remove(j);
            break;
          }
        }
      }

      if(secondCharArray.isEmpty()){
        return true;
      }

      return false;
    }

    private static class TestData
    {
        String first;
        String second;
        boolean result;

        TestData(String first, String second, boolean result)
        {
            this.first = first;
            this.second = second;
            this.result = result;
        }
    }

    private static final List<TestData> testCases = Arrays.asList(
            new TestData("abc", "abc", true),
            new TestData("abc", "ba", false),
            new TestData("abc", "bac", true),
            new TestData("abc", "dba", false),
            new TestData("aab", "baa", true),
            new TestData("abb", "baa", false),
            new TestData("ABC", "bac", false),
            new TestData("ABC", "ABCABC", false),
            new TestData("Aa", "Zz", false),
            new TestData("AbC", "bAC", true)
    );

    public static void main(String[] args)
    {
        for (TestData testCase: testCases) {
            boolean result = isAnagram(testCase.first, testCase.second);
            Assert.assertEquals(testCase.result, result);
        }
        System.out.println("Success!");
    }
}