# Import Libraries
import numpy as np
#from   sense_hat import SenseHat

# Create the hat
#sense = SenseHat()

# Create the color constants
r = (255, 0, 0) # red
o = (255, 128, 0) # orange
y = (255, 255, 0) # yellow
g = (0, 255, 0) # green
c = (0, 255, 255) # cyan
b = (0, 0, 255) # blue
p = (255, 0, 255) # purple
n = (255, 128, 128) # pink
w = (255, 255, 255) # white
k = (0, 0, 0) # black

# Creates a blank position array
initialPos = np.array(k * 64, tuple).reshape((8, 8, 3)) # Blank board

# Fills the initial position array
for i in range(0, 64):
    mod  = i % 8
    if (i > 0 and i < 16):
        initialPos[mod][0] = tuple(p)

    if (i > 48 and i < 64):
        initialPos[mod][0] = tuple(w)

print(initialPos)

# Sets the board to the position
#sense.set_pixels(initialPos)