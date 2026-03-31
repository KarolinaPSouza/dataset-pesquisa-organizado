def distinct_numbers(n, arr):
    def merge_sort(a):
        if len(a) <= 1:
            return a
        mid = len(a) // 2
        left = merge_sort(a[:mid])
        right = merge_sort(a[mid:])
        merged = []
        i = j = 0
        while i < len(left) and j < len(right):
            if left[i] < right[j]:
                merged.append(left[i]); i += 1
            else:
                merged.append(right[j]); j += 1
        merged += left[i:]
        merged += right[j:]
        return merged
    arr = merge_sort(arr)

    count = 0
    for i in range(n):
        if i == 0 or arr[i] != arr[i-1]:
            count += 1

    return count

n = int(input())
arr = list(map(int, input().split()))
print(distinct_numbers(n, arr))
