package com.mikhalkou.pluralsight.spring.trackzila.web;

import com.mikhalkou.pluralsight.spring.trackzila.repository.ApplicationRepository;
import com.mikhalkou.pluralsight.spring.trackzila.service.ApplicationService;
import com.mikhalkou.pluralsight.spring.trackzila.service.ReleaseService;
import com.mikhalkou.pluralsight.spring.trackzila.service.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class TrackzilaController {
    private final ApplicationService applicationService;
    private final TicketService ticketService;
    private final ReleaseService releaseService;

    @GetMapping("/applications")
    public String retrieveApplications(Model model) {
        model.addAttribute("applications", applicationService.listApplications());
        return "applications";
    }

    @GetMapping("/tickets")
    public String retrieveTickets(Model model) {
        model.addAttribute("tickets", ticketService.listTickets());
        return "tickets";
    }

    @GetMapping("/releases")
    public String retrieveReleases(Model model) {
        model.addAttribute("releases", releaseService.listReleases());
        return "releases";
    }


}
