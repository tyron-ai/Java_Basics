# Program to check if time entered by user is valid or not

hours = eval(input('Enter the hours:\n'))
minutes = eval(input('Enter the minutes:\n'))
seconds = eval(input('Enter the seconds:\n'))
if hours<24 and hours >=0 and minutes<60 and minutes>=0 and seconds <60 and seconds>=0:
    print('Your time is valid.')
else:
    print('Your time is invalid.')