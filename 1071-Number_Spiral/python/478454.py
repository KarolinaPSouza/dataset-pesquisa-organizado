a = int(input())
mas = []
for i in range(a):
    mas.append(input().split())
for i in mas:
    c = list(map(int,i))
    ryad = max(c[0],c[1])
    ryad2 = ryad - 1
    per = ((1 + (ryad2 * 2 - 1)) // 2) * ryad2  + 1
    # while ryad2 != 0:
    #     per += ryad2 * 2 - 1
    #     ryad2 -= 1
    kon = per + ryad*2 - 2
    if ryad % 2 == 0:
        if c[0] == c[1]:
            print((per + kon) // 2)
        elif c[0] < c[1]:
            print(per + c[0] - 1)
        else:
            print(kon - c[1] + 1)
    else:
        if c[0] == c[1]:
            print((per + kon) // 2)
        elif c[0] > c[1]:
            print(per + c[1] - 1)
        else:
            print(kon - c[0] + 1)