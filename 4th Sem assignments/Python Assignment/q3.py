from itertools import compress


is_even = lambda x : x % 2 == 0

list_of_numbers = list(range(0,30))

numbers_is_even = list(map(is_even, list_of_numbers))

even_numbers = list(compress(list_of_numbers, numbers_is_even))
odd_numbers = list(set(list_of_numbers) - set(even_numbers))

print(even_numbers)
print(odd_numbers)
