import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Student {
    private String id,name,telephone,city,country,group;
    private Date dob;
    private int year;
    public Student(){};
    public void DisplayStudent(){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println("Student ID: "+getId());
        System.out.println("Student Name: "+getName());
        System.out.println("Date of birth: " + format.format(getDob()));
        System.out.println("City: "+getCity());
        System.out.println("Country: "+getCountry());
        System.out.println("Group: "+getGroup());
        System.out.println("Tel: "+getTelephone());

    }
    public void dataInput(){
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println("Input student Id: ");
        setId(sc.nextLine());
        System.out.println("Input student Name: ");
        setName(sc.nextLine());
        System.out.println("Input year of study: ");
        setYear(Integer.parseInt(sc.nextLine()));
        System.out.println("Input phone number: ");
        setTelephone(sc.nextLine());
        System.out.println("Input city: ");
        setCity(sc.nextLine());
        System.out.println("Input country: ");
        setCountry(sc.nextLine());
        System.out.println("Input group: ");
        
        try {
            setGroup(sc.nextLine());
        } catch (GroupNameException e) {
            System.out.println(e);
        }
        System.out.println("Input date of birth in format yyyy-mm-dd: ");
        String dob = sc.nextLine();

        try {
            Date d = format.parse(dob);
            try {
                setDob(d);
            } catch (Exception e) {
                System.out.println(e);
            }
            
        } catch (ParseException e) {
            throw new IllegalArgumentException("Invalid date");
        }
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        Except.checkEmptyBlankNull(name, "Student name");
        this.name = name;
    }
    public String getTelephone() {
        return telephone;
    }
    public void setTelephone(String tel) {
        char[] num = tel.toCharArray();
        if(num.length< 9 || num.length>10 || num[0] !='0')
            throw new IllegalArgumentException("Telephone should start with 0 and conatain only 9 or 10 characters");
        for(int i=0;i<num.length;i++){
            if(!(num[i]>='0' && num[i]<='9'))
                throw new IllegalArgumentException("Telephone should contain only number from \'0\' to \'9\'");
        } 
        this.telephone = tel;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        Except.checkEmptyBlankNull(city, "City");
        this.city = city;
    }
    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        Except.checkEmptyBlankNull(country,"Country");
        this.country = country;
    }
    public String getGroup() {
        return group;
    }
    public void setGroup(String group) throws GroupNameException {
        char[] gr = group.toCharArray();
        if(gr[0] != 'I' && gr[0] != 'T'){
            System.out.println("group: "+gr[0]);
            throw new GroupNameException("Group must begin with I or T");
        }
        int y = gr[1];
        if(y>5 && y<1){
            throw new GroupNameException("Invalid year");
        }
        if(gr.length<5){
            for(int i =2; i< gr.length;i++){
                if(!(gr[i]>='A' && gr[i]<='Z'))
                    throw new GroupNameException("Group should be ended by Latin alphabets");
            }
        }else{
            throw new GroupNameException("Group should contain maximum 4 characters");
        }
 
        this.group = group;

    }
    public Date getDob() {
        return dob;
    }
    public void setDob(Date dob) throws BirthdayException {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, cal.get(Calendar.YEAR) - 15);
        Date fifteen = cal.getTime();
        if (dob.compareTo(fifteen) > 0)
            throw new BirthdayException();
        this.dob = dob;
    }
    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        if(year > 5 || year <1){
            throw new IllegalArgumentException("minimum year is  1 and maximum is 5");
        }
        this.year = year;
    }
    public static void main(String[] args) {
        Student s = new Student();
        s.dataInput();
        s.DisplayStudent();
    }
}
