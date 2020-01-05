package org.papaja.adminfly.module.psy.tests.context;

import org.papaja.adminfly.module.psy.tests.Payload;
import org.papaja.adminfly.module.psy.tests.PayloadContext;

public class PayloadDataContext<T> extends TestContext implements PayloadContext<T> {

    private Payload<T> payload;

    @Override
    public Payload<T> getPayload() {
        return payload;
    }

    @Override
    public void setPayload(Payload<T> payload) {
        this.payload = payload;
    }

}
