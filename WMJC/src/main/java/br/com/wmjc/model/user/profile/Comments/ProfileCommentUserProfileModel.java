package br.com.wmjc.model.user.profile.Comments;

import br.com.wmjc.model.user.profile.ProfileModel;

public class ProfileCommentUserProfileModel {

    private ProfileModel userProfile;
    private ProfileComments commentProfile;
    public ProfileCommentUserProfileModel(ProfileModel userProfile, ProfileComments commentProfile) {
        this.userProfile = userProfile;
        this.commentProfile = commentProfile;
    }

    public ProfileModel getUserProfile() {
        return userProfile;
    }

    public ProfileComments getCommentProfile() {
        return commentProfile;
    }
}
