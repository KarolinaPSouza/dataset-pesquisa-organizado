def distinct(n, arr):

    arr.sort()
    distinct_count = 1

    for i in range(1, n):
        if arr[i] != arr[i - 1]:
            distinct_count += 1

    print(distinct_count)

num = int(input())
arr = list(map(int, input().split()))
distinct(num, arr)