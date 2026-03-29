from bisect import bisect_left
n = int(input())
ser = []
end = []
max_current = [0]*n
for i in range(n):
    a ,b ,r = map(int,input().split())
    ser.append((b,r,a)) 
    end.append(b)
end.sort()
ser.sort()
max_current[0] = ser[0][1]
for i in range(1,n):
    idx = bisect_left(end , ser[i][2])
    if idx == 0 :
        max_current[i] = max(ser[i][1] , max_current[i-1])
    else :
        max_current[i] = max(ser[i][1] + max_current[idx-1] , max_current[i-1])
print(max_current[-1])


