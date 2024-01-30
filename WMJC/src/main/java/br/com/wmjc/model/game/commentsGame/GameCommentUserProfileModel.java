package br.com.wmjc.model.game.commentsGame;

import br.com.wmjc.model.user.profile.ProfileModel;

public class GameCommentUserProfileModel
{
    private GameCommentsModel comment;
    private ProfileModel userProfile;

    public GameCommentUserProfileModel(GameCommentsModel comment, ProfileModel userProfile) {
        this.comment = comment;
        this.userProfile = userProfile;
    }

    public GameCommentsModel getComment() {
        return comment;
    }

    public ProfileModel getUserProfile() {
        return userProfile;
    }
}
