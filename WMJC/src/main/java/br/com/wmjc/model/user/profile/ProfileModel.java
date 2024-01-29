package br.com.wmjc.model.user.profile;
import java.math.BigInteger;
public class ProfileModel {

    private BigInteger idProfile;
    private String profileName;
    private String picProfile;
    private String typeUser;

    public ProfileModel(){}

    public ProfileModel( String profileName, String picProfile){
        this.profileName = profileName;
        this.picProfile = picProfile;

    }

    public ProfileModel(BigInteger idProfile, String profileName, String picProfile, String typeUser){
        this.idProfile = idProfile;
        this.profileName = profileName;
        this.picProfile = picProfile;
        this.typeUser = typeUser;
    }


    public BigInteger getIdProfile() {
        return idProfile;
    }

    public void setIdProfile(BigInteger idProfile) {
        this.idProfile = idProfile;
    }

    public String getProfileName() {
        return profileName;
    }

    public void setProfileName(String profileName) {
        this.profileName = profileName;
    }

    public String getPicProfile() {
        return picProfile;
    }

    public void setPicProfile(String picProfile) {
        this.picProfile = picProfile;
    }

    public String getTypeUser() {
        return typeUser;
    }

    public void setTypeUser(String typeUser) {
        this.typeUser = typeUser;
    }

}
