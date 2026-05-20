# 🎮 Tic Tac Toe — Kotlin Desktop Edition

> *Two players. Nine squares. One winner. No mercy.*

![Kotlin](https://img.shields.io/badge/Kotlin-7F52FF?style=for-the-badge&logo=kotlin&logoColor=white)
![IntelliJ IDEA](https://img.shields.io/badge/IntelliJ_IDEA-000000?style=for-the-badge&logo=intellij-idea&logoColor=white)
![Java Swing](https://img.shields.io/badge/Java_Swing-ED8B00?style=for-the-badge&logo=java&logoColor=white)
![License](https://img.shields.io/badge/License-MIT-green?style=for-the-badge)

---

## 🕹️ What Is This?

A sleek, dark-themed **Tic Tac Toe** desktop game built with **Kotlin + Java Swing** — no frameworks, no dependencies, no nonsense. Just pure logic and a little bit of drama.

Whether you're bored at work, teaching your little sibling how to lose gracefully, or just flexing your Kotlin skills — this game has you covered.

---

## ✨ Features

| 🔥 Feature | 💬 Description |
|---|---|
| 🎯 2-Player Mode | Challenge a friend on the same machine |
| 🏆 Win Detection | Rows, columns, and diagonals — we catch them all |
| 🤝 Draw Detection | Because sometimes nobody wins |
| ✨ Winner Highlight | Winning cells light up in gold — bow down |
| 🖱️ Hover Effects | Cells glow when you hover — satisfying |
| 🔄 Restart Button | One click to erase your embarrassing loss |
| 🌙 Dark Theme | Easy on the eyes, hard on your opponent |

---

## 📁 Project Structure

```
TicTacToe/
│
├── src/
│   └── TicTacToe.kt       # The entire game — one file, all the magic
│
├── README.md              # You are here 👋
└── TicTacToe.iml          # IntelliJ project file
```

---

## 🚀 Getting Started

### Prerequisites
- IntelliJ IDEA (Community or Ultimate)
- JDK 8 or higher
- A friend to destroy at Tic Tac Toe

### Run in 3 Steps

```bash
# Step 1 — Clone or create the project
File → New Project → Kotlin → JVM | IDEA

# Step 2 — Drop the code in
src/TicTacToe.kt  ← paste the code here

# Step 3 — Launch it
Shift + F10  (or right-click → Run)
```

That's it. Seriously.

---

## 🎲 How to Play

```
1. Player X always goes first  (lucky them)
2. Click any empty cell to place your mark
3. First to get 3 in a row wins 🏆
4. If all 9 cells fill up with no winner — it's a draw 🤝
5. Hit "Restart Game" to go again (and seek revenge)
```

### Winning Combinations

```
✅ Rows          ✅ Columns       ✅ Diagonals

X | X | X        X | . | .        X | . | .
---------        X | . | .        . | X | .
. | . | .        X | . | .        . | . | X
```

---

## 🛠️ Tech Stack

```
Language  →  Kotlin
UI        →  Java Swing (built-in, zero dependencies)
IDE       →  IntelliJ IDEA
Build     →  None needed — just hit Run ▶️
```

No Gradle. No Maven. No config files. Just vibes and Kotlin.

---

## 🎨 Color Palette

| Element | Color | Hex |
|---|---|---|
| Background | Dark Navy | `#1A1A2E` |
| Cell | Deep Blue | `#16213E` |
| Cell Hover | Bright Blue | `#0F3460` |
| Player X | Red | `#E94560` |
| Player O | Green | `#48C78E` |
| Winner | Gold | `#FFD700` |

---

## 🧠 Game Logic at a Glance

```kotlin
// Win check — simple and clean
fun checkWin(): Boolean {
    // Check all rows, columns, and both diagonals
    // Returns true if currentPlayer has 3 in a row
}

// Draw check — if board is full and no winner
fun checkDraw() = board.all { row -> row.all { it != null } }
```

---

## 🗺️ Roadmap (Future Ideas)

- [ ] 🤖 Add AI opponent (single-player mode)
- [ ] 🔊 Sound effects on click and win
- [ ] 🏅 Score tracker across rounds
- [ ] 🎨 Custom player names and colors
- [ ] 💾 Save game history to a file
- [ ] 🌐 Online multiplayer (big dream, why not)

---

## 🐛 Known Issues

- None so far. It just works. 😎
- If you find a bug, congrats — you played yourself.

---

## 🤝 Contributing

Got ideas? Found a bug? Want to add an AI that beats everyone?

1. Fork the repo
2. Create a branch: `git checkout -b feature/cool-thing`
3. Commit your changes: `git commit -m "Added cool thing"`
4. Push: `git push origin feature/cool-thing`
5. Open a Pull Request 🎉

---

## 📜 License

MIT License — do whatever you want with it.
Just don't claim you invented Tic Tac Toe.

---

## 👨‍💻 Author

Built with ☕ and Kotlin.

> *"In a world full of complex problems, sometimes all you need is a 3x3 grid."*

---

⭐ **If this made you smile, drop a star. If it made you lose, practice more.**
