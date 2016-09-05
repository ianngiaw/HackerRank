import sys

n = int(sys.stdin.readline().strip())
a = map(lambda x: int(x), sys.stdin.readline().strip().split(' '))

m = int(sys.stdin.readline().strip())
b = map(lambda x: int(x), sys.stdin.readline().strip().split(' '))

x_min = min(b)

a_counts = [0] * 100
for x in a:
    a_counts[x - x_min] += 1

b_counts = [0] * 100
for x in b:
    b_counts[x - x_min] += 1

missing_numbers = []
for i, (x_a, x_b) in enumerate(zip(a_counts, b_counts)):
    if x_a < x_b:
        missing_numbers.append(str(x_min + i))

print ' '.join(missing_numbers)
