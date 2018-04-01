package com.labs.cloud.core;

import com.labs.cloud.core.model.Item;
import com.labs.cloud.core.model.Order;
import com.labs.cloud.core.model.Payment;
import com.labs.cloud.core.model.Table;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by Vikraa on 3/30/2018.
 */

@RunWith(RobolectricTestRunner.class)
@Config(constants = com.labs.cloud.core.example.BuildConfig.class)
public class FeatureTest {

    private Order mOrder;
    private Item mItem;
    private Payment mPayment;
    private Table mTable;

    private static final int ORDER_ITEM_COUNT = 100;

    @Before
    public void setup() {
        mOrder = new Order();
        List<Item> items = new ArrayList<>();
        for (int i = 0; i < ORDER_ITEM_COUNT; i++) {
            Item item = new Item();
        }
    }



}
