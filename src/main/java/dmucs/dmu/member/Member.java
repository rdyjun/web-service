package dmucs.dmu.member;

public class Member {
    private Grade grade;         // 권한
    private String name;         // 이름
    private String password;     // 비밀번호
    private String studentId;    // 학번
    private String phone;  // 핸드폰 번호
    private String email;        // 이메일
    private String department;   // 학과
    private String division;     // 학부

    public Member () {

    }
    public Member(Grade grade, String name, String password, String studentId, String phone, String email, String department, String division) {
        this.grade = grade;
        this.name = name;
        this.password = password;
        this.studentId = studentId;
        this.phone = phone;
        this.email = email;
        this.department = department;
        this.division = division;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }
    public String getPassword () {
        return password;
    }
    public void setPassword (String passowrd) {
        this.password = password;
    }

    public String getphone() {
        return phone;
    }

    public void setphone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDepartment() {
        return department;
    }
    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    @Override
    public String toString() {
        return "Member{" +
                "grade=" + grade +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", studentId='" + studentId + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", department='" + department + '\'' +
                ", division='" + division + '\'' +
                '}';
    }
}
