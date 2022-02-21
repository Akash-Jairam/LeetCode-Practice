class Solution {
    public int numUniqueEmails(String[] emails) {
        // Create a variable to track the count
        // Create a hashset to store our unique emails
        // Iterate through our array and split the current email at the '@'
        // "Clean" the local name by feeding it to a function and receiving the 'cleaned' name
        // Reassemble the email address and check to see if it exists in our set
        // If it does, increment our count
        // Else add it to the set
        // Our function will iterate through the given string and add characters while skipping periods and breaking if we encounter a "+"
        int count = 0;
        HashSet<String> set = new HashSet();
        
        for(String email : emails){
            String[] split = email.split("@");
            String localName = cleanLocal(split[0]);
            String cleanedEmail = localName + "@" + split[1];
            set.add(cleanedEmail);
        }
        
        return set.size();
    }
    
    public String cleanLocal(String email){
        StringBuilder sb = new StringBuilder(email.length());
        
        for(char c : email.toCharArray()){
            if(c == '+')
                break;
            else if(c != '.')
                sb.append(c);
        }
        
        return sb.toString();
    }
}