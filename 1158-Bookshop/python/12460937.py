def funcao(n, peso_maximo, valores, pesos):
    dp = [0] * (peso_maximo + 1)

    for i in range(1, n + 1):
        for j in range(peso_maximo, pesos[i - 1] - 1, -1):
            dp[j] = max(valores[i - 1] + dp[j - pesos[i - 1]], dp[j])

    return dp[peso_maximo]

n, peso_max = map(int, input().split())
pesos = list(map(int, input().split()))
valores = list(map(int, input().split()))

print(funcao(n, peso_max, valores, pesos))