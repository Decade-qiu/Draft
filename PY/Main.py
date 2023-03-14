from collections import defaultdict
from math import *

def solve():
    n, s = list(map(int, input().split()))
    s += pow(2, n+1)-2-n
    s /= pow(2, n+1)-1
    print(int(s))


test = 1
# test = int(input())
while test:
    solve()
    test -= 1
