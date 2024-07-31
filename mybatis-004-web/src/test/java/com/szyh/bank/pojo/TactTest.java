package com.szyh.bank.pojo;

import com.szyh.bank.serivce.Service;
import org.junit.Test;

public class TactTest {
    @Test
    public void test() {
        Service.toForm("act-001", "act-002", 1000);
    }

}
