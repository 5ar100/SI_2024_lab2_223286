# Втора лабораториска вежба по Софтверско инженерство
## Петар Стојановски, 223286
### Control Flow Graph
![Control Flow Graph](https://github.com/5ar100/SI_2024_lab2_223286/blob/master/CFG1_fixed.png)
![](https://github.com/5ar100/SI_2024_lab2_223286/blob/master/CFG2_fixed.png)
### Цикломатска комплексност
- Цикломатската комплексност ја најдов според бројот на If statements + 1. Цикломатската комплексност е 10.
### Every Branch
![Every Branch](https://github.com/5ar100/SI_2024_lab2_223286/blob/master/EveryBranch.png)
### Multiple Condition
![Multiple Condition](https://github.com/5ar100/SI_2024_lab2_223286/blob/master/Multiple%20Condition.png)
### Unit Testing
- За првото тестирање за секоја гранка искористив 5 asserts, 3 за RuntimeExceptions-от и 2 каде што во едниот assert функцијата е true, а во другата false.
- За Multiple Condition тестирањето го поделив if-statement-от на 3 делови и со користење на assertTrue() или assertFalse() ги тестирав сите исходи - TTT, TTF, TFX, FXX
