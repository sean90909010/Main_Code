## this is an automated script designed for the pi to get it set up properly
# install vital things for the average user and a programmer
# depending on their language and preferences
# ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

## this is imorting the os module so it can interact with the terminal
# also this is importing the sys module so it can do other important things
import os
import sys

## this is instructing the user how to use the program

print("""
Hello,
This program is designed to be used on a raspberry pi
This program is interactive and has 3 start up settings
Please do not alter the program
The program was designed and created by Sean Khan
This is a link to his Workspaces on different hosting sites if you want to see more (link here)
This is a page created and hosted by him in order to contact him (link here)
Thank you for using the program
""")

## this is asking the user if it wants to continue

UserIn = input("Do you wish to continue: ")
if UserIn == "y" or "Y" or "Yes" or "yes":
    print("OK Lets Continue: ")
    
elif UserIn == "n" or "N" or "No" or "no":
    print("OK Stopping Program: ")
    quit
    
else:
    print("Sorry. I don't understand what you are saying please put in a valid answer: ")
    UserIn
    
## this is asking the user if it wants an automated user install

## this is asking the user if it wants an automated programer install

## this is asking the user if it wants to do a custom install

## this lists out what it has done

## this asks the user if it is happy