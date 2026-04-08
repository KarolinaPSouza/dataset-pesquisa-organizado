def subset_sums(arr):
    # Génère toutes les sous-sommes d'un tableau (2^(len(arr)) valeurs)
    sums = [0]
    for v in arr:
        sums += [s + v for s in sums]
    return sums

def main():
    n, x = map(int, input().split())
    a = []
    while len(a) < n:
        a.extend(map(int, input().split()))
    a = a[:n]

    mid = n // 2
    left, right = a[:mid], a[mid:]

    L = subset_sums(left)
    R = subset_sums(right)

    L.sort()
    R.sort()

    # Deux-pointeurs: i monte sur L, j descend sur R
    i, j = 0, len(R) - 1
    ans = 0

    while i < len(L) and j >= 0:
        s = L[i] + R[j]
        if s == x:
            # Compter les doublons côté L
            vL = L[i]
            cntL = 1
            i += 1
            while i < len(L) and L[i] == vL:
                cntL += 1
                i += 1
            # Compter les doublons côté R
            vR = R[j]
            cntR = 1
            j -= 1
            while j >= 0 and R[j] == vR:
                cntR += 1
                j -= 1
            ans += cntL * cntR
        elif s < x:
            i += 1
        else:
            j -= 1

    print(ans)

if __name__ == "__main__":
    main()