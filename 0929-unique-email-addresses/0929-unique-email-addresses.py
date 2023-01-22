class Solution:
    def numUniqueEmails(self, emails: List[str]) -> int:
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