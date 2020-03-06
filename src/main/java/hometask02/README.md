# Yaroslav Yakubovskiy

# hometask02 
person

Лабораторная к 2-му занятию
 

## Реализовать методы Person по java докам, запушить в github, прислать мне ссылку
 
```java
public class Person {
    private final boolean man;
    private final String name;
    private Person spouse;
 
    public Person(boolean man, String name) {
        this.man = man;
        this.name = name;
    }
 
    /**
     * This method checks gender of persons. If genders are not equal - tries to marry.
     * If one of them has another spouse - execute divorce(sets spouse = null for husband and wife. Example: if both persons have spouses - then divorce will set 4 spouse to null) and then executes marry().
     * @param person - new husband/wife for this person.
     * @return - returns true if this person has another gender than passed person and they are not husband and wife, false otherwise
     */
    public boolean marry(Person person) {
        //...
    }
 
    /**
     * Sets spouse = null if spouse is not null
     * @return true - if person status has been changed
     */
    public boolean divorce() {
    }
}
```

// asdfadsfds



