# program to guess a secret number

secret_number = 17   # secret number in program
guess = 0            # variable storing user's guess

# as long as we have not found the secret number
while guess != secret_number:
    # get a new guess from user
    guess = eval(input("What is the secret number? "))
    # check if guess is too low
    if guess < secret_number:
        print ("That is way too low. Please try again.")
    # or too high
    elif guess > secret_number:
        print ("That is much too high. Please try again.")
    
print ("Congratulations, you have guessed the secret number!")   # print message indicating success