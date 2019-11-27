package org.papaja.adminfly.module.admin.controller;

import org.papaja.adminfly.commons.mvc.controller.AbstractController;
import org.papaja.adminfly.commons.pojo.RoleDto;
import org.papaja.adminfly.commons.mvc.entity.Privilege;
import org.papaja.adminfly.commons.mvc.entity.Role;
import org.papaja.adminfly.commons.mvc.service.PrivilegeService;
import org.papaja.adminfly.commons.mvc.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/secure/authority")
public class AuthorityController extends AbstractController {

    @Autowired
    private PrivilegeService privileges;

    @Autowired
    private RoleService roles;

    @Autowired
    private MessageSource ms;

    @PreAuthorize("hasAuthority('READ')")
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView list(Model model) {

        model.addAttribute("roles", roles.getRoles());
        model.addAttribute("privileges", privileges.getPrivileges());

        return newView("list");
    }

    @RequestMapping(value = "/role/edit/{id:[0-9]+}", method = RequestMethod.GET)
    @PreAuthorize("hasAuthority('READ')")
    public ModelAndView edit(@PathVariable("id") Integer id) {
        ModelAndView model = newView("role/form");

        model.addObject("role", roles.getRole(id));
        model.addObject("privileges", privileges.getPrivileges());

        return model;
    }

    @PreAuthorize("hasAuthority('SECURITY')")
    @RequestMapping(value = "/{entity:[a-z]+}/remove/{id:[0-9]+}", method = RequestMethod.GET)
    public ModelAndView remove(
        @PathVariable("entity") String name,
        @PathVariable("id") Integer id,
        RedirectAttributes attributes
    ) {
        switch (name) {
            case "role":
                roles.remove(id);
                break;
            case "privilege":
                privileges.remove(id);
                break;
        }

        attributes.addFlashAttribute("message",
                getMessage("authority.record.removed", getMessage(String.format("label.%s", name)), id));

        return newRedirect("");
    }

    @PreAuthorize("hasAuthority('SECURITY')")
    @RequestMapping(value = {"/process/privilege/{id:[0-9]+}", "/process/privilege"}, method = RequestMethod.POST)
    public ModelAndView privileges(
        @PathVariable(value = "id", required = false) Integer id,
        @Valid Privilege privilege,
        final BindingResult result, RedirectAttributes attributes
    ) {
        if (result.hasErrors()) {
            attributes.addFlashAttribute("id", id);
            attributes.addFlashAttribute("result", result);
        } else {
            privilege.setName(privilege.getName().toUpperCase());
            privileges.merge(privilege);
        }

        return newRedirect("");
    }

    @PreAuthorize("hasAuthority('SECURITY')")
    @RequestMapping(value = {"/process/role/{id:[0-9]+}", "/process/role"}, method = RequestMethod.POST)
    public ModelAndView roles(
        @PathVariable(value = "id", required = false) Integer id, @Valid RoleDto dto, BindingResult result, RedirectAttributes attributes
    ) {
        ModelAndView view = newRedirect("");

        if (!result.hasErrors()) {
            Role role = roles.getRole(id);
            roles.store(dto, role);
            attributes.addFlashAttribute("message", getMessage("authority.role.saved", dto.getName()));
        } else {
            view.setViewName("role/form");
            view.addObject("role", roles.getRole(id));
            view.addObject("privileges", privileges.getPrivileges());
            view.addObject("result", result);
        }

        return view;
    }

}
