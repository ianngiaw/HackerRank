from sets import Set

# Returns the size of the group
def dfs_label(road_map, groups, current, label):
    if groups[current] > -1:
        return 0
    groups[current] = label
    total = 0
    for neighbor in road_map[current]:
        total += dfs_label(road_map, groups, neighbor, label)
    return total + 1

def find_min_group_cost(cost_lib, cost_road, group_size):
    single_lib_cost = cost_lib + (cost_road * (group_size - 1))
    multi_lib_cost = cost_lib * group_size
    return min(single_lib_cost, multi_lib_cost)

def find_min_cost(road_map, cost_lib, cost_road):
    groups = map(lambda x: -1, road_map)
    sizes = []
    label = 0
    for i in range(1, len(groups)):
        if groups[i] == -1:
            size = dfs_label(road_map, groups, i, label)
            sizes.append(size)
            label += 1
    return sum(map(lambda s: find_min_group_cost(cost_lib, cost_road, s), sizes))

q = int(raw_input().strip())
for query in xrange(q):
    n, m, x, y = raw_input().strip().split(' ')
    n, m, x, y = [int(n), int(m), long(x), long(y)]

    road_map = map(lambda x: Set(), range(n + 1))

    for a1 in xrange(m):
        city_1, city_2 = raw_input().strip().split(' ')
        city_1, city_2 = [int(city_1), int(city_2)]

        road_map[city_1].add(city_2)
        road_map[city_2].add(city_1)

    print(find_min_cost(road_map, x, y))

