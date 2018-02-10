package com.smalaca.mocks;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FakeScenarioStorage implements ScenarioStorage {
    private Map<Author, List<Scenario>> scenarios = new HashMap<>();

    @Override
    public void add(Author author, Scenario scenario) {
        if (!scenarios.containsKey(author)) {
            scenarios.put(author, new ArrayList<Scenario>());
        }

        scenarios.get(author).add(scenario);
    }

    public int countScenarios() {
        return scenarios.size();
    }

    public int countScenariosFor(Author author) {
        if (scenarios.containsKey(author))
            return scenarios.get(author).size();
        else
            return 0;
    }
}
