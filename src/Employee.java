public class Employee {

    String isim;
    double salary;
    int hireYear;
    int workHours;
    int thatYear = 2021;

    double salaryFinal;
    double bonus;
    double nonTaxedSalary;
    double taxx;

    public Employee(String isim, double salary, int workHours, int hireYear) {
        this.isim = isim;
        this.salary = salary;
        this.workHours = workHours;
        this.hireYear = hireYear;
    }

    public double tax() {

        if (salary >= 1000) {
            this.taxx = this.salaryFinal * 0.03;
            return this.salaryFinal * 0.03;//%3 vergi hesaplandi
        } else {
            return this.salaryFinal;//vergi uygulanmayacak.
        }

    }

    public double bonus() {


        if (this.workHours > 40) {
            return bonus = (workHours - 40) * 30; // 40 saat ustu 30tl bonus
        } else {
            return bonus = 0; // 40 saat ve altina bonus yok!
        }

    }

    public void raiseSalary() {
        double salaryRaise = 0;
        int workingYears = this.thatYear - this.hireYear;
        if (workingYears <= 9) {
            salaryRaise = this.salary * 0.05;
        } else if (workingYears >= 10 & workingYears < 20) {
            salaryRaise = this.salary * 0.10;
        } else { //20 yil ve daha fazla ise
            salaryRaise = this.salary * 0.15;
        }
        this.salaryFinal += this.salary;
        this.salaryFinal += salaryRaise;// ciplak maas uzerinden calisma saatine ve calisma yilina gore maas primi eklendi
        this.salaryFinal += bonus();
        this.nonTaxedSalary = salaryFinal; // vergi dusulmemis maas
        this.salaryFinal -= tax(); // ciplak maas + extralar uzerinden vergiler dusuruldu

    }

    public static void main(String[] args) {
        //Const. -->isci olusturuldu
        Employee worker = new Employee("Hayrullah DEDELER", 15000, 42, 2015);

        //Maas duzenlenmesi icin raiseSalary() method'u kullanildi
        worker.raiseSalary();

        //Ciktimiz...
        System.out.println(worker.toString());


    }

    @Override
    public String toString() {
        return "Calisan Bilgileri : \n" +
                "__________________" + "\n" +
                "isim - soyisim : " + isim + "\n" +
                "ciplak maas : " + salary + " TL\n" +
                "ise girdigi yil : " + hireYear + "\n" +
                "haftalik calisma saati :" + workHours + " saat\n" +
                "iscinin calisma saatine gore kazandigi prim (BONUS) : " + bonus + " TL\n" +
                "iscinin odemis oldugu vergi tutari (TAX) : " + this.taxx + " TL\n" +
                "maas artisi (Raise Salary) : " + (this.salaryFinal - this.salary) + " TL\n" +
                "vergisi dusulmemis maas  : " + this.nonTaxedSalary + " TL\n" +
                "iscinin eline gecen toplam maas (Toplam Maas) : " + this.salaryFinal + " TL";

    }
}
