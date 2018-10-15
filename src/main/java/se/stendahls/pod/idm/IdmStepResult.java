package se.stendahls.pod.idm;

import se.stendahls.pod.DealerMapping;

public class IdmStepResult {
    private IdmRaw idmRaw;
    private DealerMapping dealerMapping;

    public void setIdmRaw(IdmRaw idmRaw) {
        this.idmRaw = idmRaw;
    }

    public IdmRaw getIdmRaw() {
        return idmRaw;
    }

    public void setDealerMapping(DealerMapping dealerMapping) {
        this.dealerMapping = dealerMapping;
    }

    public DealerMapping getDealerMapping() {
        return dealerMapping;
    }
}
