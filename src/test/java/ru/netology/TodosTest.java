package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TodosTest {

    @Test
    public void shouldAddThreeTasksOfDifferentType() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {simpleTask, epic, meeting};
        Task[] actual = todos.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void TodosLuckySearch() {

        SimpleTask simpleTask = new SimpleTask(17, "Посмотреть погоду");

        String[] subtasks = {"Встреча в шесть", "Собрание в четыре", "Отчет в девять"};
        Epic epic = new Epic(34, subtasks);

        Meeting meeting = new Meeting(
                46,
                "Ежедневный селектор",
                "Обучение новых сотрудников",
                "В понедельник в девять утра"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {meeting};
        Task[] actual = todos.search("Ежедневный селектор");
        ;
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void TodosUnsuccessfulSearch() {

        SimpleTask simpleTask = new SimpleTask(17, "Посмотреть погоду");

        String[] subtasks = {"Встреча в шесть", "Собрание в четыре", "Отчет в девять"};
        Epic epic = new Epic(34, subtasks);

        Meeting meeting = new Meeting(
                46,
                "Ежедневный селектор",
                "Обучение новых сотрудников",
                "В понедельник в девять утра"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {};
        Task[] actual = todos.search("Вторник восемь часов");
        ;
        Assertions.assertArrayEquals(expected, actual);
    }


}
