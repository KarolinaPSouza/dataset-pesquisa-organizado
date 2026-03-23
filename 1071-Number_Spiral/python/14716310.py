def find_numbers_in_spiral():
    t = int(input())
    for _ in range(t):
        y, x = map(int, input().split())
        print(pos_in_spiral(x, y))


def pos_in_spiral(x, y):
    value = 0
    if x >= y:
        if x % 2 != 0:
            value = x ** 2 - y + 1
        else:
            value = (x - 1) ** 2 + y
    else:
        if y % 2 != 0:
            value = (y - 1) ** 2 + x
        else:
            value = y ** 2 - x + 1

    return value


if __name__ == "__main__":
    find_numbers_in_spiral()