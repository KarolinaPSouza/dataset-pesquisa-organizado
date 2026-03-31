slot = int(input())
num = input().split()
def find_ans(x):
    def countchar(lst):

        count = {}

        for char in lst:
            if char in count:
                count[char] += 1
            else:
                count[char] = 1

        return count.keys()
    pre = list(countchar(x))
    return len(pre)
ans = find_ans(num)
print(ans)