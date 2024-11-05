Multimeter Simulator 



***Project Overview***

The Multimeter Simulator is a Java-based graphical user interface (GUI) application designed to simulate a multimeter device. This simulator allows users to input values for resistance and voltage (both AC and DC) and perform simple calculations. The output is displayed based on the selected measurement type (e.g., DC voltage, AC voltage, resistance, or result of a voltage/resistance calculation).
The application is built using Java Swing, and it includes features such as a gradient background, custom button styling, and interactive radio buttons for selecting the measurement type. The user input is validated to ensure only valid numerical values are entered.


***Features***
1. User Input Fields: The app allows users to input values for:
   Resistance (Ω)
   AC Voltage (V)
   DC Voltage (V)

2. Customizable Output: Based on the selected measurement type, the output label will display:
   DC Voltage
   AC Voltage
   Resistance (Ω)
   Calculation result (V/Ω)
   OFF status
   
4. Submit and Clear Buttons:
   The Submit button processes the input and displays the appropriate output based on the selection.
   The Clear button resets all input fields to their default empty state.
   
6. Radio Buttons: Allows users to select different modes, such as:
   OFF (No output)
   Display DC Voltage
   Display AC Voltage
   Display Resistance
   Calculate Voltage/Resistance (V/Ω)
   
8. Gradient Background: The app features a custom gradient background for the main panel.
9. Custom Button Styling: The submit button is designed with a gradient color effect, adding visual appeal to the interface.





***Technologies Used***

   Java Swing: Used for creating the graphical user interface (GUI).
   Java AWT: Utilized for custom drawing and creating buttons with custom paint methods.
   Java 2D Graphics: For drawing images and gradient backgrounds.



   

   
**How to Run**

***Prerequisites***

1. Java Development Kit (JDK): Ensure that Java is installed on your system.
   You can download Java from Oracle's official website or install it via your package manager (e.g., apt-get for Linux, brew for macOS).
2. IDE (Optional): You can use any IDE like IntelliJ IDEA, Eclipse, or NetBeans to run the project.






**Steps to Run the Application**


1.Download the Code: Clone or download the repository containing the MultimeterMiniProject.java file.
2.Compile the Code:

Open your terminal or command prompt.
Navigate to the directory containing the MultimeterMiniProject.java file.
Compile the Java file using the following command:

      javac MultimeterMiniProject.java



  **Run the Application:**
   Once compiled, run the application using:

        java MultimeterMiniProject

  The GUI should open with a window labeled "Multimeter Simulator."


  **Files to Note**


   
MultimeterMiniProject.java: The main Java source file that contains the entire program logic and GUI design.

1.png and 2.png: Image files used for custom graphical elements in the multimeter panel. Make sure these images are in the same directory as the Java source file or update the path in the paintComponent method of the CustomImagePanel class.


**Code Explanation**

The MultimeterMiniProject.java file consists of multiple components that work together to create the GUI and handle user interactions:

 . JFrame: The main window (frame) that contains all panels and elements.
 . GradientPanel: A custom panel with a gradient background used for the main interface area.
 . CustomImagePanel: A custom panel that displays multimeter images in the GUI.
 . User Input Panel (panel4): Contains the input fields for resistance, AC voltage, and DC voltage, as well as buttons for submitting and clearing input.
 . Radio Buttons: Allow users to select different measurement types or functionalities (e.g., DC Voltage, AC Voltage, Resistance, etc.).
 . ActionListeners: Handle user actions such as clicking the submit button and changing radio button states. Each listener updates the output label accordingly.



  
**Key Classes & Methods:**


 . FloatDocumentFilter: This custom class restricts the text input to valid numbers (with one optional decimal point).
 . JTextArea for Input: These are the input fields for resistance, AC voltage, and DC voltage. They use FloatDocumentFilter to ensure proper input validation.
 . Custom Button Styles: The submitButton and clearButton have custom rendering code in the paintComponent method to apply gradient fills and visual effects.
 . Output Label: Based on the selected measurement mode and input values, the output label displays the result (e.g., "12.3 V", "123 Ω", or the calculated result).


  **Example of Interactions:**


 1. Submit Action:

  . If "DC Voltage" is selected, the DC voltage value entered in the input field is displayed in the output label.
  . If "Resistance" is selected, the resistance value is displayed.
  . If "Calculate V/Ω" is selected, the app calculates the voltage divided by resistance and displays the result.
  . Clear Action:
  . Clicking the "Clear" button resets all input fields.
  . Radio Button Actions:
  . Clicking the radio buttons allows the user to switch between different modes, affecting the displayed output.



  **Screenshots**

 <img width="1680" alt="Screenshot 2024-11-05 at 12 20 59" src="https://github.com/user-attachments/assets/b00b7cbd-a627-4b85-9440-c0b17ebaf266">


**Troubleshooting**

  . Issue: The program doesn't run or throws a class not found exception.
      . Solution: Ensure that the MultimeterMiniProject.java file is compiled and you are running the correct class.
  . Issue: Images are not displaying.
      . Solution: Ensure that 1.png and 2.png are in the correct path or directory relative to the Java source file.



**License**

his project is open-source and can be freely used, modified, and distributed.





