# Graphical-user-interface(Java Swing)
This Java Swing application allows users to interactively specify the color and position of a circle on a canvas and then draw it.

## User Interface Components
The main area of the application is occupied by a canvas where the circle will be drawn. The following components are provided to facilitate the circle specification.

- **Horizontal Slider:** A JSlider positioned under the canvas, enabling users to select the horizontal position of the circle.
- **Vertical Slider:** A JSlider placed on the left side of the canvas, allowing users to specify the vertical position of the circle.
- **Color Selection:** A single-selection component located below the horizontal slider, providing users with options to choose the color of the circle.
- **Show/Hide Button:** A button labeled "Show" initially. When clicked, it triggers the circle drawing functionality. After the circle is drawn, the button's label changes to "Hide." Clicking the button again hides the circle and restores the label to "Show," enabling the process to be repeated.

## Drawing Functionality
When the "Show" button is clicked, the application retrieves the positions of the sliders and the selected color from the color selection component. It then draws a small circle on the canvas at the specified position, using the chosen color.

## Hide Functionality
After the circle is drawn, clicking the "Hide" button will hide the circle by drawing over it with the background color of the canvas. The button's label will revert to "Show," indicating that the circle is hidden. The user can then repeat the process by clicking the button again to show and draw a new circle.

## GUI
<img width="600" alt="GUI picture" src="https://github.com/umangptl/Graphical-user-interface/blob/main/GUI.png">
