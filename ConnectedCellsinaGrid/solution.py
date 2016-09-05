import sys

adjacent_cells = {
    'top-left': (-1, -1),
    'top': (-1, 0),
    'top-right': (-1, 1),
    'left': (0, -1),
    'right': (0, 1),
    'bottom-left': (1, -1),
    'bottom': (1, 0),
    'bottom-right': (1, 1)
}

n = int(sys.stdin.readline().strip())
m = int(sys.stdin.readline().strip())

visited = [[False] * m for i in range(n)]
matrix = []
for i in range(n):
    row = map(lambda x: int(x), sys.stdin.readline().strip().split(' '))
    matrix.append(row)

def generate_adjacent(i, j):
    adjacent = []
    for x, y in adjacent_cells.values():
        k = i + x
        l = j + y
        if k >= 0 and k < n and l >= 0 and l < m:
            adjacent.append((k, l))
    return adjacent

def count_and_mark_region(i, j):
    if not matrix[i][j] or visited[i][j]:
        return 0
    visited[i][j] = True
    count = 1
    for x, y in generate_adjacent(i, j):
        count += count_and_mark_region(x, y)
    return count

max_region_size = 0
for i in range(n):
    for j in range(m):
        if matrix[i][j] and not visited[i][j]:
            region_size = count_and_mark_region(i, j)
            max_region_size = max(max_region_size, region_size)

print max_region_size
