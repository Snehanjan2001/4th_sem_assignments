ll=list(filter(lambda x: x is not None,map(lambda x:x if x%2==1 else None,[i*i for i in range(0,10)])))
print(ll)