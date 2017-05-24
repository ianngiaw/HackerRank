m = input()
array = map(int, input().split(' '))

def partition(arr):
  n = len(arr)
  pivot, curr = 0, 1
  while pivot < n and curr < n:
    if arr[pivot] > arr[curr]:
      temp_pivot = arr[pivot]
      arr[pivot] = arr[curr]
      arr[curr] = arr[pivot + 1]
      arr[pivot + 1] = temp_pivot
      pivot += 1
    curr += 1

  left = arr[:pivot]
  if len(left) > 0:
    left = partition(left)
  right = arr[pivot+1:]
  if len(right) > 0:
    right = partition(right)

  arr = left + [arr[pivot]] + right
  if len(arr) > 1:
    print_arr(arr)
  return arr

def print_arr(arr):
  print(' '.join(map(str, arr)))

partition(array)
