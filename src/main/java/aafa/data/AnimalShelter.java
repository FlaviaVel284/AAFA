package aafa.data;

public class AnimalShelter {
    private String species=" . ";
    private String age=" . ";
    private String medicalStatus=" . ";

    public AnimalShelter(){ }

    public AnimalShelter(String species, String age, String medicalStatus) {
        this.species = species;
        this.age = age;
        this.medicalStatus = medicalStatus;
    }

    public String getSpecies() {
        return species;
    }

    public String getAge() {
        return age;
    }

    public String getMedicalStatus() {
        return medicalStatus;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public void setMedicalStatus(String medicalStatus) {
        this.medicalStatus = medicalStatus;
    }
}
