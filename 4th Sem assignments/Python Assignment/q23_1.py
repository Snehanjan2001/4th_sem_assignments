# Write a python program to read lines from a file, break into tokens and convert the tokens to unique numerical values using python dictionary.

lines_input = []

# Open file and store lines in `lines_input` list
with open("para.txt", "r") as f:
    for line in f.readlines():
        ll = str(line).strip()
        lines_input.append(ll)

# Break lines into tokens
tokens = []
for line in lines_input:
    tokens += line.split(" ")

# Convert tokens to unique numerical values using dictionary
last_issued_numerical_value = 1
numerical_values_map = {}
for token in tokens:
    if token not in numerical_values_map:
        numerical_values_map[token] = last_issued_numerical_value
        last_issued_numerical_value += 1

# Display the map
print("- - - - - Numerical values map - - - - -")
for i in numerical_values_map.keys():
    print(f"{i:10} --> {numerical_values_map[i]}")    
print()

# Convert the tokens to unique numerical values
tokens_numerical_values = []
for token in tokens:
    tokens_numerical_values.append(numerical_values_map[token])

print("Tokens            : ", tokens)
print("Numerical Values  : ", tokens_numerical_values)
print()

print(f"- - - - - Tokens to unique numerical values - - - - -")
for i in range(len(tokens_numerical_values)):
    print(f"{tokens[i]:10} --> {tokens_numerical_values[i]}")
print()
