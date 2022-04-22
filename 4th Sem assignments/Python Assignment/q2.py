discount_coupon={'monday':20,'tuesday':30,'wednesday':40,'thursday':40,'friday':50,'saturday':60,'sunday':70}

print("Enter the day")
day=input().lower()

print(f"The discount for the {day} is {discount_coupon[day]}")