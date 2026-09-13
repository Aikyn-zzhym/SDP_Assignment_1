# Assignment 1: Builder Pattern — Custom Keyboard

**Course:** ShP-2216 – Software Design Patterns  
**Language:** Java (JDK 17)  

## 1. What the Product Is
For this assignment, I chose a **Custom Keyboard** as the complex object. Modern keyboards have many optional components (switch types, keycap materials, size layouts, wireless capabilities, and RGB lighting). Using a standard constructor for this would result in a messy, hard-to-read "telescoping constructor" with too many parameters. The Builder pattern solves this by allowing step-by-step configuration.

## 2. The Representations
The project implements two concrete builders that produce meaningfully different representations of a keyboard:

*   **MechanicalBuilder:** Focused on gaming and enthusiast setups. It allows configuring mechanical switches (Red, Blue, Brown) and RGB lighting. It includes a validation check to throw an exception if you try to build it with cheap membrane switches.
*   **OfficeBuilder:** Focused on productivity and quiet workspaces. It defaults to silent membrane switches, full-size layout, and wireless connectivity. It also includes a check to warn the user if they try to add RGB to a standard office board.

I also included a **KeyboardDirector** class which stores reusable "recipes" (like a preset *GamingRig* or a *StandardOffice* setup) so the client doesn't have to manually configure every step for common builds.

## 3. Project Structure
*   `Keyboard.java` - The main product class.
*   `KeyboardBuilder.java` - The builder interface with fluent setter methods.
*   `MechanicalBuilder.java` & `OfficeBuilder.java` - The concrete builders.
*   `KeyboardDirector.java` - The director class for preset configurations.
*   `Main.java` - The client class that demonstrates how everything works.

## 4. How to Run It

**Using IntelliJ IDEA (Recommended):**
1. Clone this repository or download the source code.
2. Open the folder in IntelliJ IDEA.
3. Open `Main.java` and click the green "Run" button next to the `main` method.

**Using Terminal/Command Line:**
1. Navigate to the folder containing the `.java` files.
2. Compile the code using:
   ```bash
   javac Main.java

java Main

Output Example
When you run the program, the console will output the configuration of the built keyboards using the overridden toString() method:
Gaming PC Setup: Keyboard{switchType=RED, keycaps=PBT, layout=TKL, hasRGB=true, isWireless=false}
Custom Office Setup: Keyboard{switchType=MEMBRANE, keycaps=ABS, layout=SIXTY_PERCENT, hasRGB=false, isWireless=true}
