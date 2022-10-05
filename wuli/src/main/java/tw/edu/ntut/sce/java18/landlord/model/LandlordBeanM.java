package tw.edu.ntut.sce.java18.landlord.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(name = "property_management")
public class LandlordBeanM implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(name = "Name", columnDefinition = "VARCHAR(10)")
  private String name;

  @Column(name = "Password", columnDefinition = "VARCHAR(64)")
  @Transient
  private String password;

  @Column(name = "Phone", columnDefinition = "VARCHAR(15)")
  private String phone;

  @Column(name = "county", columnDefinition = "VARCHAR(15)")
  private String county;

  @Column(name = "district", columnDefinition = "VARCHAR(15)")
  private String district;

  @Column(name = "Address", columnDefinition = "VARCHAR(45)")
  private String address;

  @Column(name = "Mail", columnDefinition = "VARCHAR(45)")
  private String mail;

  @Column(name = "Stamp", columnDefinition = "VARCHAR(45)")
  private String stamp;

  @Transient private String stampImg;
  @Transient private MultipartFile uploadImg;

  public LandlordBeanM() {}

  public LandlordBeanM(
      Integer id,
      String name,
      String password,
      String phone,
      String county,
      String district,
      String address,
      String mail,
      String stamp,
      String stampImg,
      MultipartFile uploadImg) {
    this.id = id;
    this.name = name;
    this.password = password;
    this.phone = phone;
    this.county = county;
    this.district = district;
    this.address = address;
    this.mail = mail;
    this.stamp = stamp;
    this.stampImg = stampImg;
    this.uploadImg = uploadImg;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public String getCounty() {
    return county;
  }

  public void setCounty(String county) {
    this.county = county;
  }

  public String getDistrict() {
    return district;
  }

  public void setDistrict(String district) {
    this.district = district;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getMail() {
    return mail;
  }

  public void setMail(String mail) {
    this.mail = mail;
  }

  public String getStamp() {
    return stamp;
  }

  public void setStamp(String stamp) {
    this.stamp = stamp;
  }

  public String getStampImg() {
    return stampImg;
  }

  public void setStampImg(String stampImg) {
    this.stampImg = stampImg;
  }

  public MultipartFile getUploadImg() {
    return uploadImg;
  }

  public void setUploadImg(MultipartFile uploadImg) {
    this.uploadImg = uploadImg;
  }
}
