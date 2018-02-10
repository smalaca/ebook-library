package com.smalaca.mocks;

import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.BDDMockito.given;

public class ScenarioSuitesWithMockTest {
    private ScenarioStorage scenariosStore = Mockito.mock(ScenarioStorage.class);

    @Test
    public void shouldNotAddScenarioWhenNotApproved() {
        // given
        ScenarioSuites scenarioSuites = aScenarioSuites();
        Scenario scenario = notApprovedScenario();
        Author dummyAuthor = null;

        // when
        scenarioSuites.accept(scenario, dummyAuthor);

        // then
        Mockito.verifyZeroInteractions(scenariosStore);
    }

    @Test
    public void shouldAddScenarioWhenApproved() {
        // given
        ScenarioSuites scenarioSuites = aScenarioSuites();
        Scenario scenario = anApprovedScenario();
        Author author = new Author();

        // when
        scenarioSuites.accept(scenario, author);

        // then
        Mockito.verify(scenariosStore).add(author, scenario);
    }

    @Test
    public void shouldAddScenariosWhenApproved() {
        // given
        ScenarioSuites scenarioSuites = aScenarioSuites();
        Scenario scenario1 = anApprovedScenario();
        Scenario scenario2 = anApprovedScenario();
        Scenario scenario3 = anApprovedScenario();
        Scenario scenario4 = notApprovedScenario();
        Author author1 = new Author();
        Author author2 = new Author();
        Author author3 = new Author();

        // when
        scenarioSuites.accept(scenario1, author1);
        scenarioSuites.accept(scenario2, author1);
        scenarioSuites.accept(scenario3, author2);
        scenarioSuites.accept(scenario4, author3);

        // then
        Mockito.verify(scenariosStore).add(author1, scenario1);
        Mockito.verify(scenariosStore).add(author1, scenario2);
        Mockito.verify(scenariosStore).add(author2, scenario3);
        Mockito.verifyNoMoreInteractions(scenariosStore);
    }

    private Scenario notApprovedScenario() {
        Scenario scenario = Mockito.mock(Scenario.class);
        given(scenario.isApproved()).willReturn(false);
        return scenario;
    }

    private Scenario anApprovedScenario() {
        Scenario scenario = Mockito.mock(Scenario.class);
        given(scenario.isApproved()).willReturn(true);
        return scenario;
    }

    private ScenarioSuites aScenarioSuites() {
        return new ScenarioSuites(scenariosStore);
    }

}
