package domain;

public class Client {
    private int idClient; 
    private String name; 
    private String lastName; 
    private String email; 
    private String phone; 
    private double balance; 
    
    public Client(){
    
    }
    
    public Client(int idClient){
        this.idClient = idClient; 
    }
    
    public Client(int idClient, String name, String lastName, String email, String phone, double balance){
        this.idClient = idClient; 
        this.name = name; 
        this.lastName = lastName;
        this.email = email; 
        this.phone = phone; 
        this.balance = balance; 
    }
    
    public Client(String name, String lastName, String email, String phone, double balance){
        this.name = name; 
        this.lastName = lastName;
        this.email = email; 
        this.phone = phone; 
        this.balance = balance; 
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Client{" + "idClient=" + idClient + ", name=" + name + ", lastName=" + lastName + ", email=" + email + ", phone=" + phone + ", balance=" + balance + '}';
    }
    
    
}
