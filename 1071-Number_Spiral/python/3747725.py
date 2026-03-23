def spiral(x,y):
    k = max(x,y)
    if k%2 == 0:
        return k*k - (y-1 +  k - x) 
    else :
        return k*k - ( x - 1 + k - y)

t = int(input())
for i in range(1,t+1):
    x_y_list = [int(j) for  j in input().split()]
    print(spiral(x_y_list[0],x_y_list[1]))