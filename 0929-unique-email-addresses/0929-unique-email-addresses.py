class Solution:
    def numUniqueEmails(self, emails: List[str]) -> int:
        email_set = set()
        
        for email in emails:
            split = email.split('@')
            left_side = ""
            for c in split[0]:
                if c == '.':
                    continue
                elif c == '+':
                    break
                else:
                    left_side += c
            email_set.add(left_side + '@' + split[1])
        
        return len(email_set)