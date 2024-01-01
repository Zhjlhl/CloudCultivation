package com.cloudcultivation.service;

import java.math.BigDecimal;

/**
 * @author 陈宇豪
 */
public interface AuditingService {
    public boolean AuditingDispute(int id, String disputeState, String disputeResult, String disputeCheck,
                                    BigDecimal disputeAmount, String harvestState, String harvestNumber);
}
