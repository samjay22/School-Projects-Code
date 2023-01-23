import math

#No objects this time, I lazy and am studying for an Amazon interview...
#There are lots of algo's that are pretty cool.
#There are also lots of different ways to solve problems, ever heard of Dynamic Programming or Backtracking?
#Thats what my weekended consisted of...

def SolveCylinder(r = 0, h = 0) -> float:
    return (2 * math.pi * r * h) + (2 * math.pi * math.pow(r, 2))




TestCases = [{'r' : 6, 'h' : 9}, {'r' : 2, 'h' : 10}]


for Hash in TestCases:
    print("Surface Area: " + str(SolveCylinder(Hash['r'], Hash['h'])))
