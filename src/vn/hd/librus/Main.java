package vn.hd.librus;

import vn.hd.librus.model.Role;
import vn.hd.librus.views.BookMenuView;
import vn.hd.librus.views.LibrarianView;
import vn.hd.librus.views.MemberView;
import vn.hd.librus.views.UserView;

public class Main {
    public static void main(String[] args) {
        UserView userView = new UserView();
        userView.login();
    }
}

