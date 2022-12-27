# Graphical-user-interface(Java Swing)
Building a Java Swing application that allows a users to specify the color and position of a circle on a canvas, then draw it.

Application's main area takes by a canvas where it will eventually draw the circle. Uses two JSliders, one horizontal under the canvas,
and one vertical on the left side of the canvas, for allowing the users to specify the position of the circle. Under the horizontal slider a 
single-selection component, and next to it a button. The single-selection component should allow the user to select one out of several possible 
colors for the circle.

The button has the label "Show." When the button is clicked, Application take the positions of the sliders and the selected color 
from the single-selection component, and drawS a small circle at the specified position with the specified color.

As soon as the circle is drawn, the button's label should changeS to "Hide." When the users clicks the button again, the circle is hidden (drawn over 
with background color -- you can repaint the entire canvas). When that happens, the button's label changes back to "Show," and the process can be 
repeated.
