# Write a python program to identify and extract numerical chunks from a text file and convert them into words
# e.g.; 1992  “nineteen hundred and ninety two”.


names = ["","hundred", "thousand", "lac", "crore"]
zero = "zero"
one_to_nine = ["one", "two", "three", "four", "five", "six", "seven", "eight", "nine"]
eleven_to_nineteen = ["eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"]
only_tens = ["ten", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"]


def convert_to_words(number):
    if number == 0:
        return ""
    elif number < 10:
        return one_to_nine[number-1]
    elif number == 10:
        return only_tens[0]
    elif number < 20:
        return eleven_to_nineteen[number-11]
    else:
        tens = int(number/10)
        ones = number%10
        return only_tens[tens-1] + " " + convert_to_words(ones)

    
def numeric_to_text(number:int):
    text = ''
    list_o = []
    list_o.append(number%100)
    number = int(number / 100)
    list_o.append(number%10)
    number = int(number / 10)
    list_o.append(number%100)
    number = int(number / 100)
    list_o.append(number%100)
    number = int(number / 100)
    list_o.append(number)

    for key, value in enumerate(list_o):

        if value != 0:
            if key <=3:
                tmp = convert_to_words(value)+" "+names[key]
                text = tmp + " " + text
            else:
                text = numeric_to_text(value)+" "+names[key] + " " + text

    if text == '':
        text = zero

    return text



try:
    filename  = input("Enter file name [numbers.txt] : ")
    if filename == '':
        filename = "numbers.txt"
    with open(filename, "r") as file:
        for line in file.readlines():
            print(line.strip()+" --> "+numeric_to_text(int(line)))

except FileNotFoundError:
    print("File not found")

# print(numeric_to_text(435567633456))
# # print(convert_to_words(99))