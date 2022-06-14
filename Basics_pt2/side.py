# A program to calculate the length of one side of a triangle given the other two sides
# Pythagorus Theorem

import math
a = float(input("Enter the length of side a:\n"))
c = float(input("Enter the length of side c:\n"))
if a>0.0 and c>0.0:
    print("The length of side b is ", end='')
    print(math.sqrt(c**2-a**2), ".", sep='')
else:
    print('Sorry, lengths must be positive numbers.\n')
