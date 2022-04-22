import time


def gp(a, r):
    t1 = time.time_ns()
    while True:
        if abs(a) > 100_000:
            return
        else:
            t2 = time.time_ns()
            yield a, (t2 - t1)
            t1 = time.time_ns()
        a *= r


start_t = time.time_ns()
for i in gp(1, 2):
    print(f"{i[0]:8} --> {i[1] / 1000:.3f} microseconds")
end_t = time.time_ns()
print(f"\nTotal time: {(end_t - start_t) / 1000} microseconds")
