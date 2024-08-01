package entity;

public class MemberEntity {
    private String member_id;
    private String name;
    private String address;
    private Integer age;
    private String contact;

    
    public MemberEntity(String member_id, String name, String address, Integer age, String contact) {
        this.member_id = member_id;
        this.name = name;
        this.address = address;
        this.age = age;
        this.contact = contact;
    }


    public String getMember_id() {
        return member_id;
    }


    public void setMember_id(String member_id) {
        this.member_id = member_id;
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public String getAddress() {
        return address;
    }


    public void setAddress(String address) {
        this.address = address;
    }


    public Integer getAge() {
        return age;
    }


    public void setAge(Integer age) {
        this.age = age;
    }


    public String getContact() {
        return contact;
    }


    public void setContact(String contact) {
        this.contact = contact;
    }


    @Override
    public String toString() {
        return "MemberEntity [member_id=" + member_id + ", name=" + name + ", address=" + address + ", age=" + age
                + ", contact=" + contact + "]";
    }


    

}
