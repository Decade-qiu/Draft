from typing import *
from collections import defaultdict
class Solution:
    def minCost(self, b1: List[int], b2: List[int]) -> int:
        d1 = defaultdict(int)
        d2 = defaultdict(int)
        d = defaultdict(int)
        for i in b1:
            d1[i] += 1
            d[i] += 1
        for i in b2:
            d2[i] += 1
            d[i] += 1
        a = [[i, d[i]] for i in d]
        a.sort(key=lambda x: x[0])
        ans = 0
        n = len(a)
        for i in range(n):
            if a[i][1]%2 == 1: return -1
        i, j = 0, n-1
        print(a, d1, d2)
        while i < j:
            while i < j and d1[a[i][0]] == a[i][1]//2:
                i += 1;
            # print(str(i)+" "+str(j))
            while i < j and d2[a[j][0]] == a[j][1]//2:
                j -= 1;
            # print(str(i)+" "+str(j))
            tp = min(abs(d1[a[i][0]]-a[i][1]//2), abs(d2[a[j][0]]-a[j][1]//2))
            if i == j: break
            ans += a[i][0]*tp
            if d1[a[j][0]] > a[j][1]//2:
                d1[a[j][0]] -= tp
            else: 
                d1[a[j][0]] += tp
            if d2[a[i][0]] > a[i][1]//2:
                d2[a[i][0]] -= tp
            else: 
                d2[a[i][0]] += tp
            if tp == abs(d1[a[i][0]]-a[i][1]//2):
                d1[a[i][0]] = a[i][1]//2
                i += 1
            else:
                if d1[a[i][0]] > a[i][1]//2:
                    d1[a[i][0]] -= tp
                else: 
                    d1[a[i][0]] += tp
            if tp == abs(d2[a[j][0]]-a[j][1]//2):
                d2[a[j][0]] = a[j][1]//2
                j -= 1
            else:
                if d2[a[j][0]] > a[j][1]//2:
                    d2[a[j][0]] -= tp
                else: 
                    d2[a[j][0]] += tp
        return ans

s = Solution()
print(s.minCost([84,80,43,8,80,88,43,14,100,88],
[32,32,42,68,68,100,42,84,14,8]))
    