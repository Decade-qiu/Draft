from math import gcd
from typing import *
from collections import defaultdict

def qpow(a, b, c):
    res = 1
    while b:
        if (b&1)==1: res = (res*a)%c
        a = (a*a)%c
        b >>= 1
    return res

class Solution:
    def findValidSplit(self, nums: List[int]) -> int:
        M = int(1e9+7)
        s, p = 1, 1
        for i in nums: s = (s*i)%M
        print(s)
        for i in range(len(nums)-1):
            p = (p*nums[i])%M
            s = s*qpow(nums[i], M-2, M)
            print(str(p)+" "+str(s))
            if gcd(p, s) == 1: return i
        return -1

s = Solution()
print(s.findValidSplit([4,7,8,15,3,5]))
    