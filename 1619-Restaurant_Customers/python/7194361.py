import sys
input = sys.stdin.readline

n = int(input())
ev = []
for _ in range(n):
    a, b = map(int, input().split())
    ev.append((a, 1)) 
    ev.append((b, -1))  

ev.sort()

cur = 0  
mx = 0     

for e in ev:
    cur += e[1]  
    mx = max(mx, cur)
print(mx)