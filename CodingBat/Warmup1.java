package CodingBat;

public class Warmup1 {
  public boolean sleepIn(boolean weekday, boolean vacation) {
    if (!weekday || vacation) {
      return true;
    }

    else {
      return false;
    }

  }

  public boolean monkeyTrouble(boolean aSmile, boolean bSmile) {
    if ((aSmile && bSmile) || (!aSmile && !bSmile)) {
      return true;
    } else {
      return false;
    }
  }

  public int sumDouble(int a, int b) {
    if (a == b) {
      return 2 * (a + b);
    }

    else {
      return a + b;
    }
  }

  public int diff21(int n) {
    if (n > 21) {
      return 2 * (n - 21);
    }

    else {
      return -(n - 21);
    }
  }

  public boolean parrotTrouble(boolean talking, int hour) {
    if (talking && (hour < 7 || hour > 20)) {
      return true;
    } else {
      return false;
    }
  }

  public boolean makes10(int a, int b) {
    if ((a == 10 || b == 10) || (a + b == 10)) {
      return true;
    } else {
      return false;
    }
  }

  public boolean nearHundred(int n) {
    if ((Math.abs(n - 100) <= 10) || (Math.abs(n - 200) <= 10)) {
      return true;
    } else {
      return false;
    }
  }

  public boolean posNeg(int a, int b, boolean negative) {
    if (!negative) {
      if (!(a < 0 && b < 0) && (a < 0 || b < 0)) {
        return true;
      } else {
        return false;
      }
    } else {
      if (a < 0 && b < 0) {
        return true;
      } else {
        return false;
      }
    }
  }

  public String notString(String str) {
    if (str.length() >= 3 && str.substring(0, 3).equals("not")) {
      return str;
    } else {
      return "not " + str;
    }
  }

  public String missingChar(String str, int n) {
    return str.substring(0, n) + str.substring(n + 1);
  }

  public String frontBack(String str) {
    if (str.length() < 2) {
      return str;
    } else {
      return str.substring(str.length() - 1) + str.substring(1, str.length() - 1) + str.substring(0, 1);
    }

  }

  public String front3(String str) {
    String front;

    if (str.length() < 3) {
      front = str;
    }

    else {
      front = str.substring(0, 3);
    }

    return front + front + front;
  }

  public String backAround(String str) {
    String lchar = str.substring(str.length() - 1);
    return lchar + str + lchar;
  }

  public boolean or35(int n) {
    if (n % 3 == 0 || n % 5 == 0) {
      return true;
    } else {
      return false;
    }
  }

  public String front22(String str) {
    String lchar;
    if (str.length() == 0) {
      lchar = str;
    } else if (str.length() == 1) {
      lchar = str.substring(0, 1);
    } else {
      lchar = str.substring(0, 2);
    }

    return lchar + str + lchar;
  }

  public boolean startHi(String str) {
    if (str.length() >= 2 && str.substring(0, 2).equals("hi")) {
      return true;
    } else {
      return false;
    }
  }

  public boolean icyHot(int temp1, int temp2) {
    if (temp1 < 0 && temp2 > 100 || temp1 > 100 && temp2 < 0) {
      return true;
    } else {
      return false;
    }
  }

  public boolean in1020(int a, int b) {
    if (a <= 20 && a >= 10 || b <= 20 && b >= 10) {
      return true;
    } else {
      return false;
    }
  }

  public boolean hasTeen(int a, int b, int c) {
    if (a < 20 && a > 12 || b < 20 && b > 12 || c < 20 && c > 12) {
      return true;
    } else {
      return false;
    }
  }

  public boolean loneTeen(int a, int b) {
    if ((a < 20 && a > 12 || b < 20 && b > 12) && !(a < 20 && a > 12 && b < 20 && b > 12)) {
      return true;
    } else {
      return false;
    }
  }

  public String delDel(String str) {
    if (str.length() >= 4 && str.substring(1, 4).equals("del")) {
      String ending;
      if (str.length() > 4) {
        ending = str.substring(4);
      } else {
        ending = "";
      }
      return str.substring(0, 1) + ending;
    } else {
      return str;
    }
  }

  public boolean mixStart(String str) {
    if (str.length() > 2 && str.substring(1, 3).equals("ix")) {
      return true;
    } else {
      return false;
    }
  }

  public String startOz(String str) {
    String fchar;
    String schar;

    if (str.length() == 0) {
      return "";
    }
    if (str.substring(0, 1).equals("o")) {
      fchar = "o";
    } else {
      fchar = "";
    }

    if (str.length() > 1 && str.substring(1, 2).equals("z")) {
      schar = "z";
    } else {
      schar = "";
    }

    return fchar + schar;
  }

  public int intMax(int a, int b, int c) {
    if (a > b && a > c) {
      return a;
    } else if (b > a && b > c) {
      return b;
    } else {
      return c;
    }
  }

  public int close10(int a, int b) {
    if (Math.abs(10 - a) < Math.abs(10 - b)) {
      return a;
    } else if (Math.abs(10 - a) > Math.abs(10 - b)) {
      return b;
    }
    return 0;
  }

  public boolean in3050(int a, int b) {
    if (a <= 40 && a >= 30 && b <= 40 && b >= 30 || a <= 50 && a >= 40 && b <= 50 && b >= 40) {
      return true;
    }
    return false;
  }

  public int max1020(int a, int b) {
    if (b > a) {
      int c = a;
      a = b;
      b = c;
    }

    if (a >= 10 && a <= 20) {
      return a;
    } else if (b >= 10 && b <= 20) {
      return b;
    }
    return 0;
  }

  public boolean stringE(String str) {
    int count = str.length() - str.replace("e", "").length();
    if (count >= 1 && count <= 3) {
      return true;
    }
    return false;
  }

  public boolean lastDigit(int a, int b) {
    if (a % 10 == b % 10) {
      return true;
    }
    return false;
  }

  public String endUp(String str) {
    if (str.length() >= 3) {
      return str.substring(0, str.length() - 3) + str.substring(str.length() - 3).toUpperCase();
    }
    return str.toUpperCase();
  }

  public String everyNth(String str, int n) {
    String stringthing = "";
    int divisions;
    if (str.length() % 3 == 0) {
      divisions = str.length() / n;
    } else {
      divisions = str.length() / n + 1;
    }

    for (int i = 0; i < divisions; i++) {
      stringthing += str.substring(n * i, n * i + 1);
    }
    return stringthing;
  }

}