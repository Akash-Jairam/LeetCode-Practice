class Solution {
    public String reverseWords(String s) {
        if(s.length() == 1)
            return s;
        
        char[] array = s.toCharArray();
        String reversed = "";
        
        
        int start = 0;
        
        int index = s.indexOf(" ");
        
        ArrayList<Integer> list = new ArrayList<Integer>();
        ArrayList<String> stringlist = new ArrayList<String>();
        
        if(index == -1){
            stringlist.add(s);
        } else{
            while(index != -1){
                list.add(index);
                index = s.indexOf(" ", index+1);
            }

            for(int iter = 0; iter < list.size(); iter++){
                int num = list.get(iter);
                stringlist.add(s.substring(start, num));
                start = num+1;
            }

            stringlist.add(s.substring(start));
        }
        
        for(String word: stringlist){
            int j = word.length()-1;
            while(j >= 0){
                reversed += word.charAt(j);
                j--;
            }
            reversed += " ";
        }
        
        if(reversed.lastIndexOf(" ") == reversed.length()-1){
            reversed = reversed.substring(0, reversed.length()-1);
        }
        
        return reversed;
    }
}