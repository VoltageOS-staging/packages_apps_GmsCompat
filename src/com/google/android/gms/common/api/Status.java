package com.google.android.gms.common.api;

import android.app.PendingIntent;
import android.app.appsearch.safeparcel.AbstractSafeParcelable;
import android.app.appsearch.safeparcel.SafeParcelable;
import android.os.Parcel;
import android.os.Parcelable;

// https://developers.google.com/android/reference/com/google/android/gms/common/api/Status
@SafeParcelable.Class(creator = "StatusCreator")
public final class Status extends AbstractSafeParcelable implements Result {
    public static final Status SUCCESS = new Status(CommonStatusCodes.SUCCESS);

    @Field(id = 1) public int statusCode;
    @Field(id = 2) public String statusMessage;
    @Field(id = 3) public PendingIntent resolution;

    @Constructor
    public Status(@Param(id = 1) int statusCode, @Param(id = 2) String statusMessage,
                  @Param(id = 3) PendingIntent resolution) {
        this.statusCode = statusCode;
        this.statusMessage = statusMessage;
        this.resolution = resolution;
    }

    public Status(int statusCode) {
        this(statusCode, null, null);
    }

    @Override
    public Status getStatus() {
        return this;
    }

    public boolean isSuccess() {
        // there is SUCCESS (0) and SUCCESS_CACHE (-1)
        return statusCode <= CommonStatusCodes.SUCCESS;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        StatusCreator.writeToParcel(this, dest, flags);
    }

    public static final Parcelable.Creator<Status> CREATOR = null;
}
