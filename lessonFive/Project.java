package org.example.lessonFive;

class Project {
    private String name;
    private int duration;

    // Конструктор и геттеры
    public Project(String name, int duration) {
        this.name = name;
        this.duration = duration;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}
