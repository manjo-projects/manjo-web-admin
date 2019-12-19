package org.papaja.adminfly.commons.vendor.jtwig.extension.url;

import static java.lang.String.format;
import static org.apache.commons.lang3.StringUtils.substringBefore;
import static org.springframework.util.StringUtils.trimLeadingCharacter;

public class RelativeUrlPathFunction extends AbstractUrlPathFunction {

    @Override
    protected String getPrefixPath() {
        return getContextPath() + getServletSubPath();
    }

    @Override
    public String name() {
        return "relative";
    }

    protected String getServletSubPath() {
        String path = substringBefore(trimLeadingCharacter(getServletRequest().getServletPath(), '/'), "/");

        return path.isBlank() ? "" : format("/%s", path);
    }

}
