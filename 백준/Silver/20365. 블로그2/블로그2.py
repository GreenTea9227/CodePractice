N: int = int(input())
paint: str = input()

prev = "C"
cntBlue = 0
cntRed = 0

for p in paint:
    if prev == p:
        continue

    if p == "B":
        cntBlue += 1
        prev = "B"
    else:
        cntRed += 1
        prev = "R"

print(1 if cntBlue == 0 or cntRed == 0 else min(cntBlue, cntRed) + 1)
