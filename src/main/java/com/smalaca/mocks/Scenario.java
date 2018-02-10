package com.smalaca.mocks;

class Scenario {
    private boolean approved = false;

    void approve() {
        approved = true;
    }

    boolean isApproved() {
        return approved;
    }
}
