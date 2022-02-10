class Solution {
    public int numUniqueEmails(String[] emails) {
        // Create a map
        // Iterate through emails array
        // Parse emails into the address that they will be forwarded to
        // If the parsed email is in the map, we "continue"
        // Else we increment our count and put the parsed emal in the map
        // Return the count
        Set<String> set = new HashSet();
        int count = 0;
        
        for(String email : emails){
            String localName = email.substring(0, email.indexOf('@'));
            int plusIndex = localName.indexOf('+');
            if(plusIndex != -1)
                localName = localName.substring(0, plusIndex);
            char[] localNameArray = localName.toCharArray();
            Arrays.sort(localNameArray);
            localName = new String(localNameArray);
            while(localName.charAt(0) == '.')
                localName = localName.substring(1);
            String cleanedEmail =  localName + "" + email.substring(email.indexOf('@'));
            if(!set.contains(cleanedEmail)){
                count++; 
                set.add(cleanedEmail);
            }
        }
        
        return count;
    }
}