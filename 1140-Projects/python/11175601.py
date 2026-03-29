import bisect

def max_profit(n, projects):
    # Rendezzük a projekteket befejezésük ideje szerint
    projects.sort(key=lambda x: x[1])

    # DP tárolása, ahol dp[i] a maximális jutalom, ha az i. projektet választjuk
    dp = [0] * (n + 1)

    # Segédlista az induló napok gyors kereséséhez
    ends = [p[1] for p in projects]  # Befejező napok listája

    # Iteráljunk végig a projekteken
    for i in range(1, n + 1):
        start, end, reward = projects[i - 1]

        # Ne válasszuk ezt a projektet, akkor a jutalom ugyanaz, mint az előzőé
        dp[i] = dp[i - 1]

        # Keresés a legutolsó olyan projekthez, ami nem ütközik az aktuális projekttel
        # Itt a bisect_right segítségével a legnagyobb olyan indexet keresünk, amelynek a befejezés napja
        # kisebb mint a jelenlegi projekt kezdőnapja.
        idx = bisect.bisect_right(ends, start - 1)

        # Frissítjük a dp értéket, ha az aktuális projektet választjuk
        dp[i] = max(dp[i], dp[idx] + reward)

    # A legnagyobb jutalom az utolsó projekt után
    return dp[n]

# Bemenet beolvasása
n = int(input())  # A projektek száma
projects = []

for _ in range(n):
    a, b, p = map(int, input().split())  # a: kezdő nap, b: befejező nap, p: jutalom
    projects.append((a, b, p))

# Eredmény kiírása
print(max_profit(n, projects))