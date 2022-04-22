import re

###prbolem


def isValid(s):
    # Begins with 0 or 91 or +91 or 0091 & contains 10 digits
    Pattern = re.compile("^(0)?(+91)?(0091)?(91)?[1-9]\d{9}$")
    return Pattern.match(s)


s = input("Enter mobile number: ")
if isValid(s):
    print("Valid Number")
else:
    print("Invalid Number")
