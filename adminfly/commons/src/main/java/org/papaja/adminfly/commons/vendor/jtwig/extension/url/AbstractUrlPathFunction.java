package org.papaja.adminfly.commons.vendor.jtwig.extension.url;

import org.jtwig.functions.FunctionRequest;
import org.jtwig.functions.JtwigFunction;
import org.jtwig.value.WrappedCollection;
import org.jtwig.value.convert.Converter.Result;
import org.jtwig.value.environment.ValueEnvironment;
import org.jtwig.web.servlet.ServletRequestHolder;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;
import java.util.Collections;

import static java.lang.String.format;
import static org.apache.commons.lang3.StringUtils.substringBefore;
import static org.springframework.util.StringUtils.trimLeadingCharacter;

abstract public class AbstractUrlPathFunction implements JtwigFunction {

    @Override
    public Collection<String> aliases() {
        return Collections.singletonList("url");
    }

    @Override
    public Object execute(FunctionRequest request) {
        request.minimumNumberOfArguments(1).maximumNumberOfArguments(3);

        UriComponentsBuilder builder = UriComponentsBuilder.newInstance();

        builder.path(getPath(request));

        if (request.getNumberOfArguments() > 1) {
            getCollection(request, 1).get()
                    .forEach(entry -> builder.queryParam(entry.getKey(), entry.getValue()));
        }

        if (request.getNumberOfArguments() > 2) {
            getCollection(request, 2).get()
                    .forEach(entry -> builder.replaceQueryParam(entry.getKey(), entry.getValue()));
        }

        return builder.toUriString();
    }

    protected String getPath(FunctionRequest request) {
        return getPrefixPath() + getString(request, 0);
    }

    protected String getString(FunctionRequest request, int index) {
        return getValueEnvironment(request).getStringConverter().convert(request.get(index));
    }

    protected Result<WrappedCollection> getCollection(FunctionRequest request, int index) {
        return getValueEnvironment(request).getCollectionConverter().convert(request.get(index));
    }

    protected ValueEnvironment getValueEnvironment(FunctionRequest request) {
        return request.getEnvironment().getValueEnvironment();
    }

    protected HttpServletRequest getServletRequest() {
        return ServletRequestHolder.get();
    }

    protected String getContextPath() {
        return getServletRequest().getContextPath();
    }

    abstract protected String getPrefixPath();

}
