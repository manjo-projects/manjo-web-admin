package org.papaja.adminfly.module.blog.controller;

import org.papaja.adminfly.commons.mvc.controller.AbstractController;
import org.papaja.adminfly.module.blog.dto.CategoryDto;
import org.papaja.adminfly.module.blog.dto.DomainDto;
import org.papaja.adminfly.module.blog.dto.PostDto;
import org.papaja.adminfly.commons.pojo.IdsSet;
import org.papaja.adminfly.module.blog.entity.Category;
import org.papaja.adminfly.module.blog.entity.Domain;
import org.papaja.adminfly.module.blog.entity.Post;
import org.papaja.adminfly.commons.mvc.entity.Authorized;
import org.papaja.adminfly.commons.mvc.entity.User;
import org.papaja.adminfly.module.blog.mapper.CategoryMapper;
import org.papaja.adminfly.module.blog.mapper.DomainMapper;
import org.papaja.adminfly.module.blog.mapper.PostMapper;
import org.papaja.adminfly.module.blog.service.CategoryService;
import org.papaja.adminfly.module.blog.service.DomainService;
import org.papaja.adminfly.module.blog.service.PostService;
import org.papaja.adminfly.commons.mvc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

import static java.lang.String.format;

@SuppressWarnings({"unused"})
@Controller("blogIndexController")
@RequestMapping("/blog")
public class IndexController extends AbstractController {

    private static final String TO_SELECT_DOMAIN          = "/setting/selectDomain?forced=1";
    private static final String REDIRECT_TO_SELECT_DOMAIN = "redirect:/blog" + TO_SELECT_DOMAIN;

    @Autowired
    private PostService posts;

    @Autowired
    private CategoryService categories;

    @Autowired
    private UserService users;

    @Autowired
    private DomainService domains;

    @Autowired
    private CategoryMapper categoryMapper;

    @Autowired
    private DomainMapper domainMapper;

    @RequestMapping
    public String redirect() {
        String view = "redirect:/blog/posts";

        if (!domains.hasActiveDomain()) {
            view = REDIRECT_TO_SELECT_DOMAIN;
        }

        return view;
    }

    @PreAuthorize("hasAuthority('READ')")
    @RequestMapping("/posts")
    public ModelAndView list(@RequestParam(value = "page", defaultValue = "1") int page) {
        ModelAndView mav = new ModelAndView();

        if (domains.hasActiveDomain()) {
            mav.addObject("domain", domains.getActiveDomain());
            mav.addObject("result", posts.getPosts(page));
            mav.setViewName("blog/posts/list");
        } else {
            mav.setViewName(REDIRECT_TO_SELECT_DOMAIN);
        }

        return mav;
    }

    @PreAuthorize("hasAnyAuthority('CREATE', 'UPDATE')")
    @RequestMapping(value = {"/posts/create", "/posts/edit/{id:[0-9]+}"})
    public ModelAndView form(@PathVariable(value = "id", required = false) Integer id) {
        ModelAndView mav    = new ModelAndView("blog/posts/form");
        Domain       domain = domains.getActiveDomain();

        if (domains.hasActiveDomain()) {
            mav.addObject("entity", posts.getPost(id));
            mav.addObject("categories", categories.getCategories(domain));
            mav.addObject("domain", domain);
        } else {
            mav.setViewName(REDIRECT_TO_SELECT_DOMAIN);
        }

        return mav;
    }

    @PreAuthorize("hasAnyAuthority('CREATE', 'UPDATE')")
    @RequestMapping(value = {"/posts/process"})
    public ModelAndView process(PostMapper mapper, @Valid PostDto dto, BindingResult result) {
        ModelAndView mav    = newView("posts/form");
        Domain       domain = domains.getActiveDomain();

        if (domains.hasActiveDomain()) {
            if (result.hasErrors()) {
                mav.addObject("result", result);
                mav.addObject("entity", dto);
                mav.addObject("categories", categories.getCategories(domain));
            } else {
                Post post = posts.getPost(dto.getId());
                mapper.map(dto, post);

                post.setCategory(categories.getCategory(dto.getCategoryId()));
                post.setDomain(domains.getDomain(domain.getId()));

                posts.merge(post);

                if (post.isNew()) {
                    mav.setViewName("redirect:/blog/posts");
                } else {
                    mav.setViewName(format("redirect:/blog/posts/edit/%d", post.getId()));
                }
            }
        } else {
            mav.setViewName(REDIRECT_TO_SELECT_DOMAIN);
        }

        return mav;
    }

    @PreAuthorize("hasAnyAuthority('CREATE', 'UPDATE')")
    @RequestMapping(value = {"/categories", "/categories/edit/{id:[0-9]+}"})
    public ModelAndView categories(@PathVariable(value = "id", required = false) Integer id) {
        ModelAndView mav   = newView("categories/categories");
        Domain       domain = domains.getActiveDomain();

        if (domains.hasActiveDomain()) {
            mav.addObject("domain", domain);
            mav.addObject("categories", categories.getCategories(domain));
            mav.addObject("entity", categories.getCategory(id));
        } else {
            mav.setViewName(REDIRECT_TO_SELECT_DOMAIN);
        }

        return mav;
    }

    @PreAuthorize("hasAnyAuthority('CREATE', 'UPDATE')")
    @RequestMapping(value = {"/categories/process/{id:[0-9]+}", "/categories/process"}, method = RequestMethod.POST)
    public RedirectView process(
        @PathVariable(value = "id", required = false) Integer id, @Valid CategoryDto dto,
        BindingResult result, RedirectAttributes attributes
    ) {
        RedirectView redirect = newRedirectView("categories");
        Category     category = categories.getCategory(id);

        if (domains.hasActiveDomain()) {
            categoryMapper.map(dto, category);
            category.setDomain(domains.getActiveDomain());

            if (result.hasErrors()) {
                attributes.addFlashAttribute("result", result);
            } else {
                attributes.addFlashAttribute("message", messages.getSuccessMessage("blog.category.saved", category.getName()));
                categories.merge(category);
            }

        } else {
            redirect.setUrl(TO_SELECT_DOMAIN);
        }

        return redirect;
    }

    @PreAuthorize("hasAuthority('READ')")
    @RequestMapping(value = {"/setting/domains/{id:[0-9]+}", "/setting/domains"}, method = RequestMethod.GET)
    public ModelAndView domains(
        @PathVariable(value = "id", required = false) Integer id,
        Model model
    ) {
        model.addAttribute("domains", domains.getDomains());
        model.addAttribute("entity", domains.getDomain(id));

        return newView("setting/domains");
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'SUPERUSER')")
    @RequestMapping(
            value = {"/setting/domains/{id:[0-9]+}", "/setting/domains"},
            method = RequestMethod.POST
    )
    public ModelAndView process(
        @PathVariable(value = "id", required = false) Integer id,
        @Valid DomainDto dto, BindingResult result, RedirectAttributes attributes
    ) {
        ModelAndView mav    = newView("setting/domains");
        Domain       domain = domains.getDomain(id);

        domainMapper.map(dto, domain);

        if (!result.hasErrors()) {
            domains.merge(domain);
            attributes.addFlashAttribute("message", messages.getSuccessMessage("blog.domain.saved", domain.getDomain(), domain.getName()));
            mav.setViewName("redirect:/blog/setting/domains");
        } else {
            mav.addObject("entity", domain);
            mav.addObject("domains", domains.getDomains());
            mav.addObject("result", result);
        }

        return mav;
    }

    @PreAuthorize("hasAuthority('READ')")
    @RequestMapping("/setting/selectDomain/{id:[0-9]+}")
    public RedirectView select(
            @PathVariable(value = "id", required = false) Integer id,
            RedirectAttributes attributes,
            Authentication authentication
    ) {
        RedirectView redirect  = newRedirectView("posts");
        Domain       domain    = domains.getDomain(id);
        Authorized   principal = (Authorized) authentication.getPrincipal();

        if (domain.hasUserAccess(principal.getUser())) {
            attributes.addFlashAttribute("message",
                    messages.getSuccessMessage("blog.domain.accessGranted", domain.getName()));
            domains.setActiveDomain(domain);
        } else {
            redirect = newRedirectView("setting/selectDomain");
            attributes.addFlashAttribute("message", messages.getErrorMessage("text.accessDenied"));
        }

        return redirect;
    }

    @PreAuthorize("hasAuthority('READ')")
    @RequestMapping("/setting/selectDomain")
    public ModelAndView domains(
        HttpServletRequest request,
        @RequestParam(value = "forced", required = false) boolean forced
    ) {
        ModelAndView mav = newView("setting/selectDomain");

        if (forced) {
            mav.addObject("message", messages.getErrorMessage("blog.domain.selectDomain"));
        }

        mav.addObject("domains", domains.getDomains());

        return mav;
    }

    @PreAuthorize("hasAuthority('READ')")
    @RequestMapping(value = "/setting/domainAccess", method = RequestMethod.GET)
    public ModelAndView domainAccess(
            @RequestParam(value = "userId", required = false) Integer userId
    ) {
        ModelAndView mav = newView("setting/domainAccess");

        mav.addObject("active", users.getUser(userId));
        mav.addObject("users", users.getUsers());
        mav.addObject("domains", domains.getDomains());

        return mav;
    }

    @PreAuthorize("hasAuthority('SECURITY')")
    @RequestMapping(value = "/setting/domainAccess", method = RequestMethod.POST)
    public RedirectView domainAccess(
            @RequestParam(value = "userId") Integer userId,
            @ModelAttribute("ids") IdsSet ids,
            RedirectAttributes attributes
    ) {
        RedirectView mav     = newRedirectView(format("setting/domainAccess?userId=%d", userId));
        User         user    = this.users.getUser(userId);
        List<Domain> domains = this.domains.getDomains(ids.getIds());

        this.domains.removeAccessForUser(user);
        this.domains.assignAccessForUser(user, domains);

        attributes.addFlashAttribute("message", messages.getInfoMessage("blog.domain.access",
                this.domains.getDomainsNames(domains), user.getUsername()));

        return mav;
    }

}
