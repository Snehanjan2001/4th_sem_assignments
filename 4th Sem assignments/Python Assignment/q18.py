# Make a list of the largest or smallest N items in a collection.

def largest(items, n):
    return sorted(items)[-n:]


def smallest(items, n):
    return sorted(items)[:n]


ll = [2, 56, 2, 67, 1256, 5, 1, 6, 23, 56, 8, 23, 5, 2, 87, 90]

print(largest(ll, 3))
print(smallest(ll, 3))
