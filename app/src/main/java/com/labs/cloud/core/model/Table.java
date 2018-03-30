package com.labs.cloud.core.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.labs.cloud.core.base.BaseModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vikraa on 3/16/2018.
 */

public class Table extends BaseModel {

    private Order mOrder;
    private int mCapacity;
    private boolean mMergedTable = false;
    private List<Table> mMergedTables;

    public static final Parcelable.Creator<Table> CREATOR = new Creator<Table>() {
        @Override
        public Table createFromParcel(Parcel source) {
            return new Table(source);
        }

        @Override
        public Table[] newArray(int size) {
            return new Table[size];
        }
    };

    public Table() {

    }

    public Table(Parcel in) {
        setId(in.readInt());
        setTimestamp(in.readString());
        this.mCapacity = in.readInt();
        this.mOrder = in.readParcelable(getClass().getClassLoader());
    }

    public Order getOrder() {
        return mOrder;
    }

    public void setOrder(Order order) {
        this.mOrder = order;
    }

    public int getCapacity() {
        return mCapacity;
    }

    public void setCapacity(int capacity) {
        this.mCapacity = capacity;
    }

    public boolean isMergedTable() {
        return mMergedTable;
    }

    public void setmMergedTable(List<Table> tables) {
        if (mMergedTables == null) {
            mMergedTables = new ArrayList<>();
        }
        for (Table t : tables) {
            mMergedTables.add(t);
        }
        mMergedTable = true;
    }

    public List<Table> getMergedTables() {
        return this.mMergedTables;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(getId());
        dest.writeString(getTimestamp());
        dest.writeInt(this.mCapacity);
        dest.writeParcelable(this.mOrder, flags);
    }
}
