package ru.dropdatabase.fixcity;

import java.time.Period;
import java.util.List;

public class Author {
    String name;
    List<Petition> ownPetitions;
    List<Period> upcomingPetitions;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Petition> getOwnPetitions() {
        return ownPetitions;
    }

    public void setOwnPetitions(List<Petition> ownPetitions) {
        this.ownPetitions = ownPetitions;
    }

    public List<Period> getUpcomingPetitions() {
        return upcomingPetitions;
    }

    public void setUpcomingPetitions(List<Period> upcomingPetitions) {
        this.upcomingPetitions = upcomingPetitions;
    }
}
