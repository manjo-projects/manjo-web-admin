package org.papaja.adminfly.module.admin.controller;

import org.papaja.adminfly.commons.mvc.controller.AbstractController;
import org.papaja.adminfly.commons.dao.entity.User;
import org.papaja.adminfly.commons.dao.service.RoleService;
import org.papaja.adminfly.commons.dao.service.UserService;
import org.papaja.adminfly.commons.pojo.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.Optional;

@SuppressWarnings("unused")
@Controller
@RequestMapping("/secure/users")
@Secured("ROLE_ADMIN")
public class UserController extends AbstractController {

    @Autowired
    private UserService users;

    @Autowired
    private RoleService roles;

    @RequestMapping
    @PreAuthorize("hasAuthority('READ')")
    public ModelAndView list(
        @RequestParam(value = "page", defaultValue = "1") int page, Model model
    ) {
        model.addAttribute("pagination", users.getUsers(page));

        return newView("list");
    }

    @PreAuthorize("hasAuthority('READ')")
    @RequestMapping({"/edit/{id:[0-9]+}", "/create"})
    public ModelAndView form(
        @PathVariable(value = "id", required = false) Integer id
    ) {
        User         user  = users.getUser(id);
        ModelAndView model = newView("form");

        model.addObject("user", Optional.ofNullable(user).orElseGet(User::new));
        model.addObject("roles", roles.getRoles());

        return model;
    }

    @PreAuthorize("hasAuthority('SECURITY')")
    @RequestMapping(value = {"/process/{id:[0-9]+}", "/process"}, method = RequestMethod.POST)
    public ModelAndView process(
        @PathVariable(value = "id", required = false) Integer id,
        @Valid UserDto dto, BindingResult result, RedirectAttributes attributes
    ) {
        ModelAndView view   = newRedirect("");
        User         entity = users.getUser(id);

        if (!result.hasErrors()) {
            users.save(dto, entity);
            attributes.addFlashAttribute("message", messages.getSuccessMessage("user.saved", entity.getUsername()));
        } else {
            view = newView("form");
            view.addObject("result", result);
            view.addObject("user", Optional.ofNullable(entity).orElseGet(User::new));
            view.addObject("roles", roles.getRoles());
        }

        return view;
    }

}
