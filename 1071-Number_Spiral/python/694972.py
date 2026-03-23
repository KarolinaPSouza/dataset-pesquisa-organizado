# test = int(input())
# test_array = [[int(j) for j in input().split(' ')] for i in range(test)]

for t in range(int(input())):
    x,y = [int(j) for j in input().split(' ')]

    temp = y - x

    if temp == 0:
        print(y*y - y+1)
    elif temp > 0:
        if y%2 ==0:
            print((y*y - y+1) - temp)
        else:
            print((y*y - y+1) + temp)
    else:
        if x%2 ==0:
            print((x*x - x+1) - temp)
        else:
            print((x*x - x+1) + temp)


# k = input()
# for i in range(1,k+1):
#     if i == 1:
#         print(0)

# forumla (n*n - n+1)
#1 3 7 13 21 31
# 2 4 6  8  10
# 2 6 12 20 30