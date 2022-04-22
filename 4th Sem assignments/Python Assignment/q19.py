def display_map(map_p: dict):
    for i in map_p.keys():
        print(f"{i:10} --> {map_p[i]}")
    print()


def sort_map(map_p: dict):
    return dict(sorted(map_p.items(), key=lambda x: x[1]))


m_map1 = {
    "Tata": 440,
    "Birla": 560,
    "ICICI": 800,
    "HDFC": 670,
    "SBI": 500,
    "HCL": 2500
}

# Find minimum price, maximum price and sort items according to their prices in first dictionary
minimum_price_stock = min(m_map1, key=m_map1.get)  # Minimum Price
maximum_price_stock = max(m_map1, key=m_map1.get)  # Maximum Price

print(f"Minimum price stock is {minimum_price_stock}", end="\n")
print(f"Maximum price stock is {maximum_price_stock}", end="\n\n")

m_map1 = sort_map(m_map1)  # Sort the dictionary according to their prices
print(f"- - - - - After sorting by price - - - - -")
display_map(m_map1)

# Create another second stock dictionary.
m_map2 = {
    "Tata": 1500,
    "Birla": 800,
    "Reliance": 332,
    "Infosys": 340,
    "TCS": 450
}

# Find items that are only in first dictionary
print(f"- - - - - Items that are only in first dictionary - - - - -")
for i in m_map1.keys():
    if i not in m_map2.keys():
        print(f"{i:10} --> {m_map1[i]}")

print()

# Find items whose prices do not match
print(f"- - - - - Items whose prices do not match - - - - -")
for i in m_map1.keys():
    try:
        if m_map1[i] != m_map2[i]:
            print(f"{i:10} --> {m_map1[i]} --> {m_map2[i]}")
    except KeyError:
        continue

print()

# Remove duplicate items from first dictionary.
duplicate_keys = []
for i in m_map1.keys():
    if i in m_map2.keys():
        duplicate_keys.append(i)

for i in duplicate_keys:
    m_map1.pop(i)

print(f"- - - - - After removing duplicate items from first dictionary - - - - -")
display_map(m_map1)

# Sort both dictionaries for incrementing prices
m_map1 = sort_map(m_map1)
m_map2 = sort_map(m_map2)

print(f"- - - - - After sorting both dictionaries for incrementing prices - - - - -")
print(f"First dictionary:")
display_map(m_map1)
print(f"Second dictionary:")
display_map(m_map2)

# Group items in first dictionary by price in multiple of 500
print(f"- - - - - Group items in first dictionary by price in multiple of 500 - - - - -")
for i in m_map1.items():
    if i[1] % 500 == 0:
        print(f"{i[0]:10} --> {i[1]}")
print()

# Find an item with price=800 from both dictionaries.
print(f"- - - - - Find an item with price=800 from both dictionaries - - - - -")
print(f"First dictionary:")
for i in m_map1.items():
    if i[1] == 800:
        print(f"{i[0]:10} --> {i[1]}")
print()

print(f"Second dictionary:")
for i in m_map2.items():
    if i[1] == 800:
        print(f"{i[0]:10} --> {i[1]}")
