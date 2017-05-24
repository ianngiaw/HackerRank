"""
Solution to Bigger is Greater on Hackerrank
https://www.hackerrank.com/challenges/bigger-is-greater
"""
T = int(raw_input())

def find_greater(string):
    """
    Finds the next greater string using the characters of the original string
    Returns 'no answer' if not possible
    """
    if not string:
        return 'no answer'

    rev_char_list = list(string)
    rev_char_list.reverse()

    curr_max = rev_char_list[0]
    for idx, char in enumerate(rev_char_list):
        if char < curr_max:
            suffix = rev_char_list[:idx+1]
            deduped_suffix = list(set(suffix))
            sorted_deduped_suffix = sorted(deduped_suffix)
            current_pos = sorted_deduped_suffix.index(char)
            selected_char = sorted_deduped_suffix[current_pos + 1]
            suffix.remove(selected_char)
            suffix.sort(reverse=True)
            next_greatest = suffix + [selected_char] + rev_char_list[idx+1:]
            next_greatest.reverse()
            return ''.join(next_greatest)
        elif char > curr_max:
            curr_max = char

    return 'no answer'

for i in range(T):
    H = raw_input().strip()
    print find_greater(H)
    