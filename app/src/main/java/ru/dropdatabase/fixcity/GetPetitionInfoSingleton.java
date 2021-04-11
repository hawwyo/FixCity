package ru.dropdatabase.fixcity;

public class GetPetitionInfoSingleton {
    private static getPetition petitionInfo;

    public static getPetition getInstanceOf() {
        if (petitionInfo == null) {
            petitionInfo = new GetPetitionDAO();
        }

        return petitionInfo;
    }
}
