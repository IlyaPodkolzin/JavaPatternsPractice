package pract2.company;
import pract2.classes.Human;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        List<Human> humanList = new ArrayList<>();
        humanList.add(new Human(12, "Andrey", "Mirov", LocalDate.of(2012, 2, 10), 64));
        humanList.add(new Human(22, "Nikolay", "Borov", LocalDate.of(2001, 6, 12), 84));
        humanList.add(new Human(29, "Alexander", "Nevskii", LocalDate.of(1995, 1, 21), 95));
        humanList.add(new Human(19, "Vlad", "Indirchiev", LocalDate.of(2004, 5, 12), 78));
        humanList.add(new Human(19, "Ilya", "Morozov", LocalDate.of(2004, 4, 14), 76));
        humanList.add(new Human(23, "Artyom", "Maltzev", LocalDate.of(2000, 9, 29), 68));
        humanList.add(new Human(13, "Dennis", "Sokol", LocalDate.of(2010, 12, 31), 53));

        Stream<Human> humanStream = humanList.stream();
        System.out.print("Начальное состояние:\n");
        humanStream.forEach(human -> System.out.println(human + ", "));


        Stream<Human> humanStream2 = humanList.stream();
        System.out.print("\nУвеличение веса каждого объекта на 3:\n");
        humanStream2.peek(human -> human.setWeight(human.getWeight() + 3)).forEach(human -> System.out.println(human + ", "));


        Stream<Human> humanStream3 = humanList.stream();
        System.out.print("\nСортировка по весу в обратном порядке:\n");
        humanStream3.sorted(Comparator.comparingInt(Human::getWeight).reversed()).forEach(human -> System.out.println(human + ", "));


        Stream<Human> humanStream4 = humanList.stream();
        System.out.print("\nФильтрация по дате рождения меньшей, чем 01.01.2000:\n");
        humanStream4.filter(human -> {
            return human.getBirthDate().compareTo(LocalDate.of(2000, 1, 1)) < 0;
        }).forEach(human -> System.out.println(human + ", "));


        Stream<Human> humanStream5 = humanList.stream();
        System.out.print("\nСумма всех весов:\n" + humanStream5.map(Human::getWeight).reduce(Integer::sum).get());
    }
}
