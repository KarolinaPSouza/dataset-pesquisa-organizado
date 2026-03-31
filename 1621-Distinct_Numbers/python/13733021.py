import sys
sys.stdin.readline()

a = list(map(int, sys.stdin.readline().split()))
a.sort()

if not a:
    print(0)
else:
    count = 1
    for i in range(1, len(a)):
        if a[i] != a[i-1]:
            count += 1
    print(count)