package ru.netology;

class Person {
    private String name;
    private String family;
    private Integer age;
    private Sex sex;
    private Education education;

    public Person(String name, String family, int age, Sex sex, Education education) {
        this.name = name;
        this.family = family;
        this.age = age;
        this.sex = sex;
        this.education = education;
    }

    public String getName() {
        return name;
    }

    public String getFamily() {
        return family;
    }

    public Integer getAge() {
        return age;
    }

    public Sex getSex() {
        return sex;
    }

    public Education getEducation() {
        return education;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", family='" + family + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                ", education=" + education +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {return true;};
        if (obj == null || getClass() != obj.getClass()) return false;
        Person that = (Person) obj;
        return age.equals(that.age) &&
                family.equals(that.family)&&
                name.equals(that.name)&&
                sex.equals(that.sex)&&
                education.equals(that.education);
    }
}