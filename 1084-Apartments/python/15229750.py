from sys import stdin

input = stdin.readline

n, m, k = list(map(int, input().rstrip('\n').split(' ')))
des = list(map(int, input().rstrip('\n').split(' ')))
size = list(map(int, input().rstrip('\n').split(' ')))

des.sort()
size.sort()

num_ok = 0

for d in des[::-1]:
    while size and d + k < size[-1]:
        size.pop(-1)
        if len(size) == 0:
            break

    if not len(size):
        break

    if d + k >= size[-1] >= d - k:
        num_ok += 1
        size.pop(-1)
print(num_ok)