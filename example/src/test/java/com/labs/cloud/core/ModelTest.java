package com.labs.cloud.core;

/**
 * Created by Vikraa on 3/30/2018.
 */
import android.os.Parcelable;

import com.labs.cloud.core.base.BaseModel;
import com.labs.cloud.core.example.*;
import com.labs.cloud.core.model.Item;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

@RunWith(RobolectricTestRunner.class)
@Config(constants = com.labs.cloud.core.example.BuildConfig.class)
public class ModelTest {

    @Before
    public void setup() {

    }

    @Test
    public void createItem() {
        Item item = new Item();
        item.setId(1);
        Assert.assertThat(item, CoreMatchers.instanceOf(BaseModel.class));
        Assert.assertThat(item, CoreMatchers.instanceOf(Parcelable.class));
    }
}
