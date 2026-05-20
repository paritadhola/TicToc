import java.awt.*
import java.awt.event.ActionEvent
import javax.swing.*

fun main() {
    SwingUtilities.invokeLater { TicTacToeGame() }
}

class TicTacToeGame : JFrame("Tic Tac Toe") {

    private val board = Array(3) { arrayOfNulls<String>(3) }
    private val cells = Array(3) { arrayOfNulls<JButton>(3) }
    private var currentPlayer = "X"
    private var gameOver = false

    private val statusLabel = JLabel("Player X's Turn", SwingConstants.CENTER)
    private val restartButton = JButton("Restart Game")

    // Colors
    private val bgColor       = Color(26, 26, 46)
    private val cellColor     = Color(22, 33, 62)
    private val cellHover     = Color(15, 52, 96)
    private val xColor        = Color(233, 69, 96)
    private val oColor        = Color(72, 199, 142)
    private val winColor      = Color(255, 215, 0)
    private val textColor     = Color(224, 224, 224)
    private val restartColor  = Color(233, 69, 96)

    init {
        defaultCloseOperation = EXIT_ON_CLOSE
        preferredSize = Dimension(420, 520)
        layout = BorderLayout(10, 10)
        getContentPane().background = bgColor

        setupStatusLabel()
        setupGrid()
        setupRestartButton()

        pack()
        setLocationRelativeTo(null)
        isVisible = true
    }

    private fun setupStatusLabel() {
        statusLabel.apply {
            font = Font("Segoe UI", Font.BOLD, 22)
            foreground = textColor
            background = bgColor
            isOpaque = true
            border = BorderFactory.createEmptyBorder(20, 10, 10, 10)
        }
        add(statusLabel, BorderLayout.NORTH)
    }

    private fun setupGrid() {
        val gridPanel = JPanel(GridLayout(3, 3, 8, 8)).apply {
            background = bgColor
            border = BorderFactory.createEmptyBorder(10, 20, 10, 20)
        }

        for (row in 0..2) {
            for (col in 0..2) {
                val cell = JButton("").apply {
                    font = Font("Segoe UI", Font.BOLD, 52)
                    background = cellColor
                    foreground = textColor
                    isFocusPainted = false
                    border = BorderFactory.createLineBorder(Color(30, 45, 80), 2)
                    cursor = Cursor(Cursor.HAND_CURSOR)

                    // Hover effect
                    addMouseListener(object : java.awt.event.MouseAdapter() {
                        override fun mouseEntered(e: java.awt.event.MouseEvent) {
                            if (text.isEmpty() && !gameOver) background = cellHover
                        }
                        override fun mouseExited(e: java.awt.event.MouseEvent) {
                            if (text.isEmpty()) background = cellColor
                        }
                    })

                    addActionListener { onCellClick(row, col) }
                }
                cells[row][col] = cell
                gridPanel.add(cell)
            }
        }

        add(gridPanel, BorderLayout.CENTER)
    }

    private fun setupRestartButton() {
        val bottomPanel = JPanel().apply {
            background = bgColor
            border = BorderFactory.createEmptyBorder(5, 20, 20, 20)
        }

        restartButton.apply {
            font = Font("Segoe UI", Font.BOLD, 16)
            background = restartColor
            foreground = Color.WHITE
            isFocusPainted = false
            border = BorderFactory.createEmptyBorder(12, 30, 12, 30)
            cursor = Cursor(Cursor.HAND_CURSOR)
            isContentAreaFilled = true

            addActionListener { resetGame() }
        }

        bottomPanel.add(restartButton)
        add(bottomPanel, BorderLayout.SOUTH)
    }

    private fun onCellClick(row: Int, col: Int) {
        if (gameOver || board[row][col] != null) return

        board[row][col] = currentPlayer
        cells[row][col]?.apply {
            text = currentPlayer
            foreground = if (currentPlayer == "X") xColor else oColor
        }

        when {
            checkWin() -> {
                statusLabel.text = "🎉 Player $currentPlayer Wins!"
                gameOver = true
                highlightWinner()
            }
            checkDraw() -> {
                statusLabel.text = "🤝 It's a Draw!"
                gameOver = true
            }
            else -> {
                currentPlayer = if (currentPlayer == "X") "O" else "X"
                statusLabel.text = "Player $currentPlayer's Turn"
            }
        }
    }

    private fun checkWin(): Boolean {
        for (i in 0..2) {
            if (board[i][0] == currentPlayer && board[i][1] == currentPlayer && board[i][2] == currentPlayer) return true
            if (board[0][i] == currentPlayer && board[1][i] == currentPlayer && board[2][i] == currentPlayer) return true
        }
        if (board[0][0] == currentPlayer && board[1][1] == currentPlayer && board[2][2] == currentPlayer) return true
        if (board[0][2] == currentPlayer && board[1][1] == currentPlayer && board[2][0] == currentPlayer) return true
        return false
    }

    private fun checkDraw() = board.all { row -> row.all { it != null } }

    private fun highlightWinner() {
        // Rows
        for (i in 0..2) {
            if (board[i].all { it == currentPlayer }) {
                for (j in 0..2) cells[i][j]?.background = winColor; return
            }
            if ((0..2).all { board[it][i] == currentPlayer }) {
                for (j in 0..2) cells[j][i]?.background = winColor; return
            }
        }
        // Diagonals
        if ((0..2).all { board[it][it] == currentPlayer }) {
            for (i in 0..2) cells[i][i]?.background = winColor; return
        }
        if ((0..2).all { board[it][2 - it] == currentPlayer }) {
            for (i in 0..2) cells[i][2 - i]?.background = winColor
        }
    }

    private fun resetGame() {
        for (row in 0..2) for (col in 0..2) {
            board[row][col] = null
            cells[row][col]?.apply {
                text = ""
                background = cellColor
            }
        }
        currentPlayer = "X"
        gameOver = false
        statusLabel.text = "Player X's Turn"
    }
}