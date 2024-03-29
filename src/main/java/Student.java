import org.jboss.resteasy.spi.touri.MappedBy;

import javax.xml.bind.annotation.*;


@XmlRootElement
//@XmlAccessorType(XmlAccessType.NONE)
public class Student {

//    @XmlAttribute
    public String name;
//    @XmlAttribute
    public int age;
//    @XmlAttribute
    public String mobile;

    public Student() {
    }

    public Student(String name, int age, String mobile) {
        this.name = name;
        this.age = age;
        this.mobile = mobile;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}
