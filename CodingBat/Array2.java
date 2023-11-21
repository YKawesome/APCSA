package CodingBat;

import java.util.ArrayList;

public class Array2 {
  public int countEvens(int[] nums) {
    int count = 0;
    for (int i = 0; i < nums.length; i++) {
      count += nums[i] % 2 == 0 ? 1 : 0;
    }
    return count;
  }

  public int bigDiff(int[] nums) {
    int min = 0;
    int max = 0;

    for (int n : nums) {
      if (min == 0 && max == 0) {
        min = n;
        max = n;
      }

      if (n < min)
        min = n;
      else if (n > max)
        max = n;
    }

    return max - min;
  }

  public int centeredAverage(int[] nums) {
    int max = 0;
    int min = 1000;
    int sum = 0;
    for (int i : nums) {
      if (i > max)
        max = i;
      if (i < min)
        min = i;

      sum += i;
    }

    sum -= min;
    sum -= max;

    return sum / (nums.length - 2);

    // return sum;

  }

  public int sum13(int[] nums) {
    int sum = 0;
    int j = 0;
    boolean found13 = false;
    for (int i : nums) {
      if (i == 13)
        found13 = true;
      if (j == 2) {
        found13 = false;
        j = 0;
      }
      if (found13) {
        i = 0;
        j++;
      }

      if (i == 13)
        i = 0;
      sum += i;

    }
    return sum;
  }

  public int sum67(int[] nums) {
    int sum = 0;

    boolean disabled = false;

    for (int i = 0; i < nums.length; i++) {
      if (!disabled && nums[i] == 6)
        disabled = true;

      if (!disabled)
        sum += nums[i];

      if (disabled && nums[i] == 7)
        disabled = false;
    }

    return sum;
  }

  public boolean has22(int[] nums) {
    for (int i = 0; i < nums.length - 1; i++) {
      if (nums[i] == 2 && nums[i + 1] == 2)
        return true;
    }
    return false;
  }

  public boolean lucky13(int[] nums) {
    for (int n : nums) {
      if (n == 1 || n == 3)
        return false;
    }
    return true;
  }

  public boolean sum28(int[] nums) {
    int sum = 0;
    for (int n : nums) {
      if (n == 2)
        sum += n;
    }
    return sum == 8;
  }

  public boolean more14(int[] nums) {
    int numOnes = 0;
    int numFours = 0;

    for (int n : nums) {
      if (n == 1)
        numOnes++;
      if (n == 4)
        numFours++;
    }

    return numOnes > numFours;
  }

  public int[] fizzArray(int n) {
    int[] result = new int[n];

    for (int i = 0; i < result.length; i++) {
      result[i] = i;
    }

    return result;
  }

  public boolean only14(int[] nums) {
    for (int n : nums) {
      if (!(n == 1 || n == 4))
        return false;
    }
    return true;
  }

  public String[] fizzArray2(int n) {
    String[] result = new String[n];

    for (int i = 0; i < result.length; i++) {
      result[i] = "" + i;
    }

    return result;
  }

  public boolean no14(int[] nums) {
    boolean noOnes = true;
    boolean noFours = true;

    for (int n : nums) {
      if (n == 1)
        noOnes = false;
    }

    for (int n : nums) {
      if (n == 4)
        noFours = false;
    }

    return noOnes || noFours;
  }

  public boolean isEverywhere(int[] nums, int val) {
    for (int i = 0; i < nums.length - 1; i++) {
      if (!(nums[i] == val || nums[i + 1] == val))
        return false;
    }
    return true;
  }

  public boolean either24(int[] nums) {
    boolean twoTwos = false;
    boolean twoFours = false;

    for (int i = 0; i < nums.length - 1; i++) {
      if (nums[i] == 2 && nums[i + 1] == 2)
        twoTwos = true;
      if (nums[i] == 4 && nums[i + 1] == 4)
        twoFours = true;
    }

    return twoTwos ^ twoFours;
  }

  public int matchUp(int[] nums1, int[] nums2) {
    int count = 0;
    for (int i = 0; i < nums1.length; i++) {
      if (Math.abs(nums1[i] - nums2[i]) > 0 && Math.abs(nums1[i] - nums2[i]) <= 2)
        count++;
    }
    return count;
  }

  public boolean has77(int[] nums) {
    for (int i = 0; i < nums.length - 1; i++) {
      if (nums[i] == 7 && (nums[i] == nums[i + 1] || (i != nums.length - 2 && nums[i] == nums[i + 2])))
        return true;
    }
    return false;
  }

  public boolean has12(int[] nums) {
    boolean foundOne = false;

    for (int n : nums) {
      if (n == 1)
        foundOne = true;
      if (foundOne && n == 2)
        return true;
    }

    return false;
  }

  public boolean modThree(int[] nums) {
    for (int i = 0; i < nums.length - 2; i++) {
      if (nums[i] % 2 == 1 && nums[i + 1] % 2 == 1 && nums[i + 2] % 2 == 1
          || nums[i] % 2 == 0 && nums[i + 1] % 2 == 0 && nums[i + 2] % 2 == 0)
        return true;
    }
    return false;
  }

  public boolean haveThree(int[] nums) {
    int count = 0;

    for (int n : nums)
      if (n == 3)
        count++;

    for (int i = 0; i < nums.length - 1; i++) {
      if (nums[i] == 3 && nums[i + 1] == 3)
        return false;
    }

    return count == 3;
  }

  public boolean twoTwo(int[] nums) {
    for (int i = 0; i < nums.length - 1; i++) {
      if (nums[i] == 2 && nums[i + 1] != 2) {
        return false;
      } else if (nums[i] == 2 && nums[i + 1] == 2) {
        i++;
      }
    }

    if (nums.length >= 2 && nums[nums.length - 1] == 2 && nums[nums.length - 2] != 2)
      return false;
    if (nums.length == 1 && nums[0] == 2)
      return false;
    return true;
  }

  public boolean sameEnds(int[] nums, int len) {
    for (int i = 0; i < len; i++) {
      if (nums[i] != nums[nums.length - len + i])
        return false;
    }
    return true;
  }

  public boolean tripleUp(int[] nums) {
    for (int i = 0; i < nums.length - 2; i++) {
      if (nums[i] == nums[i + 1] - 1 && nums[i + 1] == nums[i + 2] - 1)
        return true;
    }
    return false;
  }

  public int[] fizzArray3(int start, int end) {
    int[] result = new int[end - start];
    for (int i = start; i < end; i++)
      result[i - start] = i;

    return result;
  }

  public int[] shiftLeft(int[] nums) {
    if (nums.length == 0)
      return nums;
    int temp = nums[0];

    for (int i = 0; i < nums.length - 1; i++) {
      nums[i] = nums[i + 1];
    }
    nums[nums.length - 1] = temp;
    return nums;
  }

  public int[] tenRun(int[] nums) {
    int curr = -1;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] % 10 == 0)
        curr = nums[i];
      else if (curr != -1)
        nums[i] = curr;
    }

    return nums;
  }

  public int[] pre4(int[] nums) {
    int index = nums.length;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] == 4) {
        index = i;
        break;
      }
    }

    int[] result = new int[index];
    for (int i = 0; i < result.length; i++) {
      result[i] = nums[i];
    }

    return result;
  }

  public int[] post4(int[] nums) {

    int index = 0;

    for (int i = nums.length - 1; i >= 0; i--) {
      if (nums[i] == 4) {
        index = i;
        break;
      }
    }

    int[] result = new int[nums.length - index];
    for (int i = index + 1; i < nums.length; i++) {
      result[i - index] = nums[i];
    }

    int[] finResult = new int[result.length - 1];

    for (int i = 0; i < result.length; i++) {
      if (i == 0)
        continue;
      else
        finResult[i - 1] = result[i];
    }

    return finResult;
  }

  public int[] notAlone(int[] nums, int val) {

    for (int i = 1; i < nums.length - 1; i++) {
      if (nums[i - 1] != nums[i] && nums[i] != nums[i + 1] && nums[i] == val) {
        nums[i] = nums[i + 1] > nums[i - 1] ? nums[i + 1] : nums[i - 1];
      }
    }

    return nums;
  }

  public int[] zeroFront(int[] nums) {
    ArrayList<Integer> nonzeroes = new ArrayList<Integer>();
    ArrayList<Integer> zeroes = new ArrayList<Integer>();

    for (int n : nums) {
      if (n == 0)
        zeroes.add(n);
      else
        nonzeroes.add(n);
    }

    for (int i = 0; i < nums.length; i++) {
      nums[i] = i < zeroes.size() ? zeroes.get(i) : nonzeroes.get(i - zeroes.size());
    }

    return nums;
  }

  public int[] withoutTen(int[] nums) {
    int[] result = new int[nums.length];
    int index = 0;

    for (int i = 0; i < nums.length; i++) {
      if (nums[i] != 10) {
        result[index] = nums[i];
        index++;
      }
    }

    return result;
  }

  public int[] zeroMax(int[] nums) {
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] == 0) {
        int odd = 0;
        for (int j = i + 1; j < nums.length; j++) {
          if (nums[j] % 2 == 1 && nums[j] > odd)
            odd = nums[j];
        }
        nums[i] = odd;
      }
    }
    return nums;
  }

  public int[] evenOdd(int[] nums) {
    ArrayList<Integer> odds = new ArrayList<Integer>();
    ArrayList<Integer> evens = new ArrayList<Integer>();

    for (int n : nums) {
      if (n % 2 == 0)
        evens.add(n);
      else
        odds.add(n);
    }

    for (int i = 0; i < nums.length; i++) {
      nums[i] = i < evens.size() ? evens.get(i) : odds.get(i - evens.size());
    }

    return nums;
  }

  public String[] fizzBuzz(int start, int end) {
    String[] result = new String[end - start];
    for (int i = start; i < end; i++) {
      result[i - start] = i % 15 == 0 ? "FizzBuzz" : i % 3 == 0 ? "Fizz" : i % 5 == 0 ? "Buzz" : String.valueOf(i);
    }
    return result;
  }

}