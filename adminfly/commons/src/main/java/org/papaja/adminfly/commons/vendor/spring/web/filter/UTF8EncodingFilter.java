package org.papaja.adminfly.commons.vendor.spring.web.filter;

import org.springframework.web.filter.CharacterEncodingFilter;

final public class UTF8EncodingFilter extends CharacterEncodingFilter {{
    setForceEncoding(true);
    setEncoding("UTF-8");
}}
