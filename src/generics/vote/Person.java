package generics.vote;

public class Person implements Voter {
    private Gender gender;
    private AgeCategory ageCategory;

    public Person(Gender gender, AgeCategory ageCategory) {
        this.gender = gender;
        this.ageCategory = ageCategory;
    }

    @Override
    public Gender getGender() {
        return this.gender;
    }

    @Override
    public AgeCategory getAgeCategory() {
        return this.ageCategory;
    }
}
