package ru.dropdatabase.fixcity;

public class GetPetitionInfoSingleton {
    private static getPetitionInfo petitionInfo;

    public static getPetitionInfo getInstanceOf() {
        if (petitionInfo == null) {
            petitionInfo = new GetPetitionDAO();
        }

        return petitionInfo;
    }
}
