split = list(map(int, input().strip().split(" ")))
A: int = split[0]
B: int = split[1]
C: int = split[2]
M: int = split[3]

time = 0
fatigue = 0
work = 0

while time < 24:

    if fatigue + A > M:
        fatigue = max(fatigue - C, 0)
    else:
        fatigue += A
        work += B

    time += 1
print(work)
