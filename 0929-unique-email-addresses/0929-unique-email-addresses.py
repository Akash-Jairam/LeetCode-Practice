class Solution:
    def numUniqueEmails(self, emails: List[str]) -> int:
        # Use a set to store emails and keep track of unique ones
        # Iterate through each email by character
        # If the curr char is a + or @ break
        # else if the curr char is not a ., append to the list that is accumulating the locale
        # Append the combination of the locale and the substring of emails from the '@' to the end to the set
        # Return the size of the set at the end
        email_set = set()
        
        for email in emails:
            locale = []
            for c in email:
                if c == '+' or c == '@':
                    break
                elif c != '.':
                   locale.append(c) 
            email_set.add('.'.join(locale) + email[email.find('@'):])
        
        return len(email_set)