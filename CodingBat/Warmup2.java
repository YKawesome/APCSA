package CodingBat;

public class Warmup2 {
  public String stringTimes(String str, int n) {
    String result = "";
    for (int i = 0; i < n; i++) {
      result += str;
    }
    return result;

  }

  public String frontTimes(String str, int n) {
    String result = "";
    int k = str.length() < 3 ? str.length() : 3;
    for (int i = 0; i < n; i++) {
      result += str.substring(0, k);
    }
    return result;
  }

  int countXX(String str) {
    int sum = 0;
    for (int i = 0; i < str.length() - 1; i++) {
      if (str.substring(i, i + 2).equals("xx"))
        sum++;
    }
    return sum;
  }

  boolean doubleX(String str) {
    for (int i = 0; i < str.length() - 1; i++) {
      if (str.charAt(i) == 'x') {
        if (str.charAt(i + 1) == 'x')
          return true;
        else
          return false;
      }
    }
    return false;
  }

  public String stringBits(String str) {
    String result = "";
    for (int i = 0; i < str.length(); i += 2) {
      result += str.charAt(i);
    }
    return result;
  }

  public String stringSplosion(String str) {
    String result = "";
    for (int i = 0; i < str.length() + 1; i++) {
      result += str.substring(0, i);
    }
    return result;
  }

  public int last2(String str) {
    if (str.length() < 2)
      return 0;
    String last = str.substring(str.length() - 2);
    str = str.substring(0, str.length() - 1);
    int sum = 0;
    for (int i = 0; i < str.length() - 1; i++) {
      if (str.substring(i, i + 2).equals(last))
        sum++;
    }
    return sum;
  }

  public int arrayCount9(int[] nums) {
    int sum = 0;
    for (int n : nums)
      if (n == 9)
        sum++;
    return sum;
  }

  public boolean arrayFront9(int[] nums) {
    int high = nums.length < 4 ? nums.length : 4;
    for (int i = 0; i < high; i++)
      if (nums[i] == 9)
        return true;
    return false;
  }

  public boolean array123(int[] nums) {
    for (int i = 0; i < nums.length - 2; i++) {
      if (nums[i] == 1 && nums[i + 1] == 2 && nums[i + 2] == 3)
        return true;
    }
    return false;
  }

  public int stringMatch(String a, String b) {
    int length = a.length() > b.length() ? b.length() : a.length();
    int count = 0;
    for (int i = 0; i < length - 1; i++)
      if (a.substring(i, i + 2).equals(b.substring(i, i + 2)))
        count++;
    return count;
  }

  public String stringX(String str) {
    String ret = "";
    for (int i = 0; i < str.length(); i++) {
      if (i == 0 || i == str.length() - 1)
        ret += str.charAt(i);
      else if (str.charAt(i) == 'x')
        continue;
      else
        ret += str.charAt(i);
    }
    return ret;

  }

  public String altPairs(String str) {
    String ret = "";
    for (int i = 0; i < str.length(); i = i) {
      ret += str.charAt(i);

      if (i % 4 == 0)
        i++;
      else
        i += 3;
    }
    return ret;
  }

  public String stringYak(String str) {
    String ret = "";
    for (int i = 0; i < str.length(); i++) {
      if (i < str.length() - 2 && str.substring(i, i + 3).equals("yak"))
        i += 2;
      else
        ret += str.charAt(i);
    }
    return ret;
  }

  public int array667(int[] nums) {
    int count = 0;
    for (int i = 0; i < nums.length - 1; i++) {
      if (nums[i] == 6 && (nums[i + 1] == 6 || nums[i + 1] == 7))
        count++;
    }
    return count;
  }

  public boolean noTriples(int[] nums) {
    boolean ret = true;
    for (int i = 0; i < nums.length - 2; i++) {
      if (nums[i] == nums[i + 1] && nums[i + 1] == nums[i + 2])
        ret = false;
    }
    return ret;
  }

  public boolean has271(int[] nums) {
    for (int i = 0; i < nums.length - 2; i++) {
      if (nums[i] == nums[i + 1] - 5 && Math.abs(nums[i + 2] - (nums[i] - 1)) <= 2)
        return true;
    }
    return false;
  }

}