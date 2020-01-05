package org.papaja.adminfly.module.psy.tests.builder.context;

import org.papaja.adminfly.module.psy.tests.Payload;
import org.papaja.adminfly.module.psy.tests.PayloadContext;
import org.papaja.adminfly.module.psy.tests.context.PayloadDataContext;

public class PayloadContextBuilder<PayloadType>
        extends AbstractTestContextBuilder<PayloadContextBuilder<PayloadType>, PayloadContext> {

    private PayloadContext<PayloadType> context;

    public PayloadContextBuilder() {
        this.context = new PayloadDataContext();
    }

    public PayloadContextBuilder with(Payload<PayloadType> payload) {
        context.setPayload(payload);

        return self();
    }

    @Override
    public PayloadContext<PayloadType> build() {
        return context;
    }

}
