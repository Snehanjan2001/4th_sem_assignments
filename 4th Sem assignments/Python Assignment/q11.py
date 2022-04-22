# Python3 program to generate pythagorean
# triplets smaller than a given limit


# def pythagoreanTriplets(limits) :
# 	c, m = 0, 2
# 	while c < limits :
# 		for n in range(1, m) :
# 			a = m * m - n * n
# 			b = 2 * m * n
# 			c = m * m + n * n

# 			if c > limits :
# 				break

# 			print(a, b, c)

# 		m = m + 1

def pythagoreanTriplets(limits) :
	for i in range(1, limits+1):
		for j in range(i, limits+1):
			for k in range(1, limits+1):
				if i*i + j*j == k*k:
					print(i, j, k)


if __name__ == '__main__' :
	
	limit = 50
	pythagoreanTriplets(limit)

