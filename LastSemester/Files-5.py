import random

Choices = ["Rock", "Paper", "Scissors"]

ChoiceTable = {
    (Choices[0], Choices[1]) : False,
    (Choices[0], Choices[2]) : True,
    (Choices[1], Choices[0]) : True,
    (Choices[1], Choices[2]) : False,
    (Choices[2], Choices[0]) : False,
    (Choices[2], Choices[1]) : True,
}

Wins, Losses = 0, 0
Streaks = [0, 0]

while True:
    if Streaks[0] >= 2 or Streaks[1] >= 2:
        print("You have a {} W/L rate!".format(Wins/Losses))
        break

    NPC = random.choice(Choices)
    User = input("Rock, Paper, or Scissors? Choose 1, 2 or 3 to answer! ")


    if not User.isnumeric():
        print("Please enter a valid number, got {}!".format(User))
    else:
        Choice = Choices[int(User)]

        Set = (Choice, NPC)

        if Set in ChoiceTable:
            if ChoiceTable.get(Set):
                print("You won!")
                Wins += 1
                Streaks[0] += 1
                Streaks[1] = 0
            else:
                print("You Lost!")
                Losses += 1
                Streaks[0] = 0
                Streaks[1] += 1
        else:
            Streaks[0], Streaks[1] = 0, 0
            print("Tie!")


