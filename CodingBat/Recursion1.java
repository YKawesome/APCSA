package CodingBat;

public class Recursion1 {

  public int factorial(int n) {
    if (n == 1) {
      return 1;
    } else {
      return n * factorial(n - 1);
    }
  }

  public int bunnyEars(int bunnies) {
    if (bunnies == 0) {
      return 0;
    } else {
      return 2 + bunnyEars(bunnies - 1);
    }
  }

  public int fibonacci(int n) {
    if (n == 0) {
      return 0;
    } else if (n == 1) {
      return 1;
    } else {
      return fibonacci(n - 1) + fibonacci(n - 2);
    }
  }

  public int bunnyEars2(int bunnies) {
    if (bunnies == 0) {
      return 0;
    } else if (bunnies % 2 == 1) {
      return 2 + bunnyEars2(bunnies - 1);
    } else {
      return 3 + bunnyEars2(bunnies - 1);
    }
  }

  public int triangle(int rows) {
    if (rows == 0) {
      return 0;
    } else {
      return rows + triangle(rows - 1);
    }
  }

  public int sumDigits(int n) {
    if (n == 0) {
      return 0;
    } else {
      return n % 10 + sumDigits(n / 10);
    }
  }

  public int count7(int n) {
    if (n == 0) {
      return 0;
    } else if (n % 10 == 7) {
      return 1 + count7(n / 10);
    } else {
      return count7(n / 10);
    }
  }

  public int count8(int n) {
    if (n == 0) {
      return 0;
    } else if (n % 10 == 8) {
      if ((n / 10) % 10 == 8) {
        return 2 + count8(n / 10);
      } else {
        return 1 + count8(n / 10);
      }
    } else {
      return count8(n / 10);
    }
  }

  public int powerN(int base, int n) {
    if (n == 0) {
      return 1;
    } else {
      return base * powerN(base, n - 1);
    }
  }

  public int countX(String str) {
    if (str.length() == 0) {
      return 0;
    }

    if (str.substring(0, 1).equals("x")) {
      return 1 + countX(str.substring(1));
    }

    return countX(str.substring(1));
  }

  public int countHi(String str) {
    if (str.length() < 2) {
      return 0;
    }

    if (str.substring(0, 2).equals("hi")) {
      return 1 + countHi(str.substring(2));
    }

    return countHi(str.substring(1));
  }

  public String changeXY(String str) {
    if (str.length() == 0)
      return "";
    else {
      if (str.substring(str.length() - 1).equals("x"))
        return changeXY(str.substring(0, str.length() - 1)) + "y";
      else
        return changeXY(str.substring(0, str.length() - 1)) + str.substring(str.length() - 1);
    }
  }

  public String changePi(String str) {
    if (str.length() <= 1)
      return str;
    else {
      if (str.substring(str.length() - 2).equals("pi"))
        return changePi(str.substring(0, str.length() - 2)) + "3.14";
      else
        return changePi(str.substring(0, str.length() - 1)) + str.substring(str.length() - 1);
    }
  }

  public String noX(String str) {
    if (str.length() == 0)
      return str;
    else {
      if (str.substring(str.length() - 1).equals("x"))
        return noX(str.substring(0, str.length() - 1));
      else
        return noX(str.substring(0, str.length() - 1)) + str.substring(str.length() - 1);
    }
  }

  public boolean array6(int[] nums, int index) {
    if (nums.length == 0)
      return false;
    if (nums[index] == 6)
      return true;
    else {
      if (index == nums.length - 1)
        return false;
      return array6(nums, index + 1);
    }
  }

  public int array11(int[] nums, int index) {
    if (nums.length == 0 || index == nums.length)
      return 0;
    if (nums[index] == 11)
      return array11(nums, index + 1) + 1;
    else
      return array11(nums, index + 1);

  }

  public boolean array220(int[] nums, int index) {
    if (nums.length == 0 || index == nums.length - 1)
      return false;
    if (nums[index] * 10 == nums[index + 1])
      return true;
    else
      return array220(nums, index + 1);
  }

  public String allStar(String str) {
    if (str.length() <= 1)
      return str;
    else
      return allStar(str.substring(0, str.length() - 1)) + "*" + str.substring(str.length() - 1);
  }

  public String pairStar(String str) {
    if (str.length() <= 1)
      return str;
    else {
      if (str.charAt(0) == str.charAt(1))
        return str.charAt(0) + "*" + pairStar(str.substring(1, str.length()));
      else
        return pairStar(str.substring(0, 1)) + pairStar(str.substring(1, str.length()));
    }
  }

  public String endX(String str) {
    if (str.length() == 0)
      return str;
    else {
      if (str.charAt(0) == 'x')
        return endX(str.substring(1, str.length())) + "x";
      else
        return str.charAt(0) + endX(str.substring(1, str.length()));
    }
  }

  public int countPairs(String str) {
    return str.length() <= 2 ? 0
        : (str.charAt(0) == str.charAt(2) ? 1 : 0) + countPairs(str.substring(1, str.length()));
  }

  public int countAbc(String str) {
    if (str.length() <= 2)
      return 0;
    return ((str.substring(0, 3).equals("abc") || str.substring(0, 3).equals("aba")) ? 1 : 0)
        + countAbc(str.substring(1, str.length()));
  }

  public int count11(String str) {
    if (str.length() <= 1)
      return 0;
    else {
      if (str.substring(0, 2).equals("11"))
        return 1 + count11(str.substring(2, str.length()));
      else
        return count11(str.substring(1, str.length()));

    }

  }

  public String stringClean(String str) {
    if (str.length() <= 1)
      return str;
    else {
      if (str.charAt(0) == str.charAt(1))
        return stringClean(str.substring(1));
      return str.charAt(0) + stringClean(str.substring(1));
    }
  }

  public int countHi2(String str) {
    if (str.length() <= 1)
      return 0;
    else {
      if (str.substring(0, 2).equals("xx"))
        return 0 + countHi2(str.substring(1));
      else if (str.charAt(0) == 'x')
        return 0 + countHi2(str.substring(2));
      else if (str.substring(0, 2).equals("hi"))
        return 1 + countHi2(str.substring(2));
      else
        return countHi2(str.substring(1));
    }
  }

  public String parenBit(String str) {
    if (str.length() <= 1)
      return "";
    else {
      if (str.charAt(0) == '(')
        return str.substring(0, str.indexOf(")") + 1) + parenBit(str.substring(str.indexOf(")")));
      else
        return parenBit(str.substring(1));
    }
  }

  public boolean nestParen(String str) {
    if (str.equals(""))
      return true;
    if (str.length() % 2 == 1)
      return false;
    if (str.charAt(0) == '(' && str.charAt(str.length() - 1) == ')')
      return nestParen(str.substring(1, str.length() - 1));
    else
      return false;
  }

  public int strCount(String str, String sub) {
    if (str.length() < sub.length())
      return 0;
    else {
      if (str.substring(0, sub.length()).equals(sub))
        return 1 + strCount(str.substring(sub.length()), sub);
      else
        return 0 + strCount(str.substring(1), sub);
    }
  }

  public boolean strCopies(String str, String sub, int n) {
    if (n == 0)
      return true;
    else if (str.length() < sub.length())
      return false;
    else {
      if (str.substring(0, sub.length()).equals(sub))
        return strCopies(str.substring(1), sub, n - 1);
      else
        return strCopies(str.substring(1), sub, n);
    }
  }

  public int strDist(String str, String sub) {
    if (str.length() < sub.length())
      return 0;
    else {
      if (str.substring(0, sub.length()).equals(sub)) {
        if (str.substring(str.length() - sub.length()).equals(sub))
          return str.length();
        else
          return strDist(str.substring(0, str.length() - 1), sub);
      } else
        return strDist(str.substring(1), sub);
    }
  }

}