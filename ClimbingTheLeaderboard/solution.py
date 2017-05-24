"""
Solution to Climbing the Leaderboard on Hackerrank
https://www.hackerrank.com/challenges/climbing-the-leaderboard
"""
N = int(raw_input().strip())
SCORES = map(int, raw_input().strip().split(' '))
M = int(raw_input().strip())
ALICE = map(int, raw_input().strip().split(' '))

FILTERED_SCORES = []
for score in SCORES:
    if FILTERED_SCORES and FILTERED_SCORES[-1] == score:
        continue
    FILTERED_SCORES.append(score)

current_pos = len(FILTERED_SCORES)
for score in ALICE:
    while current_pos > 0 and FILTERED_SCORES[current_pos - 1] <= score:
        current_pos -= 1
    print current_pos + 1
