class Solution:
    def toHex(self, num: int) -> str:
        ourNum = num if num >= 0 else (1 << 32) + num
        # Implicitly cast negative numbers.
        # -1 turns to the maximum number representable
        # as an unsigned int.

        ourArray = "0123456789abcdef"  # We will pick from this set of characters
        str_list = []

        # While our number exists, convert it into base 16.
        # We are going from left to right, so we need to reverse our result
        # when we return it.
        while ourNum:
            str_list.append(ourArray[ourNum % 16])
            ourNum //= 16

        if not str_list:
            return "0"  # If num is 0, return "0".

        return ''.join(str_list[::-1])
