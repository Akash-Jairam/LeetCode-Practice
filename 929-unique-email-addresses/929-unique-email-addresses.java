class Solution {
    public int numUniqueEmails(String[] emails) {
        // Create a hashset
        // Iterate through our emails array
        // Separate the local name from the domain name
        // Remove everything after the first "+" in the local name
        // Use a while loop to remove all the periods from the local name
        // Add the cleaned email to the set
        // Return the size of the hashset
        
        Set<String> uniqueEmails = new HashSet();
        
        for(String email : emails){
            uniqueEmails.add(cleanEmail(email));
        }
        
        return uniqueEmails.isEmpty() ? 0 : uniqueEmails.size();
    }
    
    public String cleanEmail(String email){
        String domainName = email.substring(email.indexOf("@"));
        String localName = email.substring(0, email.indexOf("@"));
        int plusSignIndex = localName.indexOf("+");
        if(plusSignIndex > -1)
            localName = localName.substring(0, plusSignIndex);
        StringBuilder sb = new StringBuilder();
        for(char c : localName.toCharArray()){
            if(c != '.')
                sb.append(c);
        }
        return sb.toString() + domainName;
    }
}