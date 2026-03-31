N = int(input())
A = list(map(int, input().split()))

def merge_sort(l, r):
    if l == r:
        return

    merge_sort(l, (l+r)//2 )
    merge_sort((l+r)//2 + 1, r)

    c = []
    first_pointer = l
    second_pointer = (l+r)//2 + 1

    while first_pointer <= (l+r)//2 and second_pointer <= r:
        if A[first_pointer] <= A[second_pointer]:
            c.append(A[first_pointer])
            first_pointer += 1
        else:
            c.append(A[second_pointer])
            second_pointer += 1

    while first_pointer <= (l+r)//2:
        c.append(A[first_pointer])
        first_pointer += 1

    while second_pointer <= r:
        c.append(A[second_pointer])
        second_pointer += 1

    for i in range(len(c)):
        A[l+i] = c[i]

merge_sort(0, len(A)-1)
unique = A[0]
C = [A[0]]
for i in range(len(A)):
    if A[i] != unique:
        unique = A[i]
        C.append(unique)
print(len(C))