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
    public String getPathPhoto() { return pathPhoto;   }

    public void setOwner(String owner) {
        this.owner = owner;
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

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPathPhoto(String pathPhoto) {
        this.pathPhoto = pathPhoto;
    }
}
