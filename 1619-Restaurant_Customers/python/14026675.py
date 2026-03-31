import sys
input = sys.stdin.readline

n = int(input())
events = []
for _ in range(n):
    a, b = map(int, input().split())
    events.append((a, 1))  #ja
    events.append((b, -1))  #mcha
events.sort(key=lambda x: (x[0], x[1])) #ila fnfs lwe9t ja oakhor mcha mam7soubch donc bdit b -1 

curr = 0
mx = 0
for _, change in events:
    curr += change
    if curr > mx:
        mx = curr
print(mx)