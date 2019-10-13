package org.papaja.adminfly.module.blog.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class DomainDto {

    @NotBlank(message = "{validation.notBlank}")
    @Size(min = 6, max = 64, message = "{validation.size}")
    private String name;

    @NotBlank(message = "{validation.notBlank}")
    @Size(min = 5, max = 32, message = "{validation.size}")
    private String domain;

    public String getName() {
        return name;
    }

    public String getDomain() {
        return domain;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    @Override
    public String toString() {
        return String.format("DomainDto{name='%s', domain='%s'}", name, domain);
    }
}
