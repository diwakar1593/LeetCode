class Solution {
    public int compress(char[] chars) {
        String s="";
        int c=1;
        int i;
        for (i=0;i<chars.length-1;i++)
        {
            if(chars[i]==chars[i+1]){
                  c++;
            }else{
                if(c>1)s+=chars[i]+""+c;
                else s+=chars[i];
                c=1;
            }
        }
        if(c>1)s+=chars[i]+""+c;
        else s+=chars[i];
        int k=0;
        for(char c1:s.toCharArray())
        {
            chars[k++]=c1;
        }

        return s.length();
       
    }
}