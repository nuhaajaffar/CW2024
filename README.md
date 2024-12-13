# COMP2042 - Developing Maintainable Software
[CW2024 - Nuhaa Jaffar](<https://github.com/nuhaajaffar/CW2024.git>)

---

## Compilation Instructions  

### 1. Prerequisites  

Before you begin, ensure the following tools and dependencies are set up:

- **Java Development Kit (JDK)** version **19 (or above)** with **JavaFX** support.  
- **Apache Maven** for dependency management and the build process.  
- **(Optional)** An Integrated Development Environment (IDE) like [IntelliJ IDEA](https://www.jetbrains.com/idea/).  
- **(Optional)** `git` to clone the repository directly.  

---

### 2. Clone the Repository  

You can clone the repository using `git` or manually download it as a ZIP file.

- Using `git` :

```bash
git clone https://github.com/nuhaajaffar/CW2024.git
cd CW2024
```

- If You Don't Have Git :

If you don't have `git` installed on your system, follow these steps to download the project manually:

1. Go to the [CW2024](<https://github.com/nuhaajaffar/CW2024.git>) 
2. Click the **Code** button and select **Download ZIP**.  
3. Extract the downloaded `.zip` file.  
4. Navigate to the extracted project directory.

---

### 3. Build and Run  

You can build and run the application using either the command line or IntelliJ IDEA.

- From Command Line (with Maven installed):

Use the following command :

```bash
mvn clean compile javafx:run
```
---

- From IntelliJ IDEA :

If you prefer using **IntelliJ IDEA**, follow these steps:

1. Import the project into **IntelliJ IDEA**.  
2. Ensure **JDK 19 (or above)** is configured in the project settings.  
3. Locate the `Main` method where `CW2024/src/main/java/com/example/demo/controller/Main.java` and run the application.

---

### ⚠️ Troubleshooting  

If you encounter any issues during the build or run process, check the following:

- **JDK 19 (or above) and JavaFX**: Ensure that JDK 19 (or above) and JavaFX are installed correctly on your machine.  
- **Maven Installation**: Verify that Maven is installed and configured properly.  
- **IDE Configuration**: Check that your IDE's settings point to the correct JDK version.  

For additional assistance, visit the following resources:

- [JavaFX Documentation](https://openjfx.io/)  
- [Apache Maven Guide](https://maven.apache.org/)

---
---

## Implemented and Working Properly
### Feature 1: Menu
- **Description** :
     - **Main Menu** : The menu that users will see as they launch the game. From this menu, users can go to How To Play Menu to view the instructions on how to play the game. They can come back to the main menu and click on Play to proceed to Level 1.
     - **How To Play Menu** : The menu that users can view the instructions of the game.
     - **Win Menu** : The menu that will appear when the users had won and finishes the game, offering an option to replay the game from Level 1 (Users can also press spacebar to proceed) or return to main menu.
     - **Game Over Menu** : The menu that will appear when the users are defeated, offering an option to replay the game from Level 1 (Users can also press spacebar to proceed) or return to main menu.

### Feature 2: Plane Left and Right Movement
- **Description** :
     - **Arrow Left and Right** : Users can move to the left and right which i san additional where they can only move up and down at the first place.
   
### Feature 3: WASD Control and Mouse Click
- **Description** :
     - **WSAD Control** : Added another set of control of movement for users who prefer to use WASD instead of arrow keys.
     - **Mouse Click** : Added mouse click as an alternative for shooting so that users can have choices to see which control suits them more.

### Feature 4: Levels Addition
- **Description** :
     - **Level 2** : Added level 2 which is a normal level with more enemies to kill before proceeding.
     - **Level 3** : Added level 3 which is also a normal level with more enemies to kill before proceeding.
     - **Level 4** : Added level 4 which is the Boss Level and is also the final. A shield is implemented here for the Boss.

### Feature 5: Added Text
- **Description** :
     - **Level Text** : Added text that is showing the level users are currently playing.
     - **Kill To Proceed Text** : Added this text so that the users know how many enemies they are required to kill before proceeding to the next level.
     - **Killcount Text** : Added this text to  notify the users how many enemies have they killed and how many enemies they have to kill left to proceed to the next level.

---

## Implemented but Not Working Properly
### Feature 1: Pause Menu
- **Description**: Pause Menu is supposed to be a part of the others menus. 
- **Issues encountered**: Users can press 'P' to pause and it will be redirected to the Pause Menu. On the menu, users are supporsed to be able to resume the game or go back to main menu. Currently, only the going back to main menu function is working meanwhile the resume function is not. It keeps saying that currentLevel is null from the debugging steps I had done.
- **Attempts to Fix** : As mentioned, I did some debugging steps and tried to change the resume button function with just pressing the spacebar to proceed. But, this caused the whole game to not play and was bombarded with errors. So, I decided to just let the Pause Menu be not fully functional where the users can only go to the main menu.

### Feature 2: Font Style
- **Description**: A digitalfont.ttf is actually added to change the font style of the text from the levels. Location of file is `CW2024\src\main\resources\com\example\demo\font`
- **Issues encountered**: At first, I tried implementing this font before I added the menus and there was no problem at that time. But then I decided to create the menus first then edit the text. After I created the text, suddenly the game is not playable anymore. I found out that the issue is caused by the system that is trying to load the game and the text at the same time which causes the system to be jammed.
- **Attempts to Fix**: I tried to implement a code that will delay the loading of text. But then, the planes didn't show, but the bullets are still on the screen from my shooting and the enemies as well. This causes me to decide to not implement the font style and just use the normal one.

---

## Features Not Implemented
### Feature 1: Sound Effects
- **Reason for Omission**: Adding sound effects was in the plan. But it was not the priority as I don't find it to be important for the game. Thus, it is not implemented due to time constraints.

### Feature 2: Power Ups
- Adding power ups was also in the plan. Personally, I think this feature is quite important as it will be more engaging for users to have power ups such us gain health, multiple bullets or double damage. Unfortunately, it was not implemented due to time constraints.

---
---

## New Java Classes
### Class 1: <Class Name>
- **Purpose**: <Brief description>
- **Location**: `<directory>/<file_name>.java`

### Class 2: <Class Name>
- **Purpose**: <Brief description>
- **Location**: `<directory>/<file_name>.java`

---

## Modified Java Classes
### Class 1: <Class Name>
- **Modifications Made**: <Describe changes>
- **Reason for Changes**: <Explain why they were necessary>

### Class 2: <Class Name>
- **Modifications Made**: <Describe changes>
- **Reason for Changes**: <Explain why they were necessary>

---
--- 

## Unexpected Problems
1. **Problem 1**:
   - **Description**: <Brief description of the issue>
   - **Resolution**: <Steps you took to address or mitigate it>
   
2. **Problem 2**:
   - **Description**: <Brief description of the issue>
   - **Resolution**: <Steps you took to address or mitigate it>

---
