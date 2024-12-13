# COMP2042 - Developing Maintainable Software

# <ins> GitHub: </ins>

[CW2024 - Nuhaa Jaffar](<https://github.com/nuhaajaffar/CW2024.git>)

---
---

# <ins> Compilation Instructions </ins>

## 1. Prerequisites  

Before you begin, ensure the following tools and dependencies are set up:

- **Java Development Kit (JDK)** version **19 (or above)** with **JavaFX** support.  
- **Apache Maven** for dependency management and the build process.  
- **(Optional)** An Integrated Development Environment (IDE) like [IntelliJ IDEA](https://www.jetbrains.com/idea/).  
- **(Optional)** `git` to clone the repository directly.  

## 2. Clone the Repository  

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

## 3. Build and Run  

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

# <ins> Implemented and Working Properly </ins>

### Feature 1 : Menu
- **Description** :
     - **Main Menu** : The menu that users will see as they launch the game. From this menu, users can go to How To Play Menu to view the instructions on how to play the game. They can come back to the main menu and click on Play to proceed to Level 1.
     - **How To Play Menu** : The menu that users can view the instructions of the game.
     - **Win Menu** : The menu that will appear when the users had won and finishes the game, offering an option to replay the game from Level 1 (Users can also press spacebar to proceed) or return to main menu.
     - **Game Over Menu** : The menu that will appear when the users are defeated, offering an option to replay the game from Level 1 (Users can also press spacebar to proceed) or return to main menu.

### Feature 2 : Plane Left and Right Movement
- **Description** :
     - **Arrow Left and Right** : Users can move to the left and right which is an additional where they can only move up and down at the first place.
   
### Feature 3 : WASD Control and Mouse Click
- **Description** :
     - **WSAD Control** : Added another set of control of movement for users who prefer to use WASD instead of arrow keys.
     - **Mouse Click** : Added mouse click as an alternative for shooting so that users can have choices to see which control suits them more.

### Feature 4 : Levels Addition
- **Description** :
     - **Level 2** : Added level 2 which is a normal level with more enemies to kill before proceeding to the next level.
     - **Level 3** : Added level 3 which is also a normal level with more enemies to kill before proceeding to the next level. And also, this level has more enemies approaching compared to Level 1 and Level 2.
     - **Level 4** : Added level 4 which is the Boss Level and is also the final. A shield is implemented here for the Boss.

### Feature 5 : Added Text
- **Description** :
     - **Level Text** : Added text that is showing the level users are currently playing.
     - **Kill To Proceed Text** : Added this text so that the users know how many enemies they are required to kill before proceeding to the next level.
     - **Killcount Text** : Added this text to  notify the users how many enemies have they killed and how many enemies they have to kill left to proceed to the next level.

---
---

# <ins> Implemented but Not Working Properly </ins>

### Feature 1 : Pause Menu
- **Description**: Pause Menu is supposed to be a part of the others menus. 
- **Issues encountered**: Users can press 'P' to pause and it will be redirected to the Pause Menu. On the menu, users are supporsed to be able to resume the game or go back to main menu. Currently, only the going back to main menu function is working meanwhile the resume function is not. It keeps saying that currentLevel is null from the debugging steps I had done.
- **Attempts to Fix** : As mentioned, I did some debugging steps and tried to change the resume button function with just pressing the spacebar to proceed. But, this caused the whole game to not play and was bombarded with errors. So, I decided to just let the Pause Menu be not fully functional where the users can only go to the main menu.

### Feature 2 : Font Style
- **Description**: A digitalfont.ttf is actually added to change the font style of the text from the levels. Location of file is `CW2024\src\main\resources\com\example\demo\font\digitalfont.ttf`
- **Issues encountered**: At first, I tried implementing this font before I added the menus and there was no problem at that time. But then I decided to create the menus first then edit the text. After I created the text, suddenly the game is not playable anymore. I found out that the issue is caused by the system that is trying to load the game and the text at the same time which causes the system to be jammed.
- **Attempts to Fix**: I tried to implement a code that will delay the loading of text. But then, the planes didn't show, but the bullets are still on the screen from my shooting and the enemies as well. This causes me to decide to not implement the font style and just use the normal one.

---
---

# <ins> Features Not Implemented </ins>

### Feature 1 : Sound Effects
- **Reason for Omission**: Adding sound effects was in the plan. But it was not the priority as I don't find it to be important for the game. Thus, it is not implemented due to time constraints.

### Feature 2 : Power Ups
- Adding power ups was also in the plan. Personally, I think this feature is quite important as it will be more engaging for users to have power ups such us gain health, multiple bullets or double damage. Unfortunately, it was not implemented due to time constraints.

---
---

# <ins> New Java Classes </ins>

## _levels package_

### Class 1: LevelFour
- **Purpose**: Added level 4 which is the Boss Level and is also the final. A shield is implemented for the Boss.
- **Location**: `com/example/demo/levels/LevelFour.java`

### Class 2: LevelThree
- **Purpose**: Added level 3 which is also a normal level with more enemies to kill before proceeding to the next level. And also, this level has more enemies approaching compared to Level 1 and Level 2.
- **Location**: `com/example/demo/levels/LevelThree.java`




### Class 2: <Class Name>
- **Purpose**: <Brief description>
- **Location**: `<directory>/<file_name>.java`

---
---

# <ins> Modified Java Classes </ins>

## _actors package_

### Class 1 : ActiveActor
1. **Modifications Made** : Refactored the class into actors package.
   - **Reason for Changes** : For better organization of actor-related classes.

### Class 2 : BossPlane
1. **Modifications Made** : Refactored the class into actors package.
   - **Reason for Changes** : For better organization of actor-related classes.

2. **Modifications Made** : Hitbox implementations.
   - **Reason for Changes** : To improve the target accuracy because it was hitting the whole image of BossPlane.

3. **Modifications Made** : Calling updateHitbox() to updatePostion().
   - **Reason for Changes** : Ensure the hitbox is always updated as the BossPlane moves.

4. **Modifications Made** : Adjusted the upper bound.
   - **Reason for Changes** : Ensure the BossPlane doesn't reach the heart display and text.
    
5. **Modifications Made** : Changed() isShielded to public.
   - **Reason for Changes** : To be able to implement the shield activation and deactivation.
   
### Class 3 : EnemyPlane
1. **Modifications Made** : Refactored the class into actors package.
   - **Reason for Changes** : For better organization of actor-related classes.

2. **Modifications Made** : Hitbox implementations.
   - **Reason for Changes** : To improve the target accuracy because it was hitting the whole image of EnemyPlane.

3. **Modifications Made** : Calling updateHitbox() to updatePostion().
   - **Reason for Changes** : Ensure the hitbox is always updated as the EnemyPlane moves.   

### Class 4 : FighterPlane
1. **Modifications Made** : Refactored the class into actors package.
   - **Reason for Changes** : For better organization of actor-related classes.

### Class 5 : UserPlane
1. **Modifications Made** : Refactored the class into actors package.
   - **Reason for Changes** : For better organization of actor-related classes.

2. **Modifications Made** : Added left and right movement.
   - **Reason for Changes** : For enhancing gameplay and engaging users.

3. **Modifications Made** : Added WASD for movement and mouse click for shooting.
   - **Reason for Changes** : For enhancing gameplay and engaging users.

4. **Modifications Made** : Hitbox implementations.
   - **Reason for Changes** : To improve the target accuracy because it was hitting the whole image of UserPlane.

5. **Modifications Made** : Calling updateHitbox() to updatePostion().
   - **Reason for Changes** : Ensure the hitbox is always updated as the UserPlane moves.

6. **Modifications Made** : Adjusted the upper bound.
   - **Reason for Changes** : Ensure the UserPlane doesn't reach the heart display and text.      


## _controller package_

### Class 6 : Controller
1. **Modifications Made** : Added goToMenu() for menu implementation.
   - **Reason for Changes** : To be able to tarnsition to all menus.

2. **Modifications Made** : Added implementation of redirecting to Pause Menu.
   - **Reason for Changes** : For enhancing gameplay and engaging users.   

### Class 7 : Main
1. **Modifications Made** : Add try and catch method for Main.
   - **Reason for Changes** : There was an issue to launch the game, hence the method is used.


## _destructibles package_

### Class 8 : ActiveActorDestructible
1. **Modifications Made** : Refactored the class into destructibles package.
   - **Reason for Changes** : For better organization of destructibles-related classes.

### Class 9 : Destructible
1. **Modifications Made** : Refactored the class into destructibles package.
   - **Reason for Changes** : For better organization of destructibles-related classes.


## _levels package_

### Class 10 : LevelOne
1. **Modifications Made** : Refactored the class into levels package.
   - **Reason for Changes** : For better organization of levels-related classes.

2. **Modifications Made** : Added Level 1 text on the display.
   - **Reason for Changes** : For enhancing gameplay and engaging users. 

3. **Modifications Made** : Added Kill To Proceed text on the display.
   - **Reason for Changes** : For enhancing gameplay and engaging users. 

4. **Modifications Made** : Added Kill Count text on the display.
   - **Reason for Changes** : For enhancing gameplay and engaging users.

### Class 11 : LevelParent 
1. **Modifications Made** : Refactored the class into levels package.
   - **Reason for Changes** : For better organization of levels-related classes.

2. **Modifications Made** : Added goToMenu() for menu implementation.
   - **Reason for Changes** : To be able to tarnsition to WinMenu and GameOverMenu.

3. **Modifications Made** : Added left and right movement.
   - **Reason for Changes** : For enhancing gameplay and engaging users.

4. **Modifications Made** : Added WASD for movement and mouse click for shooting.
   - **Reason for Changes** : For enhancing gameplay and engaging users.
   
5. **Modifications Made** : Added timeline.pause();
   - **Reason for Changes** : Ensuring the users to be able to pause the game.

### Class 12 : LevelTwo 
1. **Modifications Made** : Refactored the class into levels package.
   - **Reason for Changes** : For better organization of levels-related classes.

2. **Modifications Made** : Added Level 2 text on the display.
   - **Reason for Changes** : For enhancing gameplay and engaging users. 

3. **Modifications Made** : Added Kill To Proceed text on the display.
   - **Reason for Changes** : For enhancing gameplay and engaging users. 

4. **Modifications Made** : Added Kill Count text on the display.
   - **Reason for Changes** : For enhancing gameplay and engaging users.

### Class 13 : LevelView 
1. **Modifications Made** : Refactored the class into levels package.
   - **Reason for Changes** : For better organization of levels-related classes.

### Class 14 : LevelViewBoss 
1. **Modifications Made** : Refactored the class into levels package.
   - **Reason for Changes** : For better organization of levels-related classes.


## _projectiles package_

### Class 15 : BossProjectile 
1. **Modifications Made** : Refactored the class into projectiles package.
   - **Reason for Changes** : For better organization of projectiles-related classes.

2. **Modifications Made** : Hitbox implementations.
   - **Reason for Changes** : To improve the target accuracy because it was hitting the whole image of BossProjectile.

3. **Modifications Made** : Calling updateHitbox() to updatePostion().
   - **Reason for Changes** : Ensure the hitbox is always updated as the BossProjectile moves.  

### Class 16 : EnemyProjectile 
1. **Modifications Made** : Refactored the class into projectiles package.
   - **Reason for Changes** : For better organization of projectiles-related classes.

2. **Modifications Made** : Hitbox implementations.
   - **Reason for Changes** : To improve the target accuracy because it was hitting the whole image of EnemyProjectile.

3. **Modifications Made** : Calling updateHitbox() to updatePostion().
   - **Reason for Changes** : Ensure the hitbox is always updated as the EnemyProjectile moves.

### Class 17 : Projectile 
1. **Modifications Made** : Refactored the class into projectiles package.
   - **Reason for Changes** : For better organization of projectiles-related classes.

### Class 18 : UserProjectile 
1. **Modifications Made** : Refactored the class into projectiles package.
   - **Reason for Changes** : For better organization of projectiles-related classes.

2. **Modifications Made** : Hitbox implementations.
   - **Reason for Changes** : To improve the target accuracy because it was hitting the whole image of UserProjectile.

3. **Modifications Made** : Calling updateHitbox() to updatePostion().
   - **Reason for Changes** : Ensure the hitbox is always updated as the UserProjectile moves.


## _ui package_

### Class 19 : HeartDisplay 
1. **Modifications Made** : Refactored the class into ui package.
   - **Reason for Changes** : For better organization of ui-related classes.

### Class 20 : ShieldImage 
1. **Modifications Made** : Refactored the class into ui package.
   - **Reason for Changes** : For better organization of ui-related classes.

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
