package Objects;

public class Contract {

    private int contractNR;
    private Student tenant;
    private Landlord owner;
    private static int ID = 0;

    public Contract(Student student, Landlord landlord){
        this.tenant = student;
        this.owner = landlord;
        this.contractNR = ID+1;
        ID++;
    }

    public int getContractNR() {
        return contractNR;
    }

    public void setContractNR(int contractNR) {
        this.contractNR = contractNR;
    }

    public Student getTenant() {
        return tenant;
    }

    public void setTenant(Student tenant) {
        this.tenant = tenant;
    }

    public Landlord getOwner() {
        return owner;
    }

    public void setOwner(Landlord owner) {
        this.owner = owner;
    }
}

