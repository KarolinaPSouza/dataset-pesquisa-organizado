from bisect import bisect_right

def check_tick(i):
    if i < 0:
        return i
    elif i != used[i]:
        used[i] = check_tick(used[i])
    return used[i]

input()
Ptick = sorted(int(x) for x in input().strip().split())
Pcus = [int(x) for x in input().strip().split()]

used = list(range(len(Ptick)))

for x in Pcus:
    i = check_tick(bisect_right(Ptick, x) - 1)
    if i == -1:
        print(-1)
    else:
        print(Ptick[i])
        used[i] = check_tick(i - 1)