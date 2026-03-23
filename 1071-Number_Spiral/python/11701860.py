def series(n):
    return n**2 - n + 1

def get_anchor(x,y):
    return series(max(x,y))

def solve(x,y):
    anchor = series(max(x,y))
    # print(anchor)
    if max(x,y) % 2 == 1:
        # print("DEC DOWN")
        # ! decreasing down
        if y > x:
            return anchor + (y-x) 
        else:
            return anchor - (x-y) 
    else:
        # print("INC DOWN")
        if y > x:
            return anchor - (y-x) 
        else:
            return anchor + (x-y) 

# for i in range(10):
#     print(series(i))
t = int(input())
for i in range(t):
    y,x = map(int,input().split())
    print(solve(y,x))

# for r in range(5):
#     row = ""
#     for c in range(5):
#         row += str(solve(r+1,c+1)) + " "
#     print(row)

