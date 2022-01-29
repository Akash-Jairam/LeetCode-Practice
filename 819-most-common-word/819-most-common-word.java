class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        paragraph = paragraph.replaceAll("\\W", " ");
        String[] array = paragraph.split(" ");
        String mostCommonWord = "";
        int maxWordCount = -1;
        Map<String, Integer> paragraphWords = new HashMap<>();
        Set bannedWords = new HashSet();
        
        for(String bannedWord : banned){
            bannedWords.add(bannedWord);
        }
        for(String word : array){
            if(word.isEmpty())
                continue;
            String lcWord = word.toLowerCase();
            if(!bannedWords.contains(lcWord)){
                if(paragraphWords.containsKey(lcWord)){
                    paragraphWords.put(lcWord, paragraphWords.get(lcWord) + 1);
                } else{
                    paragraphWords.put(lcWord, 1);
                }
                if(paragraphWords.get(lcWord) > maxWordCount){
                    maxWordCount = paragraphWords.get(lcWord);
                    mostCommonWord = lcWord;
                }
            }
        }
        
        
        return mostCommonWord;
    }
}