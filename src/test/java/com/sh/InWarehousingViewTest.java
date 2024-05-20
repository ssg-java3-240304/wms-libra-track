package com.sh;

import com.sh.view.InWarehousingView;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class InWarehousingViewTest {

    @Test
    public void publisherManagerQueryTest() {

        String input = "1\n3\n1\n1\n0\n0\n0\n0";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        InWarehousingView.PUB_MANAGER_ID = 1;
        InWarehousingView.PUB_ID = 1;

        InWarehousingView.inWarehousingPublisherMenu();

    }

    @Test
    public void publisherManagerCommandTest() {

        String input = "2\n1234586970\n5\nexit";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        InWarehousingView.PUB_MANAGER_ID = 1;
        InWarehousingView.PUB_ID = 1;
        InWarehousingView.PUB_MANAGER = "희민";

        InWarehousingView.inWarehousingPublisherMenu();

    }
}
