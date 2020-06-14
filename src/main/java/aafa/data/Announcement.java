package aafa.data;

public class Announcement {
    private String owner=" . ";
    private String species=" . ";
    private String age=" . ";
    private String medicalStatus=" . ";
    private String address=" . ";
    private String pathPhoto=" ";

    public Announcement() {
    }

    public Announcement(String owner, String species, String age, String medicalStatus, String address, String pathPhoto) {
        this.owner = owner;
        this.species = species;
        this.age = age;
        this.medicalStatus = medicalStatus;
        this.address = address;
        this.pathPhoto = pathPhoto;
    }

    public String getOwner() {
        return owner;
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
    public String getAddress() {
        return address;
    }
    public String getPathPhoto() {
        return pathPhoto;
    }

}
