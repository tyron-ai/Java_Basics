ava program that calculates the Distaance between two ships. The program also gives an intersection point as well as the ship closes to it

The input file consists of pairs of lines with the following format:

a1 b1 c1 x1 y1
a2 b2 c2 x2 y2

Two ships, S1, S2, are on straight line courses that intersect at a point (xi, yi).

Ship S1's course is represented by the equation a1x+b1y + c1 = 0.

Ship S2's course is represented by the equation a2x+b2y + c2 = 0.

The intersection point, (xi, yi), may be calculated from a1, b1, c1 and a2, b2, and c2.

xi = (b1c2-b2c1)/(a1b2-a2b1)

yi = (a2c1-a1c2)/(a1b2-a2b1)

The ships S1, S2 are currently at points (x1, y1) and (x2, y2) respectively.

Which ship is nearest the intersection point?

The distance between two points (xa, ya) and (xb, yb) is √((xa-xb)2 + (ya-yb)2).