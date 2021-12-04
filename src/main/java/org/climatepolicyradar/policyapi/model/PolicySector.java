package org.climatepolicyradar.policyapi.model;

public class PolicySector {
    private String policyId;
    private String sector;

    public PolicySector(String policyId, String sector) {
        this.policyId = policyId;
        this.sector = sector;
    }

    public String getPolicyId() {
        return policyId;
    }

    public void setPolicyId(String policyId) {
        this.policyId = policyId;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }
}
