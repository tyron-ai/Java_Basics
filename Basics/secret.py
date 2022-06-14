# program to guess a secret number

secret_number = 17   #secret number 
guess = 0            #variable storing user's guess

# as long as we have not found the secret number
while guess != secret_number:
    # get a new guess from user
    guess = eval(input("Enter number: "))
    # check if guess is too low
    if guess < secret_number:
        print ("low")
    # or too high
    elif guess > secret_number:
        print ("high")
    
print ("Correct!")   # print message indicating success