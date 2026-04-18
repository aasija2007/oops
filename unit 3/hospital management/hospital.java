import java.util.*;
public class Solution {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter patient name:");
        String name = sc.nextLine();

        System.out.println("Enter age:");
        int age = sc.nextInt();
        sc.nextLine();

        System.out.println("Enter disease:");
        String disease = sc.nextLine();

        System.out.println("Enter patient type (normal/critical):");
        String type = sc.nextLine();

        if (type.equalsIgnoreCase("critical")) {

            System.out.println("Enter room number:");
            int roomNumber = sc.nextInt();

            System.out.println("Enter number of days admitted:");
            int numberOfDays = sc.nextInt();
            sc.nextLine();

            System.out.println("Enter ICU type:");
            String icuType = sc.nextLine();

            System.out.println("Enter critical care charges:");
            int charges = sc.nextInt();

            CriticalPatient cp = new CriticalPatient(
                    name, age, disease,
                    roomNumber, numberOfDays,
                    icuType, charges);

            System.out.println("\nPatient Details:");
            cp.displayPatientInfo();

            System.out.println("\nInPatient Details:");
            cp.displayInPatientInfo();

            System.out.println("\nCritical Patient Details:");
            cp.displayCriticalPatientInfo();

        } else {

            System.out.println("Enter room number:");
            int roomNumber = sc.nextInt();

            System.out.println("Enter number of days admitted:");
            int numberOfDays = sc.nextInt();

            InPatient ip = new InPatient(
                    name, age, disease,
                    roomNumber, numberOfDays);

            System.out.println("\nPatient Details:");
            ip.displayPatientInfo();

            System.out.println("\nInPatient Details:");
            ip.displayInPatientInfo();
        }

        
    }
}
class Patient {
    String name;
    int age;
    String disease;

    Patient(String name, int age, String disease) {
        this.name = name;
        this.age = age;
        this.disease = disease;
    }

    void displayPatientInfo() {
        System.out.println("Patient Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Disease: " + disease);
    }
}

class InPatient extends Patient {
    int roomNumber;
    int numberOfDays;

    InPatient(String name, int age, String disease,
              int roomNumber, int numberOfDays) {
        super(name, age, disease);
        this.roomNumber = roomNumber;
        this.numberOfDays = numberOfDays;
    }

    void displayInPatientInfo() {
        System.out.println("Room Number: " + roomNumber);
        System.out.println("Number of Days Admitted: " + numberOfDays);
    }
}

class CriticalPatient extends InPatient {
    String icuType;
    int criticalCareCharges;

    CriticalPatient(String name, int age, String disease,
                    int roomNumber, int numberOfDays,
                    String icuType, int criticalCareCharges) {

        super(name, age, disease, roomNumber, numberOfDays);
        this.icuType = icuType;
        this.criticalCareCharges = criticalCareCharges;
    }

    void displayCriticalPatientInfo() {
        System.out.println("ICU Type: " + icuType);
        System.out.println("Critical Care Charges: " + criticalCareCharges);
    }
}

