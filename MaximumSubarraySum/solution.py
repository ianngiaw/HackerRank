import sys

q = int(sys.stdin.readline())

for t in range(q):
    n, m = map(int, sys.stdin.readline().split(' '))
    arr = list(map(int, sys.stdin.readline().split(' ')))

    mods = list(map(lambda x: x % m, arr))
    sub_arr_sums = [0]
    for i in range(n):
        sub_arr_sums.append((sub_arr_sums[i] + mods[i]) % m)

    max_amount = 0
    for i in range(n - 1):
        if max_amount == m - 1:
            break
        for j in range(i + 1, n):
            amount = (sub_arr_sums[j] - sub_arr_sums[i]) % m
            max_amount = max(max_amount, amount)
            if max_amount == m - 1:
                break
    print(max_amount)
