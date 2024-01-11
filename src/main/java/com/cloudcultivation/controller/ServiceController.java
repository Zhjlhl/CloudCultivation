package com.cloudcultivation.controller;

import com.cloudcultivation.po.Dispute;
import com.cloudcultivation.po.Service;
import com.cloudcultivation.service.DisputeService;
import com.cloudcultivation.service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.math.BigDecimal;

/**
 * @author Jiejie
 */
@Controller
public class ServiceController {

    @Autowired
    private DisputeService disputeService;
    @Autowired
    private ServiceService serviceService;
    /*
     * @description: 提交纠纷处理结果
     * 陈宇豪
     */
    @RequestMapping("/checkDispute")
    public String checkDispute(@RequestParam("disputeId") int disputeId,@RequestParam("amount") BigDecimal amount,
                               @RequestParam("state") String state,@RequestParam("result") String result,
                               @RequestParam("serviceId") int serviceId,
                               RedirectAttributes attributes,
                               Model model){
        Dispute dispute=disputeService.selectDisputeById(disputeId);
        dispute.setAmount(amount);
        dispute.setCheck("已审核");
        dispute.setResult(result);
        dispute.setState(state);
        disputeService.updateDispute(dispute);
        Service service=serviceService.selectServiceById(serviceId);
        model.addAttribute("disputes", service.getDisputeList());
        return "/service/disputeOngoing.jsp";
    }
}
