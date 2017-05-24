"""
Solution to Designer PDF Viewer on Hackerrank
https://www.hackerrank.com/challenges/designer-pdf-viewer
"""
H = map(int, raw_input().strip().split(' '))
WORD = raw_input().strip().lower()
MIN = ord('a')

print len(WORD) * max(map(lambda x: H[ord(x) - MIN], WORD))
