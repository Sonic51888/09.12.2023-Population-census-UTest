package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

class MainTest {

    @Test
    public void kidsCounterxTest() {
        Collection<Person> persons = new ArrayList<>();
        persons.add(new Person("Ivan", "Ivanov", 4, Sex.MAN, Education.ELEMENTARY));
        persons.add(new Person("Ivan", "Ivanov", 7, Sex.MAN, Education.ELEMENTARY));
        persons.add(new Person("Ivan", "Ivanov", 74, Sex.MAN, Education.ELEMENTARY));
        persons.add(new Person("Ivan", "Ivanov", 8, Sex.MAN, Education.ELEMENTARY));
        persons.add(new Person("Ivan", "Ivanov", 45, Sex.MAN, Education.ELEMENTARY));
        int result = Main.kidsCounter(persons);
        Assertions.assertEquals(3, result);
    }

    @Test
    public void recruitSort() {
        Collection<Person> persons = new ArrayList<>();
        persons.add(new Person("Ivan", "Ivanov", 4, Sex.MAN, Education.ELEMENTARY));
        persons.add(new Person("Ivan", "Ivanof", 19, Sex.MAN, Education.ELEMENTARY));
        persons.add(new Person("Ivan", "Kurichkin", 18, Sex.MAN, Education.ELEMENTARY));
        persons.add(new Person("Ivan", "Ivanov", 18, Sex.WOMAN, Education.ELEMENTARY));
        persons.add(new Person("Ivan", "Ivanov", 45, Sex.MAN, Education.ELEMENTARY));
        persons.add(new Person("Ivan", "Klimov", 27, Sex.MAN, Education.ELEMENTARY));
        List<String> recruit = new ArrayList<>();
        recruit.add("Ivanof");
        recruit.add("Kurichkin");
        recruit.add("Klimov");
        List<String> result = Main.recruitSort(persons);

        Assertions.assertEquals(recruit, result);
    }


    @ParameterizedTest
    @MethodSource("argsProviderFactory")
    public void workersSort(Collection<Person> argument) {
        //в Person переопределил equals для сравления объектов
        List<Person> persons1Expected = new ArrayList<>();
        List<Person> persons2Expected = new ArrayList<>();
        persons1Expected.add(new Person("Ivan", "Ivanof", 19, Sex.MAN, Education.HIGHER));
        persons1Expected.add(new Person("Irina", "Ivanova", 18, Sex.WOMAN, Education.HIGHER));
        persons1Expected.add(new Person("Ivan", "Ivanov", 64, Sex.MAN, Education.HIGHER));

        persons2Expected.add(new Person("Ivan", "Ivanof", 19, Sex.MAN, Education.HIGHER));
        persons2Expected.add(new Person("Irina", "Ivanova", 18, Sex.WOMAN, Education.HIGHER));
        persons2Expected.add(new Person("Ivan", "Ivanov", 64, Sex.MAN, Education.HIGHER));
        persons2Expected.add(new Person("Ivan", "Klimov", 27, Sex.MAN, Education.HIGHER));

        Assertions.assertEquals(persons1Expected, Main.workersSort(argument));
        // пример может быть не очень удачный, но демонстрирует передачу объектов в параметризированный тест через поток
    }

    public static Stream<List<Person>> argsProviderFactory() {
        List<Person> persons1 = new ArrayList<>();
        List<Person> persons2 = new ArrayList<>();
        persons1.add(new Person("Ivan", "Ivanov", 4, Sex.MAN, Education.ELEMENTARY));
        persons1.add(new Person("Ivan", "Ivanof", 19, Sex.MAN, Education.HIGHER));
        persons1.add(new Person("Ivan", "Kurichkin", 18, Sex.MAN, Education.ELEMENTARY));
        persons1.add(new Person("Irina", "Ivanova", 18, Sex.WOMAN, Education.HIGHER));
        persons1.add(new Person("Irina", "Inna", 65, Sex.WOMAN, Education.HIGHER));
        persons1.add(new Person("Ivan", "Ivanov", 64, Sex.MAN, Education.HIGHER));
        persons1.add(new Person("Ivan", "Klimov", 27, Sex.MAN, Education.ELEMENTARY));

        persons2.add(new Person("Ivan", "Ivanov", 4, Sex.MAN, Education.ELEMENTARY));
        persons2.add(new Person("Ivan", "Ivanof", 19, Sex.MAN, Education.HIGHER));
        persons2.add(new Person("Ivan", "Kurichkin", 18, Sex.MAN, Education.ELEMENTARY));
        persons2.add(new Person("Irina", "Ivanova", 18, Sex.WOMAN, Education.HIGHER));
        persons2.add(new Person("Irina", "Inna", 65, Sex.WOMAN, Education.HIGHER));
        persons2.add(new Person("Ivan", "Ivanov", 64, Sex.MAN, Education.HIGHER));
        persons2.add(new Person("Ivan", "Klimov", 27, Sex.MAN, Education.HIGHER));
        return Stream.of(persons1, persons2);
    }
}