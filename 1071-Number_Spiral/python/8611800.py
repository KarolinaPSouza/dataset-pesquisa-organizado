#1 3 7 13 21
#https://www.geeksforgeeks.org/program-to-find-the-nth-term-of-the-series-3-7-13-21-31/
def get_diagonal(n):
    return (n-1)**2 + n

#1 3 5 7 9 11 ...
def get_bloquildos(n):
    return 1 + 2*(n-1)

def solution(t):
    for _ in range(t):
        row, col = [int(a) for a in input().split(' ')]
        res = get_diagonal(row)
        if row == col:
            print(get_diagonal(row))
        elif row % 2 != 0:
            if col > row:
                if col % 2 != 0:
                    print(get_diagonal(col)+(col-row))
                else:
                    print(get_diagonal(col)-(col-row))
            else:
                print(get_diagonal(row)-(row-col))
        else:
            if col > row:
                if col % 2 != 0:
                    print(get_diagonal(col)+(col-row))
                else:
                    print(get_diagonal(col)-(col-row))
            else:
                print(get_diagonal(row)+(row-col))


if __name__ == '__main__':
    t = int(input())
    solution(t)

