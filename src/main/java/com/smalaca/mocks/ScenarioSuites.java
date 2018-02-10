package com.smalaca.mocks;

class ScenarioSuites {
    private final ScenarioStorage scenariosStore;

    ScenarioSuites(ScenarioStorage scenariosStore) {
        this.scenariosStore = scenariosStore;
    }

    void accept(Scenario scenario, Author author) {
        if (scenario.isApproved()) {
            scenariosStore.add(author, scenario);
        }
    }
}
