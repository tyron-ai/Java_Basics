# A program to calculate the value of PI and computes the area of a circle of a given radius.

import math;
pi = 2 * (2/math.sqrt (2)) * (2/math.sqrt(2+math.sqrt(2))) 
pi *= (2/math.sqrt(2+math.sqrt(2 + math.sqrt(2))))
print ("Approximation of pi:",pi)

radius = eval(input ("Enter the radius:\n"))
area = pi * radius * radius

print ("Area:",area)


