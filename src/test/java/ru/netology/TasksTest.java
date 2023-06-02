package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TasksTest {
    @Test
    public void simpleTaskQueryFoundInTitle() {

        SimpleTask simpleTask = new SimpleTask(17, "Посмотреть погоду");

        boolean expected = true;
        boolean actual = simpleTask.matches("Посмотреть погоду");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void simpleTaskQueryNotFoundInTitle() {

        SimpleTask simpleTask = new SimpleTask(26, "Оплатить счета");

        boolean expected = false;
        boolean actual = simpleTask.matches("Посмотреть погоду");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void epicQueryFoundInSubtask() {

        String[] subtasks = {"Встреча в шесть", "Собрание в четыре", "Отчет в девять"};
        Epic epic = new Epic(34, subtasks);

        boolean expected = true;
        boolean actual = epic.matches("Собрание в четыре");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void epicQueryNotFoundInSubtask() {

        String[] subtasks = {"Встреча в шесть", "Собрание в четыре", "Отчет в девять"};
        Epic epic = new Epic(55, subtasks);

        boolean expected = false;
        boolean actual = epic.matches("Обед в два");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void meetingQueryFoundInTopic() {

        Meeting meeting = new Meeting(
                46,
                "Ежедневный селектор",
                "Обучение новых сотрудников",
                "В понедельник в девять утра"
        );

        boolean expected = true;
        boolean actual = meeting.matches("Ежедневный селектор");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void meetingQueryNotFoundInTopic() {

        Meeting meeting = new Meeting(
                46,
                "Ежедневный селектор",
                "Обучение новых сотрудников",
                "В понедельник в девять утра"
        );

        boolean expected = false;
        boolean actual = meeting.matches("Повышение зарплаты");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void meetingQueryFoundInProject() {

        Meeting meeting = new Meeting(
                46,
                "Ежедневный селектор",
                "Обучение новых сотрудников",
                "В понедельник в девять утра"
        );

        boolean expected = true;
        boolean actual = meeting.matches("Обучение новых сотрудников");
        Assertions.assertEquals(expected, actual);
    }

}
