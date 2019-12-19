package org.papaja.adminfly.commons.vendor.jtwig.extension.url;

import java.util.Collection;
import java.util.Collections;

public class AbsoluteUrlPathFunction extends AbstractUrlPathFunction {

    @Override
    public Collection<String> aliases() {
        return Collections.emptyList();
    }

    @Override
    protected String getPrefixPath() {
        return getContextPath();
    }

    @Override
    public String name() {
        return "absolute";
    }

}
