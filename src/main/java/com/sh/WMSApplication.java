package com.sh;

import com.sh.view.InWarehousingView;
import com.sh.view.MemberView;

public class WMSApplication {

    public static void main(String[] args) {
        MemberView memberView = new MemberView();
        memberView.mainMenu();
        System.out.println("✨WMS 프로그램 종료되었습니다.✨");
    }
}
