package com.jckc_backer;


public class SyncParams<T> {
    private T syncBody;

    public T getSyncBody() {
        return syncBody;
    }

    public void setSyncBody(T syncBody) {
        this.syncBody = syncBody;
    }
}
