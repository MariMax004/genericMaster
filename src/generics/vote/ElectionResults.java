package generics.vote;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ElectionResults {
    private Map<Candidate, List<Person>> voteResults;

    public ElectionResults(Map<Candidate, List<Person>> voteResults) {
        this.voteResults = voteResults;
    }


    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();

        for (Map.Entry<Candidate, List<Person>> entry : voteResults.entrySet()) {
            Candidate candidate = entry.getKey();
            List<Person> voters = entry.getValue();

            result.append("За кандидата ").append(candidate.getName()).append(" проголосовали: ");
            Map<Gender, Double> genderPercentage = distributeByGender(voters);
            Map<AgeCategory, Double> agePercentage = distributeByAge(voters);

            result.append("Гендерное распределение: ").append(System.lineSeparator());
            result.append("Мужчины: ").append(genderPercentage.containsKey(Gender.MALE) ? genderPercentage.get(Gender.MALE) : 0).append(" % " + System.lineSeparator());
            result.append("Женщины: ").append(genderPercentage.containsKey(Gender.FEMALE) ? genderPercentage.get(Gender.FEMALE) : 0).append(" % " + System.lineSeparator());

            result.append("Возрастное распределение: ").append(System.lineSeparator());
            result.append("18 - 29: ").append(agePercentage.containsKey(AgeCategory.FROM_18_TO_29) ? agePercentage.get(AgeCategory.FROM_18_TO_29) : 0).append(" % " + System.lineSeparator());
            result.append("30 - 49: ").append(agePercentage.containsKey(AgeCategory.FROM_30_TO_49) ? agePercentage.get(AgeCategory.FROM_30_TO_49) : 0).append(" % " + System.lineSeparator());
            result.append("50 - 64: ").append(agePercentage.containsKey(AgeCategory.FROM_50_TO_64) ? agePercentage.get(AgeCategory.FROM_50_TO_64) : 0).append(" % " + System.lineSeparator());
            result.append("65 и выше: ").append(agePercentage.containsKey(AgeCategory.FROM_65) ? agePercentage.get(AgeCategory.FROM_65) : 0).append(" % " + System.lineSeparator());
        }
        return result.toString();
    }

    private Map<Gender, Double> distributeByGender(List<Person> allPeople) {
        Map<Gender, Double> genderMap = new HashMap<>();
        Integer sumCount = 0;

        for (Person person : allPeople) {
            Gender gender = person.getGender();
            genderMap.put(gender, genderMap.getOrDefault(gender, 0d) + 1);
            sumCount++;
        }
        for (Map.Entry<Gender, Double> entry : genderMap.entrySet()) {
            Gender key = entry.getKey();
            genderMap.put(key, getInPercentage(entry.getValue(), sumCount));
        }
        return genderMap;
    }

    private Map<AgeCategory, Double> distributeByAge(List<Person> allPeople) {
        Map<AgeCategory, Double> ageMap = new HashMap<>();
        Integer sumCount = 0;

        for (Person person : allPeople) {
            AgeCategory ageCategory = person.getAgeCategory();
            ageMap.put(ageCategory, ageMap.getOrDefault(ageCategory, 0d) + 1);
            sumCount++;
        }
        for (Map.Entry<AgeCategory, Double> entry : ageMap.entrySet()) {
            AgeCategory key = entry.getKey();
            ageMap.put(key, getInPercentage(entry.getValue(), sumCount));
        }
        return ageMap;
    }

    private Double getInPercentage(Double count, Integer sumCount) {
        BigDecimal bd = new BigDecimal((count * 100) / sumCount);
        bd = bd.setScale(2, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
}
