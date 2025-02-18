# 🎮 Snap - A Two-Player Java Card Game

### 🔹 A CLI-based multiplayer **Snap** game built in Java, featuring **reaction-based gameplay, deck management, sorting, shuffling, and replay functionality**.

![Java](https://img.shields.io/badge/Language-Java-blue.svg) ![GitHub](https://img.shields.io/badge/Version-1.0-green.svg) ![Status](https://img.shields.io/badge/Status-Completed-success.svg)

---

## 📌 **Project Overview**
Snap is a classic card game where **two players take turns drawing cards** until a **'SNAP' match occurs** (i.e., two consecutive cards of the same rank). Players must **type 'snap' within 2 seconds** to win the round. The first player to **win 3 rounds** is declared the **final winner**.

---

## 🚀 **Features**
- ✅ **Two-player turn-based gameplay**
- ✅ **Fast reaction-based SNAP challenge** (2-second time limit)
- ✅ **Deck management** (shuffling, sorting by value, sorting by suit)
- ✅ **Replay functionality** (rematch option after each game) with a 
  match-winning system
- ✅ **Clear, structured CLI output for better user experience**
- ✅ **Robust error handling to prevent crashes**
- ✅ **Fully modular OOP design with best practices**

---

## 🛠 **Technologies Used**
- **Java 17+**
- **Object-Oriented Programming (OOP)**
- **Collections Framework (ArrayList, Sorting, Shuffling)**
- **Java Enums** for better deck structure
- **Java I/O** (for handling player input)
- **Git & GitHub** for version control

---

## 🏗 **Project Structure**
```
📂 java-snap-game 
│── 📂 src
│ └── 📂 elias.snap
│ │── 📄 Card.java
│ │── 📄 CardGame.java
│ │── 📄 Main.java
│ │── 📄 Snap.java
│ │── 📄 Suit.java
│ │── 📄 Value.java
│── 📄 .gitignore
│── 📄 pseudocode.md
│── 📄 README.md
```

---

## 🖥️ **How to Run the Game Locally**
1. Clone the repository
   - For HTTPS:
     ```
     git clone https://github.com/3ixas/java-snap-game.git
     ```
   - For SSH:
     ```
      git clone git@github.com:3ixas/java-snap-game.git
      ```
   
2. Go to the project folder
    ```
   cd snap-game
   ```

3. Compile & run the Java files
   - Option 1: Run in an IDE
     - Open the project in IntelliJ (recommended) or VS Code
     - Run Main.java
    
   - Option 2: Run via terminal
     ```
     javac -d out src/elias/snap/*.java
     java -cp out elias.snap.Main
      ```

---

## 🎲 **How to Play**
- The game will prompt Player 1 and Player 2 to take turns drawing a card.
- If two consecutive cards match, a SNAP challenge appears.
- Type "snap" within 2 seconds to win the round!
- The first player to win 3 rounds becomes the final winner.
- If the deck runs out of cards before a player wins, the game ends in a draw.
- At the end of a match, you can choose to play again or exit the game.

---

## 📚 **Lessons Learned**
- **Applied SOLID Principles** – Used Encapsulation, Inheritance, and Single Responsibility Principle (SRP).
- **Optimised Sorting & Data Structures** – Used ArrayLists, Java Enums, and 
  efficient Comparators.
- **Handling Asynchronous Input in Java** – Implemented timed input detection 
  to simulate reaction-based gameplay.
- **Code Refactoring & Clean Design** – Improved method extraction, readability,
  and maintainability.

---

## 🌟 **Future Improvements**
- **AI Opponent** – Add a single-player mode with an AI that plays against the user.
- **Custom Game Rules** – Allow players to set their own winning conditions or time limits.

---

### 🛠 **Developed by Elias**