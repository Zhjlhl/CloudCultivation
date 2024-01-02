package com.cloudcultivation.controller;

import com.cloudcultivation.po.Dispute;
import com.cloudcultivation.po.Service;
import com.cloudcultivation.service.DisputeService;
import com.cloudcultivation.service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jiejie
 */
@Controller
public class DisputeController {

    @Autowired
    private DisputeService disputeService;
    @Autowired
    private ServiceService serviceService;

    /*
     * @description: 跳转未审核订单
     */
    @GetMapping("/toServiceUncheck")
    public String toServiceUncheck(@RequestParam("serviceId") int serviceId,
                                   Model model){
        Service service = serviceService.selectServiceById(serviceId);
        List<Dispute> disputeList = new ArrayList<>();
        for (Dispute dispute: service.getDisputeList()){
            if (!disputeService.isDisputeResolve(dispute)){
                disputeList.add(dispute);
            }
        }
        model.addAttribute("disputes", disputeList);
        return "/service/uncheckDispute.jsp";
    }
}
