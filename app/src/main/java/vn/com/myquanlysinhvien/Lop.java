package vn.com.myquanlysinhvien;

public class Lop {
     int id;
     String malop,tenlop;
     String name;
     String date;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Lop() {
    }

    public Lop(String malop, String tenlop) {
        this.malop = malop;
        this.tenlop = tenlop;
    }

    public Lop(int id, String malop, String tenlop) {
        this.id = id;
        this.malop = malop;
        this.tenlop = tenlop;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMalop() {
        return malop;
    }

    public void setMalop(String malop) {
        this.malop = malop;
    }

    public String getTenlop() {
        return tenlop;
    }

    public void setTenlop(String tenlop) {
        this.tenlop = tenlop;
    }
}
