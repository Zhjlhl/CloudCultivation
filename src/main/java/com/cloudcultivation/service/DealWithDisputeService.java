package com.cloudcultivation.service;
import com.cloudcultivation.po.Dispute;

import java.math.BigDecimal;

/**
 * @author 陈宇豪
 */
public interface DealWithDisputeService {
    /*
     * @description: 处理普通纠纷
     * @param dispute 纠纷
     * @author: 陈宇豪
     */
    public boolean DealWithDispute(int id);
    /*
     * @description: 处理其他纠纷
     * @param dispute 纠纷
     * @author: 陈宇豪
     */
    public boolean DealWithDispute(int id, String disputeState, String disputeResult, String disputeCheck,
                                   BigDecimal disputeAmount, String harvestState, String harvestNumber);
}
