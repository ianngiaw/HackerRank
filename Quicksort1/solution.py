n = input()
arr = map(int, input().split(' '))

pivot, curr = 0, 1
while pivot < n and curr < n:
  if arr[pivot] > arr[curr]:
    temp_pivot = arr[pivot]
    arr[pivot] = arr[curr]
    arr[curr] = arr[pivot + 1]
    arr[pivot + 1] = temp_pivot
    pivot += 1
  curr += 1

print(' '.join(map(str, arr)))
