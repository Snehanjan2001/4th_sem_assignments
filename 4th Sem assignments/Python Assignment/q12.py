# Enumerate the sequence of all lowercase ASCII letters, starting from 1, using enumerate

for i, c in enumerate(range(ord('a'), ord('z') + 1)):
    print(i + 1, chr(c))


