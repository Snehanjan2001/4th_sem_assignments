# Write an operator overloading for len which shows string length for any given string and return 
# only length of repetitive words with the text if the text has some repetitive parts.
#  Determine the most frequently occurring words using most_common.

class StringDummy:
    def __init__(self, string: str):
        self.string = string

    def __len__(self):
        words = self.string.split()
        return len(words)


print(len(StringDummy("heil Hitler")))
