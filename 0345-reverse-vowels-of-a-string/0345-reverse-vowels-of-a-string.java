class Solution {
    boolean isVowel(char ch)
    {
        ch = Character.toLowerCase(ch); //lower all the characters to reduce checking for upppercase vowels
        if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') return true;
        return false;
    }
    void swap(StringBuilder s, int i, int j)
    {
        char ch1 = s.charAt(i), ch2 = s.charAt(j);
        s.setCharAt(i, ch2);
        s.setCharAt(j, ch1);
    }
    public String reverseVowels(String s) 
    {
        StringBuilder str = new StringBuilder(s);
        int i = 0, j = str.length() - 1;
        while(i <= j)
        {
            char ch1 = str.charAt(i), ch2 = str.charAt(j);
            if (isVowel(ch1) && isVowel(ch2)) //consider swapping only when both s[i] and s[j] are vowels
            {
                swap(str, i, j);
                i++; j--; //move i to right, j to left as we have swapped  
                continue;
            }
            
            if (!isVowel(ch1)) i++; //if s[i] is not a vowel keep traversing to right in search of a vowel
            if (!isVowel(ch2)) j--; //if s[j] is not a vowel keep traversing to left in search of vowel
        }
        return str.toString();
    }
}