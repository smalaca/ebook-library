package com.smalaca.mocks;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ScenarioSuitesWithFakeTest {
    private final FakeScenarioStorage scenariosStore = new FakeScenarioStorage();

    @Test
    public void shouldNotAddScenarioWhenNotApproved() {
        // given
        ScenarioSuites scenarioSuites = aScenarioSuites();
        Scenario scenario = new Scenario();
        Author dummyAuthor = null;

        // when
        scenarioSuites.accept(scenario, dummyAuthor);

        // then
        assertEquals(0, scenariosStore.countScenarios());
    }

    @Test
    public void shouldAddScenarioWhenApproved() {
        // given
        ScenarioSuites scenarioSuites = aScenarioSuites();
        Scenario scenario = anApprovedScenario();

        // when
        scenarioSuites.accept(scenario, new Author());

        // then
        assertEquals(1, scenariosStore.countScenarios());
    }

    @Test
    public void shouldAddScenariosWhenApproved() {
        // given
        ScenarioSuites scenarioSuites = aScenarioSuites();
        Scenario scenario1 = anApprovedScenario();
        Scenario scenario2 = anApprovedScenario();
        Scenario scenario3 = anApprovedScenario();
        Scenario scenario4 = new Scenario();
        Author author1 = new Author();
        Author author2 = new Author();
        Author author3 = new Author();

        // when
        scenarioSuites.accept(scenario1, author1);
        scenarioSuites.accept(scenario2, author1);
        scenarioSuites.accept(scenario3, author2);
        scenarioSuites.accept(scenario4, author3);

        // then
        assertEquals(2, scenariosStore.countScenariosFor(author1));
        assertEquals(1, scenariosStore.countScenariosFor(author2));
        assertEquals(0, scenariosStore.countScenariosFor(author3));
    }

    private Scenario anApprovedScenario() {
        Scenario scenario = new Scenario();
        scenario.approve();
        return scenario;
    }

    private ScenarioSuites aScenarioSuites() {
        return new ScenarioSuites(scenariosStore);
    }
}