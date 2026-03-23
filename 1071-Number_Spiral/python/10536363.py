def row(y, x):
    if y % 2 == 0:
        print((y * y) - (x - 1))
    else:
        print((((y - 1) * (y - 1)) + 1) + (x - 1))

def col(y, x):
    if x % 2 == 1:
        print((x * x) - (y - 1))
    else:
        print(((x - 1) * (x - 1)) + 1 + (y - 1))

def solve():
    y, x = map(int, input().split())
    if y > x:
        row(y, x)
    else:
        col(y, x)

def main():
    import sys
    input = sys.stdin.read
    data = input().strip().split('\n')

    t = int(data[0])
    for i in range(1, t + 1):
        y, x = map(int, data[i].split())
        if y > x:
            row(y, x)
        else:
            col(y, x)

if __name__ == "__main__":
    main()