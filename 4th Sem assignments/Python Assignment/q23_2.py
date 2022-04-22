# Write a python program to

# ii. Convert lines of different lengths into lines of same length (maximum length). Use
# padding if and when required.


def add_padding(line, max_line_length):
    if len(line) >= max_line_length:
        return line
    

    words = line.split(" ")
    length_to_extend = max_line_length - len(line.replace(" ", ""))

    spacing_after_every_word = int(length_to_extend / (len(words) - 1))
    spacing_after_last_word = length_to_extend % (len(words) - 1)
    
    new_line = ""
    for word in words[:-1]:
        new_line += word
        if word != words[-2]:
            new_line += " " * spacing_after_every_word
        else:
            new_line += " " * (spacing_after_every_word + spacing_after_last_word)

    new_line += words[-1]

    return new_line




lines_input = []
max_line_length = 0

# Open file and store lines in `lines_input` list and also calculate max line length
with open("lorem.txt", "r") as f:
    for line in f.readlines():
        ll = str(line).strip()
        lines_input.append(ll)
        if len(ll) > max_line_length:
            max_line_length = len(ll)


# Modify lines to have same length
for index, val in enumerate(lines_input):
    lines_input[index] = add_padding(val, max_line_length)

# Store lines in a new file
with open("lorem_modified.txt", "w") as f:
    for line in lines_input:
        f.write(line + "\n")