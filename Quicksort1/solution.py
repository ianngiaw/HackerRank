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

  return arr

print(' '.join(map(str, partition(array))))
