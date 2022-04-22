# Search for palindrome and unique words in a text using class method and string method

def is_palindrome(word):
    if word == word[::-1]:
        return True
    else:
        return False


text = 'redivider deified civic radar reviver racecar madam and refer y nefrqwfo erfjkje'

unique_words = []
palindorme_words = []

for word in text.split(" "):
    if word not in unique_words:
        unique_words.append(word)

for word in unique_words:
    if is_palindrome(word):
        palindorme_words.append(word)

print(unique_words)
print(palindorme_words)
