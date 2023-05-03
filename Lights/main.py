# Import Libraries
import numpy as np
from   pathlib   import Path
from   sense_hat import SenseHat

# Create the hat
sense = SenseHat()

# Gets the current Path
dirPath  = Path(__file__).absolute().parent.parent.__str__()

# Creates a path to the .txt
filePath = dirPath + "/Riya_Madaan_Chess/moves.txt"

# Opens a file at the Path
file = open(filePath)

# Create the color constants
r = (255, 000, 000) # red
o = (255, 128, 000) # orange
y = (255, 255, 000) # yellow
g = (000, 255, 000) # green
c = (000, 255, 255) # cyan
b = (000, 000, 255) # blue
p = (255, 000, 255) # purple
n = (255, 128, 128) # pink
w = (255, 255, 255) # white
k = (000, 000, 000) # black

# Creates two blank position array
currPos    = np.array(k * 64, tuple).reshape((8, 8, 3)) # Blank board
initialPos = np.array(k * 64, tuple).reshape((8, 8, 3)) # Blank board

# Fills the initial position array
entry = 0
for i, row in enumerate(initialPos):
    for j, col in enumerate(row):
        if (entry >= 0 and entry < 16):
            initialPos[i][j] = w
        
        if (entry >= 48 and entry < 64):
            initialPos[i][j] = p

        entry += 1

# Sets the board to the inital position
sense.set_pixels(initialPos)

# The function to get the string's value
def getString() -> str:
    # Gets the moves
    moves = file.read().__str__()

    # Processes the input
    moves = moves.replace(" ", "").replace(",", "").replace("\n", "") # Replaces spaces, commas, and new lines

    return moves

# The function to get the right value associated with a letter
def getLetterVal(character: str) -> tuple:
    ret = (0, 0, 0)

    # Ensures we are looking at one character
    if (len(character) > 1):
        char = character[0]
    else:
        char = character

    # Fetches the correct value
    if char.lower() == "r":
        ret = r
    elif char.lower() == "o":
        ret = o
    elif char.lower() == "y":
        ret = y
    elif char.lower() == "g":
        ret = g
    elif char.lower() == "c":
        ret = c
    elif char.lower() == "b":
        ret = b
    elif char.lower() == "p":
        ret = p
    elif char.lower() == "n":
        ret = n
    elif char.lower() == "w":
        ret = w
    elif char.lower() == "k":
        ret = k

    return ret

# The function to change the currPos array
def updateArray(input: str):
    assert(len(input) == 64)

    # Adds the correct tuple to the currPos array
    tempEntry = 0
    for i, row in enumerate(currPos):
        for j, col in enumerate(row):
            currPos[i][j] = getLetterVal(input[tempEntry])

            tempEntry += 1

while True:
    # Gets the string
    strData = getString()
    
    # Updates the currPos array
    updateArray(strData)
    
    # Sets the pixels accordingly
    sense.set_pixels(currPos)

    # Checks for an end condition
    if (strData.replace(" ", "").lower() == "gameover"):
        break

file.close()