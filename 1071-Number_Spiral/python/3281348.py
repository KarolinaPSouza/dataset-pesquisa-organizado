def find_diag(n):
    diag = 1 + (n-1)*(2+(n-2));
    return diag


def find_el_spriral():
    [r, c] = list(map(int, input().split()))
    if (r > c):
        # lower half, need to use row for diag
        diag = find_diag(r)
        if r % 2 == 0:
            # Increment
            print(diag + (r - c))
        else:
            print(diag - (r - c))
    else:
        diag = find_diag(c)
        if c % 2 == 0:
            # Decrement
            print(diag - (c - r))
        else:
            print(diag + (c - r))


if __name__ == "__main__":
    n = int(input())
    for i in range(n):
        find_el_spriral()