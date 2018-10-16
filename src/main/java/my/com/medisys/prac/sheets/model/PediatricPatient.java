package my.com.medisys.prac.sheets.model;

import java.io.Serializable;
import java.util.Date;

/**
 * @author    Medisys<devs@medisys.com.my>
 * @version   0.0.00.GA
 * @since     0.0.00.GA
 */
public class PediatricPatient implements Serializable {

    private static final long serialVersionUID = 5563571467512103969L;

    private String patientNo;
    private String familyNameEn;
    private String firstNameEn;
    private String motherFirstNameEn;
    private String motherLastNameEn;
    private Date birthDate;
    private String gender;
    private Integer socialSecurityNumber;
    private String address;
    private String city;
    private String state;
    private Integer postalCode;
    private String phoneHome;
    private Integer birthOrder;
    private String multiBirthFlag;
    private Date entryDate;
    private Date updateDate;
    private Integer updateFacility;
    private String namespaceId;
    private String universalId;
    private String universalIdType;

    public String getPatientNo() {
        return patientNo;
    }

    public void setPatientNo(String patientNo) {
        this.patientNo = patientNo;
    }

    public String getFamilyNameEn() {
        return familyNameEn;
    }

    public void setFamilyNameEn(String familyNameEn) {
        this.familyNameEn = familyNameEn;
    }

    public String getFirstNameEn() {
        return firstNameEn;
    }

    public void setFirstNameEn(String firstNameEn) {
        this.firstNameEn = firstNameEn;
    }

    public String getMotherFirstNameEn() {
        return motherFirstNameEn;
    }

    public void setMotherFirstNameEn(String motherFirstNameEn) {
        this.motherFirstNameEn = motherFirstNameEn;
    }

    public String getMotherLastNameEn() {
        return motherLastNameEn;
    }

    public void setMotherLastNameEn(String motherLastNameEn) {
        this.motherLastNameEn = motherLastNameEn;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getSocialSecurityNumber() {
        return socialSecurityNumber;
    }

    public void setSocialSecurityNumber(Integer socialSecurityNumber) {
        this.socialSecurityNumber = socialSecurityNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Integer getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(Integer postalCode) {
        this.postalCode = postalCode;
    }

    public String getPhoneHome() {
        return phoneHome;
    }

    public void setPhoneHome(String phoneHome) {
        this.phoneHome = phoneHome;
    }

    public Integer getBirthOrder() {
        return birthOrder;
    }

    public void setBirthOrder(Integer birthOrder) {
        this.birthOrder = birthOrder;
    }

    public String getMultiBirthFlag() {
        return multiBirthFlag;
    }

    public void setMultiBirthFlag(String multiBirthFlag) {
        this.multiBirthFlag = multiBirthFlag;
    }

    public Date getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(Date entryDate) {
        this.entryDate = entryDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public Integer getUpdateFacility() {
        return updateFacility;
    }

    public void setUpdateFacility(Integer updateFacility) {
        this.updateFacility = updateFacility;
    }

    public String getNamespaceId() {
        return namespaceId;
    }

    public void setNamespaceId(String namespaceId) {
        this.namespaceId = namespaceId;
    }

    public String getUniversalId() {
        return universalId;
    }

    public void setUniversalId(String universalId) {
        this.universalId = universalId;
    }

    public String getUniversalIdType() {
        return universalIdType;
    }

    public void setUniversalIdType(String universalIdType) {
        this.universalIdType = universalIdType;
    }

}
