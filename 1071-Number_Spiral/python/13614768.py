# Complexity: O(t) time where t is the number of test cases, O(1) space

def main():
    t = int(input())
    for i in range(t):
        r, c = (int(i) for i in input().split())
        number_spiral(r, c)


def number_spiral(r, c):
    if r >= c:
        # diagonal and below diagonal
        if r % 2 == 0:
            print(pow(r, 2) - c + 1)
        else:
            print(pow(r - 1, 2) + c)
    else:
        # above diagonal
        if c % 2 != 0:
            print(pow(c, 2) - r + 1)
        else:
            print(pow(c - 1, 2) + r)


if __name__ == '__main__':
    main()
