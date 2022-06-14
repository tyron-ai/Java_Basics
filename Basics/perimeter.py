# A program to calculate the perimeter of a fence, and its associated cost

# width 1 
width_1 = eval(input("Enter width 1: \n"))

#  height 1 
height_1 = eval(input("Enter height 1: \n"))

#width 2 
width_2 = eval(input("Enter width 2: \n"))

#height 2 
height_2 = eval(input("Enter height 2: \n"))

# Calculate the total distance around the fence - perimeter of the fence
perimeter = 2 * (width_1 + height_1 + width_2) 

# Print out the total fence required in meters, and The total price for the fence.
pricePerMetre = eval(input("Enter price per metre: \n"))
totalPrice = pricePerMetre * perimeter
print("The total required =", perimeter, "metres")
print("The total price = R", totalPrice)