package CodingBat;

public class String1 {
  public String helloName(String name) {
    return "Hello " + name + "!";
  }

  public String makeAbba(String a, String b) {
    return String.format("%s%s%s%s", a, b, b, a);
  }

  public String makeTags(String tag, String word) {
    return String.format("<%s>%s</%s>", tag, word, tag);
  }

  public String makeOutWord(String out, String word) {
    return out.substring(0, 2) + word + out.substring(2, 4);
  }

  public String extraEnd(String str) {
    return str.substring(str.length() - 2) + str.substring(str.length() - 2) + str.substring(str.length() - 2);
  }

  public String firstTwo(String str) {
    if (str.length() < 2)
      return str;
    return str.substring(0, 2);
  }

  public String firstHalf(String str) {
    return str.substring(0, str.length() / 2);
  }

  public String withoutEnd(String str) {
    return str.substring(1, str.length() - 1);
  }

  public String comboString(String a, String b) {
    String shor = a.length() < b.length() ? a : b;
    String lon = a.length() < b.length() ? b : a;
    return String.format("%s%s%s", shor, lon, shor);
  }

  public String nonStart(String a, String b) {
    return a.substring(1) + b.substring(1);
  }

  public String left2(String str) {
    if (str.length() == 2)
      return str;
    return str.substring(2) + str.substring(0, 2);
  }

  public String right2(String str) {
    if (str.length() == 2)
      return str;
    return str.substring(str.length() - 2) + str.substring(0, str.length() - 2);

  }

  public String theEnd(String str, boolean front) {
    return front ? str.substring(0, 1) : str.substring(str.length() - 1);
  }

  public String withouEnd2(String str) {
    if (str.length() < 2)
      return "";
    return str.substring(1, str.length() - 1);
  }

  public String middleTwo(String str) {
    return str.substring(str.length() / 2 - 1, str.length() / 2 + 1);
  }

  public boolean endsLy(String str) {
    if (str.length() < 2)
      return false;
    return str.substring(str.length() - 2).equals("ly");
  }

  public String nTwice(String str, int n) {
    return str.substring(0, n) + str.substring(str.length() - n);
  }

  public String twoChar(String str, int index) {
    if (index >= str.length() - 1 || index < 0)
      return str.substring(0, 2);
    return str.substring(index, index + 2);
  }

  public String middleThree(String str) {
    return str.substring(str.length() / 2 - 1, str.length() / 2 + 2);
  }

  public boolean hasBad(String str) {
    return str.length() > 2 && str.substring(0, 3).equals("bad")
        || str.length() > 3 && str.substring(1, 4).equals("bad");
  }

  public String atFirst(String str) {
    if (str.length() > 1)
      return str.substring(0, 2);
    else if (str.length() > 0)
      return str.substring(0, 1) + "@";
    else
      return "@@";
  }

  public String lastChars(String a, String b) {
    if (a.length() == 0)
      a = "@";
    if (b.length() == 0)
      b = "@";
    return a.substring(0, 1) + b.substring(b.length() - 1);
  }

  public String conCat(String a, String b) {
    if (a.length() == 0 || b.length() == 0)
      return a + b;
    if (a.charAt(a.length() - 1) == b.charAt(0))
      b = b.substring(1);
    return a + b;
  }

  public String lastTwo(String str) {
    if (str.length() < 2)
      return str;
    return str.substring(0, str.length() - 2) + str.charAt(str.length() - 1) + str.charAt(str.length() - 2);
  }

  public String seeColor(String str) {
    if (str.length() > 2 && str.substring(0, 3).equals("red"))
      return "red";
    else if (str.length() > 3 && str.substring(0, 4).equals("blue"))
      return "blue";
    return "";
  }

  public boolean frontAgain(String str) {
    if (str.length() < 2)
      return false;
    return str.substring(0, 2).equals(str.substring(str.length() - 2));
  }

  public String minCat(String a, String b) {
    if (a.length() > b.length())
      a = a.substring(a.length() - b.length());
    else
      b = b.substring(b.length() - a.length());
    return a + b;
  }

  public String extraFront(String str) {
    String result = "";
    for (int i = 0; i < 3; i++) {
      if (str.length() < 2)
        result += str;
      else
        result += str.substring(0, 2);
    }
    return result;
  }

  public String without2(String str) {
    if (str.length() < 2)
      return str;
    if (str.substring(0, 2).equals(str.substring(str.length() - 2)))
      return str.substring(2);
    return str;
  }

  public String deFront(String str) {
    String a = str.charAt(0) == 'a' ? "a" : "";
    String b = str.charAt(1) == 'b' ? "b" : "";
    return a + b + str.substring(2);
  }

  public String startWord(String str, String word) {
    int wordLength = word.length();
    int strLength = str.length();

    if (wordLength > strLength) {
      return "";
    }

    boolean isMatch = true;
    for (int i = 1; i < wordLength; i++) {
      if (str.charAt(i) != word.charAt(i)) {
        isMatch = false;
        break;
      }
    }

    if (isMatch) {
      return str.substring(0, wordLength);
    } else {
      return "";
    }
  }

  public String withoutX(String str) {
    if (str.length() > 0 && str.charAt(0) == 'x')
      str = str.substring(1);
    if (str.length() > 0 && str.charAt(str.length() - 1) == 'x')
      str = str.substring(0, str.length() - 1);
    return str;
  }

  public String withoutX2(String str) {
    String result = "";
    int i = 0;
    for (char c : str.toCharArray()) {
      if (i < 2 && c == 'x') {
        i++;
        continue;
      }
      result += c;
      i++;
    }
    return result;
  }

}