N = 7

def fib(n):
    a, b = 0, 1
    iterate = iter(range(n))
    while True:
        try:
            next(iterate)
            yield a
            a, b = b, a + b
        except StopIteration:
            break

print(list(fib(N)))