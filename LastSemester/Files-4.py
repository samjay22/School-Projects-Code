#We can use the basic concept behind count sort here...
import random


def RollDie(n=0, Hash = {x : 0 for x in range(1, 7)}):

    for number in range(n): # excusive
        Roll = random.randint(1, 6)

        Hash[Roll] += 1 # Ehh, we use hash here...

    for key in Hash:
        print("The number of times {} was rolled was: {}".format(key, Hash.get(key)))
        print("The % of {} being rolled was: {}".format(key, Hash.get(key) / n))




RollDie(50)
