package WordList;

public class WordList {

	private String[] words;
	private int count;
	
	public WordList() {
		words = new String[2];
		for(int i = 0; i < words.length; i++) {
			words[i] = "";
		}
		count = 0;
	}
	
	public int addWord(String w) {
		if(findWord(w) == -1) {
			
			boolean hasSpace = false;
			int i = 0;
			for(String s: words) {
				if(s==null || s.equals("")) {
					hasSpace = true;
					break;
				}
				i++;
			}
			
			if(hasSpace) {
				words[i] = w;
				count++;
			}
			
			else {
				String[] newArr = new String[words.length * 2];
				
				for(int k = 0; k < newArr.length; k++) {
					newArr[k] = "";
				}
				
				int j = 0;
				for(String x: words) {
					newArr[j] = x;
					
					j++;
				}
				
				words = newArr;
				
				addWord(w);
				
			}
			
			
			
			
		}
			
			
			
		return count;
	}
	
	public void removeWord(String w) {
		int x = findWord(w);
		
		if(x!=-1) {
			
			for(int i = x; i < words.length; i++) {
				if(i==words.length-1) {
//					words[i] = null;
				}
				
				else {
					words[i] = words[i+1];
				}
				
				
			}
			
		}
		
		count--;
//		System.out.print("hi");
	}
	
	
	
	
	public int findWord(String thing) {
		int i = 0;
		for(String s: words) {
			if(thing.equals(s)) {
				return i;
			}
			i++;
		}
		
		i=-1;
		return i;
	}
	
	
	 public boolean equals(WordList other) {
		    if (this.count != other.count) {
		    	System.out.print("hi");
		      return false;
		    } else {
		      for (int i = 0; i < this.count; i++) {
		        if (words[i] != other.words[i]) {
		        	
		          return false;
		        }
		      }
		    }
		    return true;
		  }


	  public String toString() {
	    String s = "There are " + count + " word" + ((words.length == 1)?"":"s") + " in the word list:\n";
	    for (String w : words) {
	      s = s + w + "\n";
	    }
	    return s;
	  }

	  
	  
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		WordList wl = new WordList();
//	    wl.addWord("Dog");
//	    System.out.print(wl);
//	    wl.addWord("Dog");
//	    System.out.print(wl);
//	    wl.removeWord("Dog");
//	    wl.addWord("Cat");
//	    wl.addWord("Fish");
//	    wl.addWord("Horse");
//	    System.out.print(wl);
//	    
//	    if (wl.findWord("Cat") >= 0)
//	      System.out.println("Cat is in the word list");
//	    if (wl.findWord("Dog") >= 0)
//	      System.out.println("Dog is in the word list");
//	    
//	    
//	    WordList myList = new WordList();
//	    myList.addWord("Cat");
//	    myList.addWord("Fish");
//	    myList.addWord("Horse");
//	    
//	    System.out.println(myList);
//	    if (wl.equals(myList))
//	      System.out.println("The two lists are the same");
	    
//	    
//		WordList w1 = new WordList();
//		w1.addWord("computer");
//		w1.addWord("abacus");
//		w1.addWord("computer");
//		w1.removeWord("computer");
//		
//		System.out.print(w1);
//		
//		WordList w2 = new WordList();
//		w2.addWord("abacus");
//		w1.equals(w2);
//		
//		w1.addWord("dog");
//		w1.addWord("cat");
//		w1.removeWord("abacus");
	}

}
