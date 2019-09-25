package org.papaja.adminfly.core.vendor.jtwig.extension.asset.resolver;

import org.jtwig.spring.asset.resolver.AssetResolver;
import org.jtwig.web.servlet.ServletRequestHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.resource.ResourceUrlProvider;

import javax.servlet.http.HttpServletRequest;

import static java.lang.String.format;
import static java.util.Optional.ofNullable;

@SuppressWarnings({"unused"})
public class ResourceUrlBasedAssetResolver implements AssetResolver {

    @Autowired
    private ResourceUrlProvider provider;

    private String prefix;

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    @Override
    public String resolve(String asset) {
        String path = format("%s/%s", ofNullable(getPrefix()).orElseGet(String::new), asset);

        return getServletRequest().getContextPath() + provider.getForLookupPath(path);
    }

    protected HttpServletRequest getServletRequest() {
        return ServletRequestHolder.get();
    }

}
