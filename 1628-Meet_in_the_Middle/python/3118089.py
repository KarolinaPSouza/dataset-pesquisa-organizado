import sys
from collections import Counter

read_line   = lambda: sys.stdin.readline().strip()
read_intmap = lambda: map(int, read_line().split())

def testCase():
    n, x = read_intmap()
    l = list(read_intmap())
    n1, n2 = n//2, n - n//2
    v1, v2 = l[:n1], l[n1:]

    gray1 = [0]#using logic similar to gray code generation
    for ind, i in enumerate(v1):
        gray1.extend([i + j for j in gray1])

    h1 = Counter(gray1)


    gray2 = [0]; ans = h1[x] #since 0(null set) is not counted in the below loop
    for ind, i in enumerate(v2):
        tmp = [0]*len(gray2)
        for ind, j in enumerate(gray2):
            k = tmp[ind] = i + j
            ans += h1[x - k] 
        gray2.extend(tmp)

    print(ans)

t = 1
#t = int(input())
for i in range(t):
    testCase()


