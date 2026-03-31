'''
https://cses.fi/problemset/result/7385127/
District Numbers
'''
def found(el, mas):
    if not mas:
        return False
    left = 0
    right = len(mas)
    while left < right:
        middle = (right+left)//2
        t = mas[middle]
        if el == t:
            return True
        if el < t:
            right = middle-1
        else:
            left = middle+1

    return False
n = int(input())
numbers = input().split()

numbers.sort()
res = []
for i in numbers:
    if found(i, res) == False:
            res.append(i)
print(len(res))