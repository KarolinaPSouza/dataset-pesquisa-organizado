def solve(n, arr):
    arr.sort()
    res = 1
    for i in range(1,n):
        if arr[i] != arr[i -1]:
            res += 1
    return res

n = input()
arr = input()
print(solve(int(n), arr.split(" ")))