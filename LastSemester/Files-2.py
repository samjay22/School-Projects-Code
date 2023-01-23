import random


class Game(object):

    Choices = ["Rock", "Paper", "Scissors"]

    def __init__(self):
        self.NPCID = 1
        self.PLRID = 0

    def GatherInput(self):
        return (input("Rock, Paper, or Scissors? "), random.choice(self.Choices))

    def WinPrompt(self):
        return "You Win!"
    def LosePrompt(self):
        return  "You Lose!"

    def CheckWin(self, Plr, Npc):

        if Plr == Npc:
            return "Draw!"
        elif Plr == "Rock" and Npc == "Paper":
            return self.LosePrompt()
        elif Plr == "Paper" and Npc == "Rock":
            return self.WinPrompt()
        elif Plr == "Paper" and Npc == "Scissors":
            return self.LosePrompt()
        elif Plr == "Scissors" and Npc == "Paper":
            return  self.WinPrompt()
        elif Plr == "Rock" and Npc == "Scissors":
            return self.WinPrompt()
        else:
            return self.LosePrompt()

    def Start(self):
        Plr, NPC = self.GatherInput()
        Result = self.CheckWin(Plr, NPC)

        print(Result)

        if input("Keep Playing? Y or N ").lower() == 'n':
            return 1
        else:
            return self.Start() + 1




GameObj = Game()
GameObj.Start()
