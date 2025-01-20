import sys

N :int = int(sys.stdin.readline())

alpha = [False] * 26

ans = N
for _ in range(N):
    word : str = sys.stdin.readline().strip()
    prev : str = ""
    for i in range(len(word)):
        c = ord(word[i]) - ord('a')
        if prev != word[i] and alpha[c]:
            ans-=1
            break
        alpha[c]=True
        prev = word[i]
    alpha[:] = [False] * 26

print(ans)