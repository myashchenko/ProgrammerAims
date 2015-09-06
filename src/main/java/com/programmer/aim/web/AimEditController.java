package com.programmer.aim.web;

import com.programmer.aim.Aim;
import com.programmer.aim.AimForm;
import com.programmer.aim.service.AimService;
import com.programmer.programmer.Programmer;
import com.programmer.programmer.service.ProgrammerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * Created by kolyan on 9/6/15.
 */
@Controller
@RequestMapping(value = "aim")
public class AimEditController {

    @Autowired
    private ProgrammerService programmerService;

    @Autowired
    private AimService aimService;

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String edit(Model model) {
        Programmer programmer = programmerService.getLoggedProgrammer();
        //List<Aim> aims = aimService.getListOfProgrammerAims(programmer);
        Set<Aim> aims = programmer.getAims();
        model.addAttribute("programmer", programmer);
        return "programmer/aims-edit";
    }

    @RequestMapping(value = "/edit", params = {"remove"})
    public String remove(Model model,
                            HttpServletRequest request) {
        Programmer programmer = programmerService.getLoggedProgrammer();
        model.addAttribute("programmer", programmer);
        Integer index = Integer.valueOf(request.getParameter("remove"));
        Set<Aim> aims = programmer.getAims();
        if(!aims.isEmpty()) {
            Iterator<Aim> iterator = aims.iterator();
            while(iterator.hasNext()) {
                Aim aim = iterator.next();
                if(aim.getId().intValue() == index) {
                    aims.remove(aim);
                    aimService.delete(aim);
                }
            }
            programmerService.update(programmer);
        }
        return "programmer/aims-edit";
    }
}
